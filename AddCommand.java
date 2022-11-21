public class AddCommand extends Calculator.Command {
    public void run(Calculator.Stack stack) {
        stack.push(stack.pop() + stack.pop());
    }
}
