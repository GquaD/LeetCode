package LeetCode.medium;


public class Problem623 {
    //https://leetcode.com/problems/add-one-row-to-tree/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/add-one-row-to-tree/solutions/3797963/java-dfs-100-only-1-round/
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //43.8 MB
    //Beats
    //56.77%
    static TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode n = new TreeNode(val);
            n.left = root;
            return n;
        }
        dfs(root,null, val, depth, 1, true);
        return root;
    }

    private static void dfs(TreeNode node, TreeNode parent, int val, int depth, int lvl, boolean isLeft) {
        if (node == null) {
            if (depth == lvl) {
                TreeNode temp = new TreeNode(val);
                if (isLeft) {
                    parent.left = temp;
                } else {
                    parent.right = temp;
                }
            }
            return;
        }

        if (depth == lvl) {
            TreeNode temp = new TreeNode(val);
            if (isLeft) {
                parent.left = temp;
                temp.left = node;
            } else {
                parent.right = temp;
                temp.right = node;
            }
        }
        dfs(node.left, node, val, depth, lvl + 1, true);
        dfs(node.right, node, val, depth, lvl + 1, false);
    }
}
