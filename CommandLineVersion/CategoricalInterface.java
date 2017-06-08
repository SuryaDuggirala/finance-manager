import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Surya on 6/2/17.
 */
public class CategoricalInterface {
    CategoricalInterface() {
        categories = new HashMap<>();
    }

    void insertNewCategory (String catName, String place, double price) {
        Category toInsert = new Category(catName);
        toInsert.categoricalInsertion(place, price);
    }

    void insertIntoCategory(String catName, String place, double price) {
        Category toManipulate = categories.get(catName);
        toManipulate.categoricalInsertion(place, price);
    }

    HashMap<String, Category> categories;
}
