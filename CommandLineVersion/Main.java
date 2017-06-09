/**
 * Created by Surya on 6/9/17.
 */
public class Main {
    public static void main(String[] args) {
        try {
            Analyze mainProgram = new Analyze();
            while (true) {
                String command = args[0];
                System.out.println(mainProgram.commandInterface(command));
            }
        } catch (AnalyticsException analyticsExcp) {
            System.out.println(analyticsExcp.toString());
        }
    }
}
