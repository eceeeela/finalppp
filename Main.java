import java.util.Scanner;

public class Main {

    static Scanner input;

    static int getIntInRange(int lower, int upper) {
        int choice = -1;
        while (choice < lower || choice > upper) {
            System.out.println(
                    "Please enter a number between " + lower + " and " + upper
            );
            try {
                choice = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.out.println("This is not a number");
            }
        }
        return choice;
    }

    public static void main(String[] args) {

        State loginState = new State("Login");

        State[] states = new State[5];
        states[0] = new State("Direct Delivery");
        states[1] = new State("Place Order");
        states[2] = new State("Uber");
        states[3] = new State("Remove Item");
        states[4] = loginState;

        Customer player = new Customer(states);

        input = new Scanner(System.in);

        while (true) {
            // print the user menu
            player.printOptions();
            System.out.println();

            // get the user's choice
            int choice = getIntInRange(1, 5);
            System.out.println();

            if (choice == 5) {
                // Handle "Login" state
                System.out.print("Enter your name: ");
                String enteredName = input.nextLine();
                System.out.print("Enter your ID: ");
                int enteredId = getIntInRange(1, Integer.MAX_VALUE);

                // Check login
                Login user = authenticateUser(enteredName, enteredId);

                if (user != null) {
                    System.out.println("Login successful!");
                    if (user instanceof Manager) {
                        Manager manager = (Manager) user;
                        manager.generateInventoryReport();
                    } else if (user instanceof Owner) {
                        Owner owner = (Owner) user;
                        owner.giveDiscount(user, null);
                    }
                } else {
                    System.out.println("Invalid credentials!");
                }
            } else {
                player.doOption(choice);
            }
        }
    }

    private static Login authenticateUser(String enteredName, int enteredId) {

        Login[] users = new Login[]{
                new Manager("manager", 1),
                new Owner("owner", 2)
        };

        for (Login user : users) {
            if (user.login(enteredName, enteredId)) {
                return user;
            }
        }

        return null;
    }
}
