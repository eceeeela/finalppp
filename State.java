class State {

    String name;






    static public int getItemBuyPrice(int i) {
        return buyPrices[i];
    }
    public static int getItemUsPrice(int i) {
        return usPrices[i];
    }
    static public int getItemTaxBuyPrice(int i) {
        return taxbuyPrices[i];
    }
    public static int getItemTaxUsPrice(int i) {
        return taxusPrices[i];
    }





    public State(String name) {
        this.name = name;

        // Generate random item prices for the city when we create it
        
    }


    public void print() {
        System.out.println("You are  " + name);
        System.out.println("Item prices:");
        printItems();
    }



    public void printCurrency() {
        for (int i = 0; i < Currency.NUM_ITEMS; i++) {
            System.out.println(
                    "    " + (i + 1) + " " + Currency.getCurrency(i)


            );
        }
    }
    public void printPayment() {
        for (int i = 0; i < Payment.NUM_ITEMS; i++) {
            System.out.println(
                    "    " + (i + 1) + " " + Payment.getPayment(i)


            );
        }
    }


}
