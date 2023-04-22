package LeetCode.medium;

public class Problem951 {
    //https://leetcode.com/problems/flip-equivalent-binary-trees/
    public static void main(String[] args) {

    }

    //nnnn
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //40.8 MB
    //Beats
    //30.8%
    static boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return root1 == root2;
        return root1.val == root2.val && (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) || flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }

    static boolean flipEquiv1(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            if (root2 == null) return true;
            else return false;
        }
        if (root1.val != root2.val) return false;

        if (root1.left != null && root2.left != null && root1.right != null && root2.right != null) {
            if (root1.left.val == root2.left.val && root1.right.val == root2.right.val) {
                flipEquiv(root1.left, root2.left);
                flipEquiv(root1.right, root2.right);
            } else if (root1.left.val == root2.right.val && root1.right.val == root2.left.val) {
                TreeNode left = root2.left;
                root2.left = root2.right;
                root2.right = left;
                flipEquiv(root1.left, root2.left);
                flipEquiv(root1.right, root2.right);
            }
        }

        if (root1.left == null) {
            if (root2.left == null) {
                if (root1.right != null)
                return true;
            }
        }
        return false;
    }
}
