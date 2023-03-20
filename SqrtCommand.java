/**
 * Issue#17
 */
public class SqrtCommand extends Calculator.Command {
    /**
     * Pushes the square root of the last item on the stack onto the stack
     */
    public void run(Calculator.Stack stack) {
        stack.push(Math.sqrt(stack.pop()));
    }
}
