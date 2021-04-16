package pms;

/**
 *
 * @author Faraz Ahmad
 */
public class Requests {

    private String empcode;
    private String empEmail;
    private String itemName;
    private int quantity;
    private String date;
    private String status;

    /**
     *
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param empcode
     */
    public void setEmpcode(String empcode) {
        this.empcode = empcode;
    }

    /**
     *
     * @return
     */
    public String getEmpcode() {
        return empcode;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return empEmail;
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
     * @param empEmail
     */
    public void setEmail(String empEmail) {
        this.empEmail = empEmail;
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
