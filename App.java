import java.io.*;
import java.util.*;

public class App {
    private static HashMap<String, Calculator.Command> commands = new HashMap<String, Calculator.Command>();

    // Open a file at a specific filesystem location as an InputStream
    // and pass the InputStream readLineByLineExample2. Then output the
    // number of lines read
    public static void main(String[] args) throws Exception {
        commands.put("+", new AddCommand());
        commands.put("*", new MultiplyCommand());
        commands.put("-", new SubtractCommand());
        commands.put("/", new DivideCommand());
        commands.put("sqrt", new SqrtCommand());
        commands.put("min", new MinCommand());

        FileInputStream fis = new FileInputStream(
                "numbers.txt");
        Scanner fisScanner = new Scanner(fis);
        while (fisScanner.hasNextLine()) {
            String line = fisScanner.nextLine();
            Calculator calculator = new Calculator();

            System.out.println("result: " + calculator.processReversePolish(
                    new ByteArrayInputStream(line.getBytes()), commands));
        }
        fisScanner.close();
    }
}