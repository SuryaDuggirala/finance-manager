import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


/** Parser class that takes an input file and splits its data into a series
    of tables. Essentially, I'm building a database of items for fun. */
class Parser {
    Parser(String fileName) throws AnalyticsException {
        _dataMap = new CategoryDatabase();
        _toParse = new File(fileName);
        _categoryNames = new HashSet<>();
        try {
            Scanner scanFile = new Scanner(_toParse);
            int marker = 0;
            while (scanFile.hasNextLine()) {
                String category = "";
                String place = "";
                String description = "";
                double price = 0.0;

                category = scanFile.nextLine();
                place = scanFile.nextLine();
                description = scanFile.nextLine();
                price = Double.parseDouble(scanFile.nextLine());

                add(category, place,
                        description, price);

            }
        } catch (FileNotFoundException file) {
            throw new AnalyticsException("File not found.");
        }
    }


    // HELPER METHODS

    private boolean add(String category, String place,
                String description, double price) {
        // todo integrate category database
        return _dataMap.addExpenditure(category, place,
                description, price);

    }

    /** Contains mappings from names of categories to Categories. */
    static CategoryDatabase _dataMap;

    /** The target file containing my expenses. */
    File _toParse;

    HashSet<String> _categoryNames;
}
