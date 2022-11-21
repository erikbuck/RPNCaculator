public class MinCommand extends Calculator.Command {
    public void run(Calculator.Stack stack) {
        stack.push(Math.min(stack.pop(), stack.pop()));
    }
}