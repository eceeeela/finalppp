import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class Manager extends Login{


    public Manager(String name, int id) {
        super(name, id);
    }

    public void generateInventoryReport() {
        try {
            // Read all lines from the SQL file
            Path filePath = Paths.get("inventory.sql");
            List<String> lines = Files.readAllLines(filePath);

            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
