import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


/** Parser class that takes an input file and splits its data into a series
    of tables. Essentially, I'm building a database of items for fun. */
class Parser {
    Parser(String fileName) throws AnalyticsException {
        _dataMap = new HashMap<>();
        _toParse = new File(fileName);
        _categoryNames = new HashSet<>();
        try {
            Scanner scanFile = new Scanner(_toParse);
            int marker = 0;
            while (scanFile.hasNextLine()) {
                String category = "";
                String place = "";
                double price = 0.0;

                category = scanFile.nextLine();
                place = scanFile.nextLine();
                price = Double.parseDouble(scanFile.nextLine());

                if (!categoryExists(category)) {
                    createCategory(category);
                }
                insertIntoCategory(category, place, price);
            }
        } catch (FileNotFoundException file) {
            throw new AnalyticsException("File not found.");
        }
    }



    // HELPER METHODS
    String costliestExpense() {
        double expense = Double.MIN_VALUE;
        String category = "";
        for (String cat : _dataMap.keySet()) {
            if (_dataMap.get(cat).totalExpense > expense) {
                expense = _dataMap.get(cat).totalExpense;
                category = cat;
            }
        }
        return _dataMap.get(category)._catName;
    }

    private boolean categoryExists(String category) {
        category = category.toLowerCase();
        boolean toReturn = _categoryNames.contains(category);
        return toReturn;
    }
    
    private boolean createCategory(String catName) {
        Category justAdded = new Category(catName);
        boolean exists = categoryExists(catName);
        _dataMap.put(catName, justAdded);
        return exists;
    }

    private boolean insertIntoCategory(String catName, String place, double price) {
        Category get = _dataMap.get(catName);
        get.categoricalInsertion(place, price);
        return !(get == null);
    }

    /** Contains mappings from names of categories to Categories. */
    HashMap<String, Category> _dataMap;

    /** The target file containing my expenses. */
    File _toParse;

    HashSet<String> _categoryNames;
}
