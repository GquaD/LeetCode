package LeetCode.medium;


import java.util.LinkedList;
import java.util.Queue;

public class Problem919 {
    //https://leetcode.com/problems/complete-binary-tree-inserter/
    public static void main(String[] args) {

    }


}

//https://leetcode.com/problems/complete-binary-tree-inserter/solutions/3734113/java-bfs-solution/
//10-15 min
//Runtime
//48 ms
//Beats
//8.89%
//Memory
//44.9 MB
//Beats
//8.89%
class CBTInserter1 {
    TreeNode root;
    public CBTInserter1(TreeNode root) {
        this.root = root;
    }

    public int insert(int val) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.left == null) {
                curr.left = new TreeNode(val);
                return curr.val;
            } else if (curr.right == null) {
                curr.right = new TreeNode(val);
                return curr.val;
            } else {
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }
        return -1;
    }

    public TreeNode get_root() {
        return root;
    }
}
