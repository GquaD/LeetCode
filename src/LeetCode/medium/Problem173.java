package LeetCode.medium;


import java.util.LinkedList;
import java.util.Queue;

public class Problem173 {
    //https://leetcode.com/problems/binary-search-tree-iterator/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/binary-search-tree-iterator/solutions/3053519/java-dfs-queue-100-faster/
    //10-15 mins
    //Runtime
    //14 ms
    //Beats
    //100%
    //Memory
    //46.4 MB
    //Beats
    //61.84%


    class BSTIterator {
        Queue<Integer> list;

        public BSTIterator(TreeNode root) {
            list = new LinkedList<>();
            traverseBST(root, list);
        }

        public int next() {
            return list.poll();
        }

        public boolean hasNext() {
            return !list.isEmpty();
        }

        private void traverseBST(TreeNode node, Queue<Integer> list) {
            if (node == null) return;

            traverseBST(node.left, list);
            list.add(node.val);
            traverseBST(node.right, list);
        }
    }
}
