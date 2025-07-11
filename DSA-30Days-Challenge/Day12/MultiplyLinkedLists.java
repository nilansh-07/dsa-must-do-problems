class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class MultiplyLinkedLists {

    public static long listToNumber(Node head) {
        long num = 0;
        while (head != null) {
            num = num * 10 + head.data;
            head = head.next;
        }
        return num;
    }

    public static long multiply(Node l1, Node l2) {
        long num1 = listToNumber(l1);
        long num2 = listToNumber(l2);
        return num1 * num2;
    }

    public static void main(String[] args) {
        Node l1 = new Node(3);
        l1.next = new Node(4);
        l1.next.next = new Node(2); // 342

        Node l2 = new Node(4);
        l2.next = new Node(6); // 46

        long result = multiply(l1, l2);
        System.out.println("Multiplication Result: " + result);
    }
}
