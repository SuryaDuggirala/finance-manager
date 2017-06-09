import java.util.HashMap;
import java.util.LinkedList;

class Category {

    Category(String catName) {
        printer = new PrintUtils();
        _catName = catName;
        totalExpense = 0;
        expendituresByPlace = new HashMap<>();
    }

    void categoricalInsertion(String place, double price) {

    }

    /** Returns the total expenditures from a particular location.
     *  It also prints out the individual expenses along with descriptions.
     *  @param place is the place in question.
     *  @param printAll a utility boolean. Just for convenience. */
    Double printExpendituresFrom(String place, boolean printAll) {
        printer.print(place);
        printer.printMajorBoundary();
        LinkedList<Item> allItems = expendituresByPlace.get(place);
        double totalPrice = 0;
        for (Item i : allItems) {
            totalPrice += i.getPrice();
            if (printAll) {
                printer.print(i);
                printer.printMinorBoundary();
            }
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        return _catName + "\n" + String.valueOf(totalExpense);
    }

    String _catName;
    HashMap<String, LinkedList<Item>> expendituresByPlace;
    double totalExpense;
    PrintUtils printer;
}
