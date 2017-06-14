import java.util.Calendar;
import java.util.Date;

/**
 * Created by Surya on 6/9/17.
 */
public class Item {

    public Item(Double price, String description) {
        this.price = price;
        this.description = description;
        timeStamp = new Calendar() {
            @Override
            protected void computeTime() {

            }

            @Override
            protected void computeFields() {

            }

            @Override
            public void add(int field, int amount) {

            }

            @Override
            public void roll(int field, boolean up) {

            }

            @Override
            public int getMinimum(int field) {
                return 0;
            }

            @Override
            public int getMaximum(int field) {
                return 0;
            }

            @Override
            public int getGreatestMinimum(int field) {
                return 0;
            }

            @Override
            public int getLeastMaximum(int field) {
                return 0;
            }
        };
    }



    Double getPrice() {
        return price;
    }

    String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description
                + "\n" + String.valueOf(price);

    }

    String description;
    Double price;
    Calendar timeStamp;
}
