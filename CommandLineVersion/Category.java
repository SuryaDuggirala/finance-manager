import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;


class Category {

    Category(String catName) {
        printer = new PrintUtils();
        _catName = catName;
        totalExpense = 0;
        expendituresByPlace = new HashMap<>();
        locationFrequency = new HashMap<>();
        highestFrequencyByPlace = 0;
        lowestFrequencyByPlace = 0;
        mostCommonlyVisitedPlace = "";
        leastCommonlyVisitedPlace = "";
    }

    boolean categoricalInsertion(String place, double price, String description) {
        totalExpense += price;
        if (expendituresByPlace.containsKey(place)) {
            Item newItem = new Item(price, description);
            LinkedList<Item> alreadyHere = expendituresByPlace.get(place);
            alreadyHere.add(newItem);
            int frequency = locationFrequency.get(place);
            locationFrequency.put(place, frequency++);

            if (frequency > highestFrequencyByPlace) {
                highestFrequencyByPlace = frequency;
                mostCommonlyVisitedPlace = place;
            }
            return true;
        } else {
            LinkedList<Item> addTo = new LinkedList<>();
            Item newItem = new Item(price, description);
            addTo.add(newItem);
            expendituresByPlace.put(place, addTo);
            locationFrequency.put(place, 1);
            if (highestFrequencyByPlace < 1) {
                highestFrequencyByPlace = 1;
                mostCommonlyVisitedPlace = place;
            }
            return false;
        }
    }





    Double printAllExpenditures() {
        for (String place : expendituresByPlace.keySet()) {
            printExpendituresFrom(place, true);
        }
        return totalExpense;
    }

    /** Returns the total expenditures from a particular location.
     *  It also prints out the individual expenses along with descriptions.
     *  @param place is the place in question.
     *  @param printAll a utility boolean. Just for convenience. */
    Double printExpendituresFrom(String place, boolean printAll) {
        printer.printDelineation(place);
        LinkedList<Item> allItems = expendituresByPlace.get(place);
        double totalPrice = 0;
        for (int i = 0; i < allItems.size() - 1; i++) {
            Item item = allItems.get(i);
            totalPrice += item.getPrice();
            if (printAll) {
                printer.print(item);
                printer.printMinorBoundary();
            }
            System.out.println("\n");
        }
        Item lastItem = allItems.get(allItems.size() - 1);
        totalPrice += lastItem.getPrice();
        if (printAll) {
            printer.print(lastItem);
        }
        printer.printMajorBoundary();
        System.out.println("\n");
        return totalPrice;
    }

    String getMostCommonlyVisitedPlace() {
        return mostCommonlyVisitedPlace;
    }

    double getTotalExpense() {
        return totalExpense;
    }

    int getHighestFrequencyByPlace() {
        return highestFrequencyByPlace;
    }

    @Override
    public String toString() {
        return _catName + "\n" + String.valueOf(totalExpense);
    }

    private String _catName;

    private HashMap<String, LinkedList<Item>> expendituresByPlace;

    private double totalExpense;

    private PrintUtils printer;


    private HashMap<String, Integer> locationFrequency;

    private int highestFrequencyByPlace;

    private String mostCommonlyVisitedPlace;

    private int lowestFrequencyByPlace;

    private String leastCommonlyVisitedPlace;

    PriorityQueue<Item> itemsQueue;

    PriorityQueue<Item> placesQueue;
}
