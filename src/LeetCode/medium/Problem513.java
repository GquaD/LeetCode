package LeetCode.medium;

public class Problem513 {
    //https://leetcode.com/problems/find-bottom-left-tree-value/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-bottom-left-tree-value/solutions/3166907/java-o-n-dfs-100-faster-solution/
    //15 min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //41.6 MB
    //Beats
    //90.87%
    static int maxlvl;
    static int val;
    static int findBottomLeftValue(TreeNode root) {
        maxlvl = 0;
        val = root.val;
        goDFS(root, 0);
        return val;
    }

    private static void goDFS(TreeNode node, int lvl) {
        if (node == null) return;

        if (maxlvl <= lvl) {
            maxlvl = lvl;
            val = node.val;
        }
        lvl++;
        goDFS(node.right, lvl);
        goDFS(node.left, lvl);
    }
}
