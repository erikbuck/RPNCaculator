public class SqrtCommand extends Calculator.Command {
    public void run(Calculator.Stack stack) {
        stack.push(Math.sqrt(stack.pop()));
    }
}
