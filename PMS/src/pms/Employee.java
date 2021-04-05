package pms;

import java.text.SimpleDateFormat;
import java.util.Date;

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

    static boolean requestItem(String item, int quantity) {
        Requests req = new Requests();
        req.setItemName(item);
        req.setQuantity(quantity);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String strDate = formatter.format(date);
        req.setDate(strDate);
        Admin.request.add(req);
        return true;
    }

}
