public class DivideCommand extends Calculator.Command {
    public void run(Calculator.Stack stack) {
        stack.push(stack.pop() / stack.pop());
    }
}
