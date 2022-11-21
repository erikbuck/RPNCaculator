public class SubtractCommand extends Calculator.Command {
    public void run(Calculator.Stack stack) {
        stack.push(stack.pop() - stack.pop());
    }
}
