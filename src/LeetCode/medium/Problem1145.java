package LeetCode.medium;

public class Problem1145 {
    //https://leetcode.com/problems/binary-tree-coloring-game/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/binary-tree-coloring-game/solutions/4408523/java-o-n-100-faster-solution/
    //15-20 min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //40.5 MB
    //Beats
    //42.96%

    static boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        if (root.val == x) {
            int[] countLeft = new int[1], countRight = new int[1];
            countNodes(root.left, countLeft);
            countNodes(root.right, countRight);
            return Math.abs(countLeft[0] - countRight[0]) - 1 > 0;
        }

        TreeNode[] red = new TreeNode[1];
        findNode(root, x, red);
        int[] countLeft = new int[1], countRight = new int[1];
        countNodes(red[0].left, countLeft);
        countNodes(red[0].right, countRight);

        int l = countLeft[0], r = countRight[0];

        return l > n - l || r > n - r || l + r + 1 < n - l - r - 1;
    }

    private static void countNodes(TreeNode node, int[] count) {
        if (node == null) return;

        count[0]++;
        countNodes(node.left, count);
        countNodes(node.right, count);
    }

    private static void findNode(TreeNode node, int x, TreeNode[] res) {
        if (node == null) return;

        if (node.val == x) {
            res[0] = node;
            return;
        }

        findNode(node.left, x, res);
        findNode(node.right, x, res);
    }
}
