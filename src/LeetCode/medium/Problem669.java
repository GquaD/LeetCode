package LeetCode.medium;


import java.util.LinkedList;
import java.util.Queue;

public class Problem669 {
    //https://leetcode.com/problems/trim-a-binary-search-tree/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/trim-a-binary-search-tree/solutions/3396514/java-100-faster-0ms-bfs-dfs-solution/
    //40 min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //42.7 MB
    //Beats
    //12.57%
    static TreeNode trimBST(TreeNode root, int low, int high) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean found = false;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (low <= curr.val && curr.val <= high) {
                root = curr;
                found = true;
                break;
            } else {
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }
        if (!found) return low <= root.val && root.val <= high ? root : null;
        trimBSTDFS(root, low, high);
        return root;
    }

    private static void trimBSTDFS(TreeNode node, int low, int high) {
        if (node == null) return;

        while (node.left != null && node.left.val < low) node.left = node.left.right;
        while (node.right != null && node.right.val > high) node.right = node.right.left;
        trimBSTDFS(node.left, low, high);
        trimBSTDFS(node.right, low, high);
    }
}
