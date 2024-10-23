public class TaxAgency {
    State state;
    static int[] taxbuyPrices = new int[Items.NUM_ITEMS];
    static int[] taxusPrices = new int[Items.NUM_ITEMS];

    static public int getItemTaxBuyPrice(int i) {
        return taxbuyPrices[i];
    }
    public static int getItemTaxUsPrice(int i) {
        return taxusPrices[i];
    }



    public void TaxAgency(){

        for (int i = 0; i < Items.NUM_ITEMS; i++) {


            taxbuyPrices[i] = (int) (1.15 * state.buyPrices[i]);
            taxusPrices[i] = (int) (1.15 * state.usPrices[i]);

        }
    }
}
