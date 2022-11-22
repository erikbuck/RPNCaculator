import java.util.Scanner;
import java.util.HashMap;
import java.util.List;
import java.io.InputStream;
import java.util.ArrayList;

/// Instances of this class each encapsulate a Stack and may perform
/// any number and kind of Commands that each pop one or more
/// items from the stack and push the result of calculation onto the
/// stack.
///
/// The implementation of this class has no dependencies on the particular
/// commands that are supported. Commands may be added or changed without
/// changing this class. This means that teh Calculator class is not Coupled
/// to specific Command subclasses. Decoupling is almost always good design.
class Calculator {
    /// Base class for any number of subclasses
    public static class Command {
        public void run(Calculator.Stack stack) {
        }
    }

    /**
     * Issue#3: Stack Data Structure i.e. LIFO
     */
    public static class Stack {
        private List<Double> m_numbers = new ArrayList<Double>();

        public void push(Double d) {
            m_numbers.add(d);
        }

        public Double pop() {
            Double result = m_numbers.get(size() - 1);
            m_numbers.remove(size() - 1);
            return result;
        }

        public int size() {
            return m_numbers.size();
        }
    }

    /// The stack that contains operands to be used by Commands
    private Stack stack = new Calculator.Stack();

    // Reads reverse polish notation from inputStream and returns result.
    public double processReversePolish(InputStream inputStream,
            HashMap<String, Command> commands)
            throws Exception {
        Scanner sc = new Scanner(inputStream); // file to be scanned
        boolean isDone = false;
        while (!isDone) {
            if (sc.hasNextDouble()) {
                double inputDouble = sc.nextDouble();
                stack.push(inputDouble);
            } else if (sc.hasNext()) {
                String operator = sc.next();
                if (commands.containsKey(operator)) {
                    commands.get(operator).run(stack);
                } else {
                    System.err.println("Invalid operator: <" +
                            operator + ">");
                }
            } else {
                isDone = true;
            }
        }
        sc.close(); // closes the scanner
        return stack.pop();
    }

}