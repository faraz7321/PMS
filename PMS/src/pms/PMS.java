package pms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Faraz Ahmad
 */
public class PMS {

    static ArrayList<Employee> employees = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        loadData();
        Login login = new Login();
        login.setVisible(true);
    }

    static void loadData() {
        try {
            File file = new File("employeeData.txt");
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] arr = line.split(",");
                    Employee e = new Employee();
                    e.setName(arr[0]);
                    e.setEmail(arr[1]);
                    e.setCell(arr[2]);
                    e.setEmpCode(arr[3]);
                    employees.add(e);
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }

    static void saveData() {
        try {
            try (FileWriter myWriter = new FileWriter("employeeData.txt")) {
                for (int i = 0; i < employees.size(); i++) {
                    Employee e = employees.get(i);
                    myWriter.write(e.getName() + "," + e.getEmail() + "," + e.getCell() + "," + e.getEmpCode() + "\n");
                }

            }
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}
