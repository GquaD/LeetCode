package LeetCode.Recursion;

public class MaxDepthBinaryTreeTwo {

    //atomic step:
    //if left is null then check right
    //if right is null then stop there

    //if left is not null and right is null
    //then count += 1, go inside there

    //if right is not null and left is null
    //then count += 1, go inside there

    //each time count is incremented,
    //compare it to static counter of max
    //and set greater value

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
        root.left = null;

        int result = maxDepth(root);
        System.out.println("MaxDepth = " + result);

    }

    static int counterDepth = 1;

    public static int maxDepth(TreeNode root) {
        int count = countMaxDepth(root, 1);
        if (counterDepth < count) {
            counterDepth = count;
        }
        return counterDepth;
    }


    private static int countMaxDepth(TreeNode root, int counter) {
        if (root.left == null && root.right == null) {
            return counter;
        }
        if (root.left != null && root.right == null) {
            counter += 1;
            if (counterDepth < counter) {
                counterDepth = counter;
            }
            return countMaxDepth(root.left, counter);
        }
        if (root.right != null && root.left == null) {
            counter += 1;
            if (counterDepth < counter) {
                counterDepth = counter;
            }
            return countMaxDepth(root.right, counter);
        }

        counter += 1;
        int countLeft = countMaxDepth(root.left, counter);
        int countRight = countMaxDepth(root.right, counter);

        if (countLeft <= countRight) {
            return countRight;
        } else return countLeft;
    }
}
