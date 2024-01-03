package LeetCode.medium;

public class Problem450 {
    //https://leetcode.com/problems/delete-node-in-a-bst/
    public static void main(String[] args) {

    }

    //nnnn
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //46.1 MB
    //Beats
    //12.85%
    static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            TreeNode min = findMin(root.right);
            root.val = min.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private static TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
