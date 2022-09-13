package LeetCode.medium;

public class Problem2196 {
    //https://leetcode.com/problems/create-binary-tree-from-descriptions/
    public static void main(String[] args) {
        TreeNode treeNode = createBinaryTree(new int[][]{
                {20,15,1},
                {20,17,0},
                {50,20,1},
                {50,80,0},
                {80,19,1}
        });
    }

    static TreeNode found;
    static TreeNode createBinaryTree(int[][] descriptions) {
        found = null;
        int[] first = descriptions[0];
        TreeNode root = new TreeNode(first[0]);
        int rootIsLeft = first[2];
        for (int i = 0; i < descriptions.length; i++) {
            int[] current = descriptions[i];
            findNode(root, current[0]);
            TreeNode foundParent = found;
            found = null;
            findNode(root, current[1]);
            if (foundParent != null && found == null) {
                insertIntoTree(found, current[1], current[2]);
            } else if (foundParent != null && found != null) {
                if (current[2] == 1) {
                    foundParent.left = found;
                } else {
                    foundParent.right = found;
                }
            }
            else {
                TreeNode p = new TreeNode(current[0]);
                insertIntoTree(p, current[1], current[2]);
                if (rootIsLeft == 1) {
                    p.left = root;
                } else {
                    p.right = root;
                }
                root = p;
                rootIsLeft = current[2];
            }
            found = null;
        }
        return root;
    }

    private static void insertIntoTree(TreeNode find, int val, int isLeft) {
        if (isLeft == 1) {
            find.left = new TreeNode(val);
        } else {
            find.right = new TreeNode(val);
        }
    }

    private static void findNode(TreeNode node, int val) {
        if (node == null) return;

        if (node.val == val) {
            found = node;
        }

        findNode(node.left, val);
        findNode(node.right, val);
    }
}
