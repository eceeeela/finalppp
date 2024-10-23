public class Currency {
    public static int NUM_ITEMS = 2;
    public static String getCurrency(int item) {
        switch (item) {
            case 0: return "CAD";
            case 1: return "USD";

        }
        return "Error: bad item number";

    }
}
