import java.util.Stack;

public class MinStack {

    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        mainStack.push(val);

        if (minStack.isEmpty() || val <= mainStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        int val = mainStack.pop();
        if (val == mainStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(5);
        minStack.push(2);
        minStack.push(8);
        minStack.push(1);
        minStack.push(3);

        System.out.println("Top Element: " + minStack.top());
        System.out.println("Min Element: " + minStack.getMin());

        minStack.pop();
        minStack.pop();

        System.out.println("Top after pops: "+minStack.top());
        System.out.println("Min after pops: "+minStack.getMin());
    }
}
