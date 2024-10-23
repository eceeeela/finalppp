import java.io.*;
import java.util.Scanner;



public class Login {

    private String name;
    private int id;

    public Login(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public boolean login(String enteredName, int enteredId) {
        return this.name.equals(enteredName) && this.id == enteredId;
    }


    public void updateInventory(String productName, int newQuantity) {
        try {
            // Read SQL file
            File file = new File("inventory.sql");
            Scanner scanner = new Scanner(file);
            StringBuilder sqlScript = new StringBuilder();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(productName)) {
                    // Update the quantity for the specified product
                    line = line.replaceFirst("\\d+$", String.valueOf(newQuantity));
                }
                sqlScript.append(line).append("\n");
            }
            scanner.close();

            // Write the updated SQL script back to the file
            FileWriter writer = new FileWriter(file);
            writer.write(sqlScript.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
