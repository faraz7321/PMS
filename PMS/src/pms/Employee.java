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
public class Employee {

    private String name;
    private String empCode;
    private String email;
    private String cell;

    public String getName() {
        return name;
    }

    public String getEmpCode() {
        return empCode;
    }

    public String getEmail() {
        return email;
    }

    public String getCell() {
        return cell;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

}
