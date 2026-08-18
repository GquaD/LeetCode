package LeetCode.medium;

public class Problem3997 {
    //10min

    //Runtime
    //6
    //ms
    //Beats
    //99.84%
    //Memory
    //172.87
    //MB
    //Beats
    //94.42%
    public int countDominantNodes(TreeNode root) {
        int[] count = new int[1];

        goDFS(root, count);

        return count[0];
    }

    private int goDFS(TreeNode node, int[] count) {
        if (node == null) return 0;

        if (node.left == null && node.right == null) {
            count[0]++;
            return node.val;
        }

        int l = goDFS(node.left, count), r = goDFS(node.right, count), max = Math.max(l, r);

        if (node.val >= max) count[0]++;

        return Math.max(max, node.val);
    }
}
