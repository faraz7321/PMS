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
public class Admin {

    static ArrayList<Items> item = new ArrayList<>();
    static ArrayList<Employee> employees = new ArrayList<>();
    static ArrayList<Requests> request = new ArrayList<>();

    static void loadData() {
        employees.removeAll(employees);
        try {
            Scanner br = new Scanner(new File("employeeData.txt"));
            while (br.hasNextLine()) {
                String line = br.nextLine();
                String[] arr = line.split(",");
                Employee e = new Employee();
                e.setName(arr[0]);
                e.setEmail(arr[1]);
                e.setCell(arr[2]);
                e.setEmpCode(arr[3]);
                employees.add(e);
                System.out.println(line);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("An error occurred.");
        }

    }

    static void loadItems() {
        try {
            item.removeAll(item);
            Scanner scanner = new Scanner(new File("itemsData.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] arr = line.split(",");
                Items it = new Items();
                it.setItemName(arr[0]);
                it.setCategory(arr[1]);
                it.setPrice(Integer.parseInt(arr[2]));
                it.setQuantity(Integer.parseInt(arr[3]));
                it.setIsConsumable(arr[4]);
                item.add(it);
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }

    static void loadRequests() {
        try {
            request.removeAll(request);
            Scanner scanner = new Scanner(new File("requests.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] arr = line.split(",");
                Requests reqs = new Requests();
                reqs.setEmpcode(arr[0]);
                reqs.setEmpName(arr[1]);
                reqs.setItemName(arr[2]);
                reqs.setQuantity(Integer.parseInt(arr[3]));
                reqs.setDate(arr[4]);
                request.add(reqs);
                System.out.println(line);
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

    static void saveItems() {
        try {
            try (FileWriter myWriter = new FileWriter("itemsData.txt")) {
                for (int i = 0; i < item.size(); i++) {
                    Items it = item.get(i);
                    myWriter.write(it.getItemName() + "," + it.getCategory() + "," + it.getPrice() + "," + it.getIsConsumable() + "\n");
                }
            }
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    static void saveRequests() {
        try {
            try (FileWriter myWriter = new FileWriter("requests.txt")) {
                for (int i = 0; i < item.size(); i++) {
                    Requests it = request.get(i);
                    myWriter.write(it.getEmpcode() + "," + it.getEmpName() + "," + it.getItemName() + "," + it.getQuantity() + it.getDate() + "\n");
                }
            }
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    static boolean addEmployee(String name, String email, String cell, String code) {
        Employee e = new Employee();
        e.setName(name);
        e.setEmail(email);
        e.setCell(cell);
        e.setEmpCode(code);
        employees.add(e);
        saveData();
        return true;
    }

    static boolean updateEmployee(String name, String email, String cell, String code) {
        boolean flag = false;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmpCode().equals(code)) {
                Employee e = new Employee();
                employees.get(i).setName(name);
                employees.get(i).setEmail(email);
                employees.get(i).setCell(cell);
                employees.get(i).setEmpCode(code);
                saveData();
                //employees.add(e);
                flag = true;
                break;
            }
        }
        return flag;
    }

    static boolean deleteEmployee(String code) {
        boolean flag = false;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmpCode().equals(code)) {
                //String x=JOptionPane.showInputDialog("Are you sure you want to delete this employee");
                employees.remove(i);
                flag = true;
                saveData();
                break;
            }
        }
        return flag;
    }

    static boolean searchEmployee(String code) {
        boolean flag = false;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmpCode().equals(code)) {
                //String x=JOptionPane.showInputDialog("Are you sure you want to delete this employee");
                //employees.remove(i);
                flag = true;
                break;
            }
        }
        return flag;
    }

    static boolean addItem(String name, String category, int price, int quantity, String consm) {

        Items it = new Items();
        it.setItemName(name);
        it.setCategory(category);
        it.setPrice(price);
        it.setQuantity(quantity);
        it.setIsConsumable(consm);
        item.add(it);
        return true;
    }

    static boolean deleteItem(String name) {
        boolean flag = false;
        for (int i = 0; i < employees.size(); i++) {
            if (item.get(i).getItemName().equals(name)) {
                item.remove(i);
                flag = true;
                break;
            }
        }
        return flag;
    }

    private Admin() {
    }

}
