class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RemoveElements {
    public static ListNode removeElements(ListNode head, int val) {
        ListNode tempNode = new ListNode(-1);
        tempNode.next = head;

        ListNode currNode = tempNode;

        while (currNode.next != null) {
            if (currNode.next.data == val) {
                currNode.next = currNode.next.next; // skip the current node
            } else {
                currNode = currNode.next; // Simply move forward
            }
        }

        return tempNode.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.data + (head.next != null ? " " : ""));
            head = head.next;
        }
    }

    public static void main(String[] args) {

        ListNode headNode = new ListNode(1);
        headNode.next = new ListNode(2);
        headNode.next.next = new ListNode(6);
        headNode.next.next.next = new ListNode(3);
        headNode.next.next.next.next = new ListNode(4);
        headNode.next.next.next.next.next = new ListNode(5);
        headNode.next.next.next.next.next.next = new ListNode(6);

        System.out.print("Original List: ");
        printList(headNode);
        System.out.println();

        ListNode newHead = removeElements(headNode, 6);
        System.out.print("After Removing 6: ");
        printList(newHead);
    }
}
