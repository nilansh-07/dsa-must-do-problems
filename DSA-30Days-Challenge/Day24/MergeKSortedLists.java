import java.util.PriorityQueue;

public class MergeKSortedLists {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode node : lists)
            if (node != null) pq.add(node);

        ListNode dummy = new ListNode(0), tail = dummy;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            tail.next = node;
            tail = node;

            if (node.next != null) pq.add(node.next);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1); a.next = new ListNode(4); a.next.next = new ListNode(5);
        ListNode b = new ListNode(1); b.next = new ListNode(3); b.next.next = new ListNode(4);
        ListNode c = new ListNode(2); c.next = new ListNode(6);

        ListNode[] lists = {a, b, c};

        ListNode result = mergeKLists(lists);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
