public class Trie {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    private final TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (node.children[i] == null)
                node.children[i] = new TrieNode();
            node = node.children[i];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = find(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    private TrieNode find(String str) {
        TrieNode node = root;
        for (char ch : str.toCharArray()) {
            int i = ch - 'a';
            if (node.children[i] == null)
                return null;
            node = node.children[i];
        }
        return node;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");

        System.out.println(trie.search("app"));
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("apex"));
        System.out.println(trie.startsWith("ap"));
        System.out.println(trie.startsWith("ba"));
    }
}
