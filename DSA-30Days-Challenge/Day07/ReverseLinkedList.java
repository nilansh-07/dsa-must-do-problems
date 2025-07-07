class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        ListNode prevNode = null;
        ListNode currNode = head;

        while (currNode != null) {
            ListNode nextNode = currNode.next; // store next node
            currNode.next = prevNode; // reverse the link
            prevNode = currNode; // move prev node forward
            currNode = nextNode; // move current node forward
        }

        return prevNode;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.data + (head.next != null ? " " : ""));
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original List: ");
        printList(head);

        ListNode reversed = reverseList(head);
        System.out.print("Reversed List: ");
        printList(reversed);
    }
}
