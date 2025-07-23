class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class MaxPathSumInBinaryTree {

    static int maxSum;

    public static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        findMax(root);
        return maxSum;
    }

    private static int findMax(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(0, findMax(node.left));
        int right = Math.max(0, findMax(node.right));

        maxSum = Math.max(maxSum, left + right + node.val);

        return Math.max(left, right) + node.val;
    }

    public static void main(String[] args) {
        /*
              -10
              /  \
             9   20
                /  \
               15   7
        */
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int result = maxPathSum(root);
        System.out.println("Maximum Path Sum: " + result);  
    }
}
