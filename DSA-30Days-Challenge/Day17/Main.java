import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

// BST Iterator class
class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeft(root);
    }

    private void pushLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public int next() {
        TreeNode curr = stack.pop();
        if (curr.right != null) {
            pushLeft(curr.right);
        }
        return curr.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

public class Main {
    public static void main(String[] args) {

        /*
                7
               / \
              3   15
                 /  \
                9   20
        */
        
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator iterator = new BSTIterator(root);

        System.out.println("In-order traversal using BSTIterator:");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
