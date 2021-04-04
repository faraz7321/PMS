/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        try {
            //FileReader file = new FileReader("employeeData.txt");
            File file = new File("employeeData.txt");
            //BufferedReader br = new BufferedReader(file);
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

    public void loadItems() {
        try {
            //FileReader file = new FileReader("employeeData.txt");
            File file = new File("itemsData.txt");
            //BufferedReader br = new BufferedReader(file);
            try (Scanner scanner = new Scanner(file)) {
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
            }
        } catch (FileNotFoundException e) {
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

    public void loadRequests() {
        try {
            //FileReader file = new FileReader("employeeData.txt");
            File file = new File("requests.txt");
            //BufferedReader br = new BufferedReader(file);
            try (Scanner scanner = new Scanner(file)) {
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
            }
        } catch (FileNotFoundException e) {
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

}
