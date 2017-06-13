import java.util.Calendar;
import java.util.Date;

/**
 * Created by Surya on 6/1/17.
 */
class Analyze {
    private final String FILENAME = "expenses.txt";
    public Analyze() throws  AnalyticsException {
        parseFile = new Parser(FILENAME);
        db = parseFile._dataMap;

    }

    public Object commandInterface(String command) {
        command = command.toLowerCase();
        if (command.equals("print")) {
            printTransactionHistory();
        } else if (command.equals("highest cost place")) {
            mostCommonlyVisitedPlace();
        } else if (command.equals("lowest cost place")) {
            return "YOUR CODE HERE!";
        } else if (command.equals("highest cost category")) {
            return costliestExpense();
        } else if (command.equals("lowest cost category")) {
            return "YOUR CODE HERE!";
        } else if (command.equals("in budget")) {
            return "YOUR CODE HERE!";
        } else if (command.equals("budget")) {
            return "YOUR CODE HERE!";
        } else if (command.equals("trends")) {
            // TODO ADD TREND FUNCTIONALITY
            if (false) {
                categoricalTrendMap(null);
            } else if (false) {
                trendMapByPlace(null);
            } else if (false) {
                moneySpentOn(null);
            } else if (false) {
                cumulativeTrendMap();
            } else if (false) {
                moneySpentSince(null);
            }
        } else if (command.equals("plan my month")) {

        } else if (command.equals("bank balance")) {

        } else if (command.equals("total")) {
            return totalExpenditures();
        } else {
            System.out.println("Invalid command.");
        }
        return null;
    }

    String costliestExpense() {
        return db.highestCosts();
    }

    String mostCommonlyVisitedPlace() {
        return db.mostFrequentlyVisitedPlace;
    }

    String mostCommonlyVisitedPlaceByCategory(String category) {
        Category cat = db.getCategory(category);
        if (cat == null) {
            return "There are no entries in this category";
        } else {
            return cat.getMostCommonlyVisitedPlace();
        }
    }

    void printTransactionHistory() {
        db.print();
    }

    double totalExpenditures() {
        return 0.0;
    }

    double moneySpentSince(String date) {
        return 0.0;
    }

    double moneySpentOn(String date) {
        return 0.0;
    }

    void cumulativeTrendMap() {
        return;
    }

    void categoricalTrendMap(String category) {
        return;
    }

    void trendMapByPlace(String place) {
        return;
    }



    static Parser parseFile;

    CategoryDatabase db;
}
