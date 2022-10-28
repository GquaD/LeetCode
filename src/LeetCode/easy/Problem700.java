package LeetCode.easy;

public class Problem700 {
    //https://leetcode.com/problems/search-in-a-binary-search-tree/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/search-in-a-binary-search-tree/solutions/2752301/java-dfs-in-just-1-ms/
    //Runtime
    //1 ms
    //Beats
    //10.42%
    //Memory
    //42.5 MB
    //Beats
    //96.91%
    static TreeNode result;

    static TreeNode searchBST(TreeNode root, int val) {
        result = null;
        searchInBST(root, val);
        return result;
    }

    private static void searchInBST(TreeNode node, int val) {
        if (node == null) return;

        if (val == node.val) {
            result = node;
            return;
        }

        searchInBST(node.left, val);
        searchInBST(node.right, val);
    }
}
