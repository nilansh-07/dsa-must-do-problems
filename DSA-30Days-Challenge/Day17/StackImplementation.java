import java.util.LinkedList;
import java.util.Queue;

public class StackImplementation {
    
    Queue<Integer> mainQueue = new LinkedList<>();
    Queue<Integer> helperQueue = new LinkedList<>();

    public void push(int x) {
        helperQueue.add(x);
        while (!mainQueue.isEmpty()) {
            helperQueue.add(mainQueue.remove());
        }

        Queue<Integer> tempQueue = mainQueue;
        mainQueue = helperQueue;
        helperQueue = tempQueue;
    }

    public int pop() {
        return mainQueue.peek();
    }

    public int top() {
        return mainQueue.peek();
    }

    public boolean empty() {
        return mainQueue.isEmpty();
    }

    public static void main(String[] args) {

        StackImplementation stack = new StackImplementation();

        stack.push(5);
        stack.push(10);
        System.out.println("Top: " + stack.top());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Top: " + stack.top());
        System.out.println("Is Empty: " + stack.empty());
    }
}
