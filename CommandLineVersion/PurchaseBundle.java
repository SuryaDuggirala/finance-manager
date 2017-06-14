import java.util.ArrayList;

/**
 * Created by Surya on 6/12/17.
 */
public class PurchaseBundle {
    PurchaseBundle() {
        this.bundle = new ArrayList<>();
        _date = null;
    }

    String _date;

    ArrayList<Item> bundle;
}
