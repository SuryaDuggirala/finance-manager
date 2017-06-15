import java.util.ArrayList;

/**
 * Created by Surya on 6/15/17.
 */
public class Place implements Comparable {
    Place(String name) {
        freq = 1;
        this.name = name;
        items = new ArrayList<>();
    }

    boolean insertItems(ArrayList<Item> allItems) {
        if (allItems.size() == 0) {
            return false;
        } else {
            for (Item item : allItems) {
                items.add(item);
            }
            freq += 1;
            return true;
        }
    }

    @Override
    public int compareTo(Object o) {
        Place place = (Place) o;
        if (freq > place.getFreq()) {
            return 1;
        } else if (freq < place.getFreq()) {
            return -1;
        } else {
            return 0;
        }
    }

    int getFreq() {
        return freq;
    }

    private int freq;

    private String name;

    ArrayList<Item> items;
}
