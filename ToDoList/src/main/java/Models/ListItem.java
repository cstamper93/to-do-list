package Models;

public class ListItem {

    private int itemId;
    private String item;

    public ListItem(int itemId, String item) {
        this.itemId = itemId;
        this.item = item;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getItemId(int itemId) {
        return this.itemId;
    }

    public String getItem() {
        return this.item;
    }

    @Override
    public String toString() {
        return "ListItem{" +
                "itemId=" + itemId +
                ", item='" + item + '\'' +
                '}';
    }
}
