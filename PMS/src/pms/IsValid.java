/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pms;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Faraz Ahmad
 */
public class IsValid {

    static IsValid isValid;

    static IsValid getInstance() {
        if (isValid == null) {
            isValid = new IsValid();

        }
        return isValid;
    }

    private static final String regex = "^(.+)@(.+)$";

    /**
     *
     * @param text
     * @return
     */
    public boolean text(String text) {
        boolean flag = false;
        char[] arr = text.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] >= 'a' && arr[i] <= 'z') || (arr[i] >= 'Z' && arr[i] <= 'Z') || arr[i] == ' ') {
                flag = true;
            } else {
                flag = false;
            }
        }

        return flag;
    }

    /**
     *
     * @param email
     * @return
     */
    public boolean email(String email) {
        boolean flag = false;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            System.out.println("Valid");
            flag = true;
        } else {
            System.out.println("Invalid");
            flag = false;
        }
        return flag;
    }

    /**
     *
     * @param cell
     * @return
     */
    public boolean cell(String cell) {
        boolean flag = false;
        if (cell.matches("[0-9]+")) {
            flag = true;
            System.out.println("Valid");
        } else {
            flag = false;
            System.out.println("Invalid");
        }

        return flag;
    }

    /*char[] arr = cell.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= '0' && arr[i] >= '9') {
                flag = true;
                System.out.println("Valid");
            } else {
                flag = false;
                System.out.println("Invalid");
            }
        }*/
}
