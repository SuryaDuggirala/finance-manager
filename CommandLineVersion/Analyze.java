/**
 * Created by Surya on 6/1/17.
 */
public class Analyze {
    private final String FILENAME = "expenses.md";
    public Analyze() throws  AnalyticsException {
        parseFile = new Parser(FILENAME);
    }

    String costliestExpenditure() {
        return parseFile.costliestExpense();
    }

    static Parser parseFile;

    // ---- MAIN ---- //
    public static void main(String[] args) throws AnalyticsException {
        Analyze analyze = new Analyze();
        System.out.println("IMPLEMENT INTERFACE.");
    }
}
