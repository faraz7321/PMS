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

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public String getEmpCode() {
        return empCode;
    }

    /**
     *
     * @param emp
     * @return
     */
    public String getEmpCode(String emp) {
        return empCode;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @return
     */
    public String getCell() {
        return cell;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param empCode
     */
    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @param cell
     */
    public void setCell(String cell) {
        this.cell = cell;
    }

    static boolean requestItem(String empcode, String empemail, String item, String quantity) {
        Requests req = new Requests();
        req.setEmail(empemail);
        req.setEmpcode(empcode);
        req.setItemName(item);
        req.setQuantity(Integer.parseInt(quantity));
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String strDate = formatter.format(date);
        req.setDate(strDate);
        req.setStatus("pending");
        Admin.getInstance().request.add(req);
        Admin.getInstance().saveRequests();
        return true;
    }

    /**
     *
     * @return
     */
    public final Object[] printTableData() {
        // DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        //  model.getDataVector().removeAllElements();
        Admin.getInstance().loadRequests();
        Object[] row = new Object[4];
        for (int i = 0; i < Admin.getInstance().request.size(); i++) {
            if (Admin.getInstance().request.get(i).getEmail().equals(Login.empemail)) {
                Requests e = Admin.getInstance().request.get(i);
                row[0] = e.getItemName();
                row[1] = String.valueOf(e.getQuantity());
                row[2] = e.getDate();
                row[3] = e.getStatus();
                //model.addRow(row);
            }
        }
        return row;
        // return

    }

}
