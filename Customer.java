import NoodleFactory.*;
import java.util.Scanner;
import NoodleBuilder.*;

class Customer{

    int cash;
    int credit = 1000;
    int debit = 1000;

    State[] states;
    State currentState;

    TaxAgency TaxAgency;


    public Customer(State[] states) {

        this.cash = 1000;
        this.credit = 1000;
        this.debit = 1000;


        for (int i = 0; i < Items.NUM_ITEMS; i++) {
            itemQuantities[i] = 0;
        }

        this.states = states;
        currentState = states[(int) (Math.random() * states.length)];
        currentState.print();
        System.out.println();
    }

    void printCustomerOption() {
        System.out.println("You have $" + cash+" cad cash");
        System.out.println("You have $" + credit+" cad credit limit");
        System.out.println("You have $" + debit+" cad debit limit");
//
//        for (int i = 0; i < Items.NUM_ITEMS; i++) {
//            if (itemQuantities[i] > 0) {
//                System.out.println("you have " +
//                    itemQuantities[i] + " " +
//                    Items.getItemName(i)
//                );
//            }
//        }

        System.out.println("Pick an option:");

        System.out.println("    1. Choose state");
        System.out.println("    2. Choose food");
        System.out.println("    3. Remove food");
        System.out.println("    4. Check out");

    }

    void doCustomerOption(int choice) {
        switch (choice) {

            case 1:
                printState();
                break;
            case 2:
                chooseItems();
                break;
            case 3:
                removeItems();
                break;
            case 4:
                checkOut();
                break;
                default:
                System.out.println("Invalid option");
        }

    }
    void checkOut () {
        System.out.println("this is your reciept");

        for (int i = 0; i < Items.NUM_ITEMS; i++) {
            String item = Items.getItemName(i);
            int itemcadprice = State.getItemBuyPrice(i);
            int itemusdprice = State.getItemUsPrice(i);
            int itemtaxcadprice = State.getItemTaxBuyPrice(i);
            int itemtaxusdprice = State.getItemTaxUsPrice(i);

            int quantity = itemQuantities[i];
            int cost = 0;
            if (quantity != 0) {
                System.out.println(+quantity + " " + item);

                //reciept
                cost = quantity * itemcadprice;
                double taxcost=quantity * itemtaxcadprice;
                double taxcostusd=quantity * itemtaxusdprice;

                double costusd = quantity * itemusdprice;
                System.out.println("here is your reciet" );
                System.out.println("total price in cad is " + cost);
                System.out.println("total price in usd is " + costusd);
                System.out.println("total price after tax in cad is " + taxcost);
                System.out.println("total price after tax in usd is " + taxcostusd);


                System.out.println("would you like to pay be cad or usd?");
                currentState.printCurrency();
                int choice = Main.getIntInRange(1, Currency.NUM_ITEMS);

                if (choice == 1) {
                    double pay = taxcost;
                    System.out.println("You have chooesd cad you need to pay  " + pay);
                    System.out.println("How would you want to pay?");
                    currentState.printPayment();
                    int method = Main.getIntInRange(1, Payment.NUM_ITEMS);
                    switch (method) {
                        case 1:
                            cash -= pay;
                            System.out.println("You have payed" + pay + " in cash");
                            break;
                        case 2:
                            credit -= pay;
                            System.out.println("You have payed" + pay + " in credit");
                            break;
                        case 3:
                            debit -= pay;
                            System.out.println("You have payed" + pay + " in debit");
                            break;

                    }


                } else if (choice == 2) {
                    double payusd = taxcostusd;
                    System.out.println("You have chooesd usd you need to pay  " + payusd);
                    System.out.println("How would you want to pay?");
                    currentState.printPayment();
                    int method = Main.getIntInRange(1, Payment.NUM_ITEMS);
                    switch (method) {
                        case 1:
                            cash -= payusd;
                            System.out.println("You have payed" + payusd + " in cash");
                            break;
                        case 2:
                            credit -= payusd;
                            System.out.println("You have payed" + payusd + " in credit");
                            break;

                        case 3:
                            debit -= payusd;
                            System.out.println("You have payed" + payusd + " in debit");
                            break;

                    }
                }

            }
        }

    }



    void printState() {
        System.out.println("What way do you want to place your order ?");

        for (int i = 0; i < states.length; i++) {
            System.out.print("    " + (i + 1) + ". " + states[i].name);
            if (states[i] == currentState) {
                System.out.print(" (current choice)");
            }
            System.out.println();
        }
        int choice = Main.getIntInRange(1, states.length);

        if (states[choice - 1] == currentState) {
            System.out.println("You are already with " + currentState.name);
            return;
        }

        currentState = states[choice - 1];
    }

    void chooseItems() {
        System.out.println("What do you want to buy?");
        currentState.printBuyPrices();
        int choice = Main.getIntInRange(1, Items.NUM_ITEMS);

        System.out.println("How many do you want to buy?");
        int quantity = Main.getIntInRange(1, 50);


        itemQuantities[choice - 1] += quantity;

        System.out.println("You choose " + quantity + " " + Items.getItemName(choice - 1));

    }
    void removeItems(){
        System.out.println("What do you want to remove");
        currentState.printBuyPrices();
        int choice = Main.getIntInRange(1, Items.NUM_ITEMS);

        System.out.println("How many do you want to remove?");
        int quantity = Main.getIntInRange(1, 50);

        if ( itemQuantities[choice-1]<quantity) {
            System.out.println("You don't have enough quantity");
            return;
        }

        int new_quantity= itemQuantities[choice - 1] - quantity;

        System.out.println("You have " + new_quantity + " " + Items.getItemName(choice - 1));

    }






}
