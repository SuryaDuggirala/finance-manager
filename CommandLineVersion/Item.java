/**
 * Created by Surya on 6/9/17.
 */
public class Item {
    public Item(Double price, String description) {
        this.price = price;
        this.description = description;
    }

    Double getPrice() {
        return price;
    }

    String getDescription() {
        return description;
    }

    String description;
    Double price;
}
