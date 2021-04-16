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

    public Items(ArrayList<Admin> admin) {

    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getBarcode() {
        return barcode;
    }

    public Items() {

    }

    public String getItemName() {
        return itemName;
    }

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getIsConsumable() {
        return isConsumable;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setIsConsumable(String isConsumable) {
        this.isConsumable = isConsumable;
    }

}
