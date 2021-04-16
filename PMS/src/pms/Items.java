package pms;

import java.util.ArrayList;

/**
 *
 * @author Faraz Ahmad
 */
public class Items {

    private String itemName;
    private String category;
    private int price;
    private int quantity;
    private String isConsumable;
    private String barcode;
    ArrayList<Admin> admin = new ArrayList<>();

    /**
     *
     * @param admin
     */
    public Items(ArrayList<Admin> admin) {

    }

    /**
     *
     * @param barcode
     */
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    /**
     *
     * @return
     */
    public String getBarcode() {
        return barcode;
    }

    /**
     *
     */
    public Items() {

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
    public String getCategory() {
        return category;
    }

    /**
     *
     * @return
     */
    public int getPrice() {
        return price;
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
    public String getIsConsumable() {
        return isConsumable;
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
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     *
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
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
     * @param isConsumable
     */
    public void setIsConsumable(String isConsumable) {
        this.isConsumable = isConsumable;
    }

}
