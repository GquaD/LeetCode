package LeetCode.medium;

public class Problem105 {
    //https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    public static void main(String[] args) {

    }

    //nnnn
    //Runtime
    //1 ms
    //Beats
    //100%
    //Memory
    //42.9 MB
    //Beats
    //18.58%
    static int inIdx, preIdx;
    static TreeNode buildTree(int[] preorder, int[] inorder) {
        inIdx = 0;
        preIdx = 0;
        return goRecursive(preorder, inorder, 3001);
    }

    private static TreeNode goRecursive(int[] preorder, int[] inorder, int boundary) {
        if (preIdx == preorder.length || inorder[inIdx] == boundary) return null;
        TreeNode node = new TreeNode(preorder[preIdx++]);
        node.left = goRecursive(preorder, inorder, node.val);
        inIdx++;
        node.right = goRecursive(preorder, inorder, boundary);
        return node;
    }
}
