import java.util.*;

class LRUCache {

    class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // Dummy head and tail to simplify operations
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        remove(node);
        insertToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }

        Node newNode = new Node(key, value);
        insertToFront(newNode);
        map.put(key, newNode);

        if (map.size() > capacity) {
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToFront(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    // For testing only
    public void printCacheState() {
        Node current = head.next;
        System.out.print("Cache: ");
        while (current != tail) {
            System.out.print("(" + current.key + ":" + current.value + ") ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1); // cache = {1=1}
        cache.put(2, 2); // cache = {1=1, 2=2}
        System.out.println(cache.get(1)); // returns 1
        cache.put(3, 3); // LRU key 2 evicted, cache = {1=1, 3=3}
        System.out.println(cache.get(2)); // returns -1
        cache.put(4, 4); // LRU key 1 evicted, cache = {3=3, 4=4}
        System.out.println(cache.get(1)); // returns -1
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4
    }
}
