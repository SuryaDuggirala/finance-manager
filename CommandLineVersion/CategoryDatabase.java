import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Surya on 6/9/17.
 */
public class CategoryDatabase {

    CategoryDatabase() {
        costliestCategory = null;
        costliestPrice = -1.0;
        datMap = new HashMap<>();
        highestCategoryFrequency = -1;
        highestPlaceFrequency = -1;
        mostFrequentlyVisitedPlace = "";
        totalCost = 0;
    }


    boolean addExpenditure(String category, String place,
                           String description, double price) {
        totalCost += price;
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
        if (justAdded.getHighestFrequencyByPlace() > highestPlaceFrequency) {
            highestPlaceFrequency = justAdded.getHighestFrequencyByPlace();
            mostFrequentlyVisitedPlace = justAdded.getMostCommonlyVisitedPlace();
        }
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

    Category containsPlace(String place) {
        return places.get(place);
    }

    double getTotalCost() {
        return totalCost;
    }

    String print() {
        double total = 0;
        for (String cat : datMap.keySet()) {
            System.out.println("CATEGORY: " + cat);
            System.out.println("--------------");
            Category catPrint = datMap.get(cat);
            catPrint.printAllExpenditures();
            total += catPrint.getTotalExpense();
        }
        System.out.println("TOTAL EXPENDITURES: " + total);
        return "";
    }

    HashMap<String, Category> datMap;

    ArrayList<String> costliestCategory;

    double costliestPrice;

    int highestCategoryFrequency;

    int highestPlaceFrequency;

    String mostFrequentlyVisitedPlace;

    HashMap<String, Category> places;

    double totalCost;


}
