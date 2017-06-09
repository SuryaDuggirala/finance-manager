/**
 * Created by Surya on 6/1/17.
 */
class Analyze {
    private final String FILENAME = "expenses.md";
    public Analyze() throws  AnalyticsException {
        parseFile = new Parser(FILENAME);
        db = parseFile._dataMap;

    }

    public Object commandInterface(String command) {
        return costliestExpense();
    }

    String costliestExpense() {
        return db.highestCosts();
    }

    String mostCommonlyVisitedPlace() {
        return "";
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
        return;
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
