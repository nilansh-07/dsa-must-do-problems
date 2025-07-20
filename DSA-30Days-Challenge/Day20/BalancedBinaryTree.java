class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

public class BalancedBinaryTree {
    public static boolean isBalanced(TreeNode root) {
        return check(root) != -1;
    }

    public static int check(TreeNode node) {
        if (node == null)
            return 0;

        int left = check(node.left);
        if (left == -1)
            return -1;

        int right = check(node.right);
        if (right == -1)
            return -1;

        if (Math.abs(left - right) > 1)
            return -1;

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);

        System.out.println(isBalanced(root)); // Output: false
    }
}
