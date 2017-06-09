import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Surya on 6/9/17.
 */
public class CategoryDatabase {

    CategoryDatabase() {
        costliestCategory = null;
        costliestPrice = -1.0;
        datMap = new HashMap<>();
        highestFrequency = Integer.MIN_VALUE;
        mostFrequentlyVisitedPlace = "";
    }


    boolean addExpenditure(String category, String place,
                           String description, double price) {
        boolean categoryExists = datMap.containsKey(category);
        if (categoryExists) {
            Category toManipulate = datMap.get(category);
            toManipulate.categoricalInsertion(place, price, description);
        } else {
            Category toAdd = new Category(category);
            toAdd.categoricalInsertion(place, price, description);
            datMap.put(category, toAdd);
        }
        Category justAdded = datMap.get(category);
        if (justAdded.getTotalExpense() > costliestPrice) {
            ArrayList<String> newCostliestCategory = new ArrayList<>();
            newCostliestCategory.add(category);
            costliestPrice = justAdded.getTotalExpense();
            costliestCategory = newCostliestCategory;
        } else if (justAdded.getTotalExpense() == costliestPrice) {
            costliestCategory.add(category);
        }
        return categoryExists;
    }

    String highestCosts() {
        String toReturn = String.valueOf(costliestPrice) + "\n";
        for (String cat : costliestCategory) {
            toReturn += (cat + "\n");
        }
        return toReturn;
    }

    Category getCategory(String cat) {
        return datMap.get(cat);
    }



    HashMap<String, Category> datMap;

    ArrayList<String> costliestCategory;

    double costliestPrice;

    int highestFrequency;

    String mostFrequentlyVisitedPlace;
}
