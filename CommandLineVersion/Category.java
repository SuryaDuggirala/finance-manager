import java.util.HashMap;
import java.util.LinkedList;

class Category {

    Category(String catName) {
        _catName = catName;
        totalExpense = 0;
        expendituresByPlace = new HashMap<>();
    }

    void categoricalInsertion(String place, double price) {
        // TAKE CARE OF CASE WHEN I DON'T ADD A PLACE
        // ALSO NORMALIZE PLACE NAMES
        if (place.equals(""))
            place = "n/a";
        else
            place = place.toLowerCase();


        if (expendituresByPlace.containsKey(place)) {
            expendituresByPlace.get(place).add(price);
        } else {
            expendituresByPlace.put(place, new LinkedList<>());
            expendituresByPlace.get(place).add(price);
        }
        totalExpense += price;
    }

    String printExpendituresFrom(String place) {
        LinkedList<Double> prices = expendituresByPlace.get(place);
        String finalString = "";
        if (prices != null) {
            for (Double price : prices) {
                finalString += "$" + price + "\n";
            }
            return finalString;
        } else {
            return "No Expenditures at this venue.";
        }
    }

    Double expensesAt(String place) throws AnalyticsException {
        place = place.toLowerCase();
        try {
            LinkedList<Double> allExpenses = expendituresByPlace.get(place);
            double total = 0.0;
            for (Double price : allExpenses) {
                total += price;
            }
            return total;
        } catch (NullPointerException error) {
            throw new AnalyticsException("You haven't visited this place.");
        }
    }

    @Override
    public String toString() {
        String finalString = _catName + "\n";
        for (String place : expendituresByPlace.keySet()) {
            finalString += place + ": ";
            finalString += printExpendituresFrom(place);
        }
        finalString += ("Total expenditures in this category: $" + totalExpense);
        return finalString;
    }

    String _catName;
    HashMap<String, LinkedList<Double>> expendituresByPlace;
    double totalExpense;
}
