import java.io.*;
import java.util.Scanner;

public class Owner extends Login{

    public Owner(String name, int id) {
        super(name, id);
    }
    public void fireEmployee(int employeeId) {
        try {
            // Read SQL file
            File file = new File("employee.sql");
            Scanner scanner = new Scanner(file);
            StringBuilder sqlScript = new StringBuilder();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (!parts[0].equals(String.valueOf(employeeId))) {
                    sqlScript.append(line).append("\n");
                }
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

    public void hireEmployee(String employeeName, int employeeId) {
        try {

            File file = new File("employee.sql");
            PrintWriter writer = new PrintWriter(new FileWriter(file, true));

            String line = "INSERT INTO employee (id, name) VALUES ('" + employeeName + "', " + employeeId + ");";
            writer.println(line);

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void createSchedule(int employeeId, String newSchedule) {
        try {
            // Read SQL file
            File file = new File("employee.sql");
            Scanner scanner = new Scanner(file);
            StringBuilder sqlScript = new StringBuilder();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts[0].equals(String.valueOf(employeeId))) {

                    parts[2] = "'" + newSchedule + "'";
                    line = String.join(",", parts) + ";";
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
    public void setNewSalary(int employeeId, int newSalary) {
        try {
            // Read SQL file
            File file = new File("employee.sql");
            Scanner scanner = new Scanner(file);
            StringBuilder sqlScript = new StringBuilder();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts[0].equals(String.valueOf(employeeId))) {

                    parts[3] = String.valueOf(newSalary);
                    line = String.join(",", parts) + ";";
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

    public void giveDiscount(Login login, State state) {
        double discount = 0.0;

        if (login instanceof Manager) {
            discount = 0.1;  // 10% discount for manager
        } else if (login instanceof Owner) {
            discount = 1.0;  // 100% discount for owner (free)
        }


        for (int i = 0; i < Items.NUM_ITEMS; i++) {
            int itemCadPrice = state.getItemBuyPrice(i);
            int discountedCadPrice = (int) (itemCadPrice * (1.0 - discount));
            state.buyPrices[i] = discountedCadPrice;

            int itemUsdPrice = state.getItemUsPrice(i);
            int discountedUsdPrice = (int) (itemUsdPrice * (1.0 - discount));
            state.usPrices[i] = discountedUsdPrice;
        }

        System.out.println("Discount applied successfully!");
    }


}
