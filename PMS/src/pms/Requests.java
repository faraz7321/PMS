/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pms;

/**
 *
 * @author Faraz Ahmad
 */
public class Requests {

    private String empcode;
    private String empName;
    private String itemName;
    private int quantity;
    private String date;

    public void setEmpcode(String empcode) {
        this.empcode = empcode;
    }

    public String getEmpcode() {
        return empcode;
    }

    /**
     *
     * @return
     */
    public String getEmpName() {
        return empName;
    }

    /**
     *
     * @return
     */
    public String getItemName() {
        return itemName;
    }

    /**
     *
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     *
     * @return
     */
    public String getDate() {
        return date;
    }

    /**
     *
     * @param empName
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    /**
     *
     * @param itemName
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     *
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     *
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

}
