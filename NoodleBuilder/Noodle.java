package NoodleBuilder;

public class Noodle {
    private String NoodleName;

    private int Price;

    public void display(){
        System.out.println("Bread name: " + this.NoodleName);

        System.out.println("Price: " + this.Price);
    }

    public void setNoodleName(String noodleName) {
        NoodleName = noodleName;
    }

    public String getNoodleName() {
        return NoodleName;
    }


    public int getPrice() {
        return Price;
    }

    public void setPrice(int money) {
        Price = money;
    }
}
