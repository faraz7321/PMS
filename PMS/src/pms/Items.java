package pms;

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

    public boolean addItem() {
        boolean flag = false;
        return flag;
    }

    public boolean deleteItem() {
        boolean flag = false;
        return flag;
    }

    public boolean updateItem() {
        boolean flag = false;
        return flag;
    }

}
