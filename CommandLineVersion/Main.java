/**
 * Created by Surya on 6/9/17.
 */
public class Main {
    public static void main(String[] args) {
        PrintUtils printer = new PrintUtils();
        try {
            Analyze mainProgram = new Analyze();
            String command = args[0];
            printer.printFinal(mainProgram.commandInterface(command));
        } catch (AnalyticsException analyticsExcp) {
            System.out.println(analyticsExcp.toString());
        }
    }
}
