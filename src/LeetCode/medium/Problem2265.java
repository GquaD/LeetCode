package LeetCode.medium;

public class Problem2265 {
    //https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        System.out.println(averageOfSubtree(node1));

        TreeNode node11 = new TreeNode(1);
        TreeNode node12 = new TreeNode(3);
        TreeNode node13 = new TreeNode(1);
        TreeNode node14 = new TreeNode(3);
        node11.right = node12;
        node12.right = node13;
        node13.right = node14;

        System.out.println(averageOfSubtree(node11));


    }

    //Runtime: 29 ms, faster than 12.25% of Java online submissions for Count Nodes Equal to Average of Subtree.
    //Memory Usage: 43.4 MB, less than 78.99% of Java online submissions for Count Nodes Equal to Average of Subtree.
    static int count;
    static int averageOfSubtree(TreeNode root) {
        count = 0;
        traverseToCount(root);
        return count;
    }

    private static void traverseToCount(TreeNode root) {
        if (root == null) return;

        int sumLeft = traverseToFindSum(root.left);
        int sumRight = traverseToFindSum(root.right);
        int countLeft = traverseToFindNum(root.left);
        int countRight = traverseToFindNum(root.right);

        int avg = (sumLeft + sumRight + root.val) / (countLeft + countRight + 1);
        if (avg == root.val) {
            count++;
        }

        traverseToCount(root.left);
        traverseToCount(root.right);
    }

    private static int traverseToFindSum(TreeNode root) {
        if (root == null) return 0;

        return root.val + traverseToFindSum(root.left) + traverseToFindSum(root.right);
    }

    private static int traverseToFindNum(TreeNode root) {
        if (root == null) return 0;

        return 1 + traverseToFindNum(root.left) + traverseToFindNum(root.right);
    }

    //////////////////////////////////////////////////////////
    //not working
    static int averageOfSubtree1(TreeNode root) {
        count = 0;
        traverseBinaryTreeReturnAverage(root);
        return count;
    }

    private static int traverseBinaryTreeReturnAverage(TreeNode root) {
        if (root.left == null && root.right == null) {
            count++;
            return root.val;
        }

        if (root.left == null && root.right != null) {
            int temp = (root.val + traverseBinaryTreeReturnAverage(root.right)) / 2;
            if (temp == root.val) {
                count++;
            }
            return temp;
        }

        if (root.right == null && root.left != null) {
            int temp = (root.val + traverseBinaryTreeReturnAverage(root.left)) / 2;
            if (temp == root.val) {
                count++;
            }
            return temp;
        }

        int leftAverage = traverseBinaryTreeReturnAverage(root.left);
        int rightAverage = traverseBinaryTreeReturnAverage(root.right);
        int temp = (root.val + leftAverage + rightAverage) / 3;
        if (temp == root.val) {
            count++;
        }
        return temp;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
