package pms;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Faraz Ahmad
 */
public class Admin {

    static Admin admin;
    public ArrayList<Items> item;
    public ArrayList<Employee> employees;
    public ArrayList<Requests> request;

    private Admin() {
        item = new ArrayList<>();
        employees = new ArrayList<>();
        request = new ArrayList<>();
    }

    static Admin getInstance() {
        if (admin == null) {
            admin = new Admin();

        }
        return admin;
    }
    //Admin obj = Admin.getInstance();

    public void loadData() {
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

    public void loadItems() {
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
                it.setBarcode(arr[5]);
                item.add(it);
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }

    public void loadRequests() {
        try {
            request.removeAll(request);
            Scanner scanner = new Scanner(new File("requests.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] arr = line.split(",");
                Requests reqs = new Requests();
                reqs.setEmpcode(arr[0]);
                reqs.setEmail(arr[1]);
                reqs.setItemName(arr[2]);
                reqs.setQuantity(Integer.parseInt(arr[3]));
                reqs.setDate(arr[4]);
                reqs.setStatus(arr[5]);
                request.add(reqs);
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }

    public void saveData() {

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

    public void exitSave() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Choose a destination to save exported file");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String filename = chooser.getSelectedFile() + ".csv";
            try {
                FileWriter fw = new FileWriter(filename);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("Name,Email,Contact,EMP Code\n");
                for (int i = 0; i < employees.size(); i++) {
                    bw.write(employees.get(i).getName() + ","
                            + employees.get(i).getEmail() + ","
                            + employees.get(i).getCell() + ","
                            + employees.get(i).getEmpCode() + "," + "\n");
                }
                bw.flush();
                bw.close();
                fw.close();
            } catch (IOException ex) {
            }
        } else {
            System.out.println("No Selection ");
        }
    }

    public void saveItems() {
        try {
            try (FileWriter myWriter = new FileWriter("itemsData.txt")) {
                for (int i = 0; i < item.size(); i++) {
                    Items it = item.get(i);
                    myWriter.write(it.getItemName() + "," + it.getCategory() + "," + it.getPrice() + "," + it.getQuantity() + "," + it.getIsConsumable() + "," + it.getBarcode() + "\n");
                }
            }
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    public void saveRequests() {
        try {
            try (FileWriter myWriter = new FileWriter("requests.txt")) {
                for (int i = 0; i < request.size(); i++) {
                    Requests it = request.get(i);
                    myWriter.write(it.getEmpcode() + "," + it.getEmail() + "," + it.getItemName() + "," + it.getQuantity() + "," + it.getDate() + "," + it.getStatus() + "\n");
                }
            }
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    public boolean addEmployee(String name, String email, String cell, String code) {
        Employee e = new Employee();
        e.setName(name);
        e.setEmail(email);
        e.setCell(cell);
        e.setEmpCode(code);
        employees.add(e);
        saveData();
        return true;
    }

    public boolean updateEmployee(String name, String email, String cell, String code) {
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

    public boolean deleteEmployee(String code) {
        boolean flag = false;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmpCode().equals(code)) {
                int x = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this employee?");
                switch (x) {
                    case 0:
                        employees.remove(i);
                        saveData();
                        JOptionPane.showMessageDialog(null, "Employee Deleted Successfully!");
                        flag = true;
                        break;
                    case 1:
                        flag = true;
                        break;
                    default:
                        flag = true;
                        break;
                }
                break;
            }
        }
        return flag;
    }

    public boolean searchEmployee(String code) {
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

    public boolean searchItem(String name) {
        boolean flag = false;
        for (int i = 0; i < item.size(); i++) {
            if (item.get(i).getItemName().equals(name)) {
                //String x=JOptionPane.showInputDialog("Are you sure you want to delete this employee");
                //employees.remove(i);
                flag = true;
                break;
            }
        }
        return flag;
    }

    public boolean addItem(String name, String category, int price, int quantity, String consm) {
        Items it = new Items();
        it.setItemName(name);
        it.setCategory(category);
        it.setPrice(price);
        it.setQuantity(quantity);
        it.setIsConsumable(consm);
        Random rand = new Random(); //instance of random class
        int upperbound = 10000;
        //generate random values from 0-9999
        int bar = rand.nextInt(upperbound);
        it.setBarcode(String.valueOf(bar));
        saveItems();
        item.add(it);
        return true;
    }

    public boolean updateItem(String search, String name, String category, int price, int quantity, String consm) {
        boolean flag = false;
        for (int i = 0; i < item.size(); i++) {
            if (item.get(i).getBarcode().equals(search)) {
                Items e = new Items();
                item.get(i).setItemName(name);
                item.get(i).setCategory(category);
                item.get(i).setPrice(price);
                item.get(i).setQuantity(quantity);
                item.get(i).setIsConsumable(consm);
                saveItems();
                //employees.add(e);
                flag = true;
                break;
            }
        }
        return flag;
    }

    public boolean deleteItem(String code) {
        boolean flag = false;
        for (int i = 0; i < item.size(); i++) {
            if (item.get(i).getBarcode().equals(code)) {
                int x = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this item?");
                if (x == 0) {
                    item.remove(i);
                    saveItems();
                    JOptionPane.showMessageDialog(null, "Item Deleted Successfully!");
                    flag = true;
                } else if (x == 1) {
                    flag = true;
                } else {
                    flag = true;
                }
                break;
            }
        }
        return flag;
    }

    public boolean Login(String email, String empCode) {
        boolean flag = false;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmail().equals(email) && employees.get(i).getEmpCode().equals(empCode)) {
                flag = true;
                break;
            }
        }

        return flag;
    }

    public String empDet(String email) {
        String emp = "";
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmail().equals(email)) {
                emp = employees.get(i).getEmpCode();
                break;
            }
        }
        return emp;
    }

    public int quantity(String itemname) {
        int q = 0;
        for (int i = 0; i < item.size(); i++) {
            if (itemname.equals(item.get(i).getItemName())) {
                q = item.get(i).getQuantity();
                break;
            }
        }
        return q;
    }

    public void printReceipt(String empcode, String email, String itemname, String quant, String date) {
        Random rand = new Random();
        String receiptID = "";
        for (int j = 0; j < 4; j++) {
            Random r = new Random();
            int nn = rand.nextInt(10);
            receiptID += String.valueOf(nn);
        }
        try {
            try (FileWriter myWriter = new FileWriter(receiptID + ".txt")) {
                myWriter.write("REQUEST APPROVED!\n\n"
                        + "RECEIPT ID: " + receiptID
                        + "\n\nEMP CODE: " + empcode
                        + "\nEMAIL: " + email
                        + "\nITEM: " + itemname
                        + "\nQuantity: " + quant
                        + "\nDATE: " + date
                        + "\n\nSignature: ");
            }
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

}
