package LeetCode.Recursion;

public class MaxDepthOfBinaryTree {
    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        root.left.left = node3;
        root.left.right = node4;*/
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        root.right = node1;

        int result = maxDepth(root);
        System.out.println("MaxDepth = " + (countMain < result ? result : countMain));
        countMain = countTemp = 0;
        result = maxDepth(root);

        System.out.println("MaxDepth = " + (countMain < result ? result : countMain));
    }

    static int countMain = 0, countTemp = 0;

    public static int maxDepth(TreeNode root) {
        return countMaxDepth(root, 0);
    }

    private static int countMaxDepth(TreeNode root, int counter) {
        counter++;
        if (root.left == null && root.right == null) {
            return counter;
        } else if (root.left == null || root.right == null) {
            return ++counter;
        }
        countTemp = countMaxDepth(root.left, counter);

        if (countMain < countTemp) {
            countMain = countTemp;
        }

        countTemp = countMaxDepth(root.right, counter);

        if (countMain < countTemp) {
            countMain = countTemp;
        }
        return counter;
    }
}
