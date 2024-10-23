public class Payment {
    public static int NUM_ITEMS = 3;

    public static String getPayment(int item) {
        switch (item) {
            case 0:
                return "cash";
            case 1:
                return "credit";
            case 2:
                return "debit";

        }
        return "Error: bad item number";
    }
}
