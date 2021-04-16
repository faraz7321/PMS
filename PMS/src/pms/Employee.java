package pms;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Faraz Ahmad
 */
public class Employee {

    static Employee employee;

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

    public String getEmpCode(String emp) {
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

    static boolean requestItem(String item, int quantity) {
        Admin obj = Admin.getInstance();
        Requests req = new Requests();
        req.setItemName(item);
        req.setQuantity(quantity);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String strDate = formatter.format(date);
        req.setDate(strDate);
        obj.request.add(req);
        return true;
    }

}
