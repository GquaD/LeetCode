package LeetCode.medium;

public class Problem1008 {
    //https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

    public static void main(String[] args) {
        System.out.println(bstFromPreorder(new int[]{4, 2}));
        System.out.println(bstFromPreorder(new int[]{1, 3}));
        System.out.println(bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12}));
    }
    //Runtime: 1 ms, faster than 66.05% of Java online submissions for Construct Binary Search Tree from Preorder Traversal.
    //Memory Usage: 42.5 MB, less than 22.31% of Java online submissions for Construct Binary Search Tree from Preorder Traversal.

    static TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        buildBST(preorder, 0, root);
        return root;
    }
    private static void buildBST(int[] preorder, int index, TreeNode node) {
        if (index >= preorder.length) {
            return;
        }
        if (node == null) {
            node = new TreeNode(preorder[index]);
        }
        //System.out.println(node.val);
        index++;
        int indexCut = 0;
        for (int i = index; i < preorder.length; i++) {
            if (preorder[i] > node.val) {
                indexCut = i;
                break;
            }
        }

        int count = 0;
        if (indexCut == 0) {
            indexCut = preorder.length;
        }
        if (indexCut - index < 0) {
            return;
        }
        //build left
        int[] left = new int[indexCut - index];
        for (int i = index; i < indexCut; i++) {
            left[count++] = preorder[i];
        }
        if (left.length > 0) {
            node.left = new TreeNode(left[0]);
        }

        //build right
        if (preorder.length - indexCut < 0) {
            return;
        }
        int[] right = new int[preorder.length - indexCut];
        count = 0;
        for (int i = indexCut; i < preorder.length; i++) {
            right[count++] = preorder[i];
        }

        if (right.length > 0) {
            node.right = new TreeNode(right[0]);
        }

        buildBST(left, 0, node.left);
        buildBST(right, 0, node.right);
    }

    ///until here - working solution

    static TreeNode bstFromPreorder0(int[] preorder) {
        int index = 0;
        TreeNode root = new TreeNode(preorder[index++]);
        while (index < preorder.length) {
            if (preorder[index] < root.val) {
                root.left = new TreeNode(preorder[index++]);
            }
            if (preorder[index] < root.val) {
                root.right = new TreeNode(preorder[index++]);
            }
        }
        return null;
    }

    static int indexStatic;

    static TreeNode bstFromPreorder1(int[] preorder) {
        indexStatic = 0;
        TreeNode root = new TreeNode(preorder[indexStatic++]);
        constructBST(preorder, root);
        return root;
    }

    private static void constructBST(int[] preorder, TreeNode node) {
        if (indexStatic >= preorder.length) {
            return;
        }
        if (node == null) {
            node = new TreeNode(preorder[indexStatic++]);
        }
//        node = new TreeNode(preorder[index++]);
        if (preorder[indexStatic] > node.val) {
            return;
        }
        if (preorder[indexStatic] < node.val) {
            node.left = new TreeNode(preorder[indexStatic++]);
        }
        if (preorder[indexStatic] > node.val) {
            node.right = new TreeNode(preorder[indexStatic++]);
        }

        constructBST(preorder, node.left);

        constructBST(preorder, node.right);
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
