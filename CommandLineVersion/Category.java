import java.util.HashMap;
import java.util.LinkedList;

class Category {

    Category(String catName) {
        _catName = catName;
        totalExpense = 0;
    }

    void categoricalInsertion(String place, double price) {
        if (expendituresByPlace.containsKey(place)) {
            expendituresByPlace.get(place).add(price);
        } else {
            expendituresByPlace.put(place, new LinkedList<>());
            expendituresByPlace.get(place).add(price);
        }
        totalExpense += price;
    }

    void printExpendituresFrom(String place) {
        LinkedList<Double> prices = expendituresByPlace.get(place);
        if (prices != null) {
            for (Double price : prices) {
                System.out.println("$" + price);
            }
        } else {
            System.out.println("No Expenditures at this venue.");
        }
    }

    String _catName;
    HashMap<String, LinkedList<Double>> expendituresByPlace;
    double totalExpense;
}
