/**
 * Created by Surya on 6/9/17.
 */
public class PrintUtils {

    void print(Object o) {
        System.out.println(o.toString());
        return;
    }

    public void printMajorBoundary() {
        System.out.println("=========");
    }


    public void printDelineation(String name) {
        System.out.println("##############################");
        System.out.println(name);
        System.out.println("##############################\n");
    }

    public void printCategory(String category) {
        System.out.println("///////////////////");
        System.out.println("===================");
        System.out.println("-------------------\n");
        System.out.println("CATEGORY: " + category + "\n");
        System.out.println("///////////////////");
        System.out.println("===================");
        System.out.println("-------------------\n");
    }

    public void printFinal(Object result) {
        if (!result.equals("")) {
            System.out.println("____________\n");
            System.out.println("[  " + result + "   ]");
            System.out.println("____________");
        }
    }

    public void printMinorBoundary() {
        System.out.println("--------------------");
    }


}
