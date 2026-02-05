package LeetCode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Problem3831 {
    //10min

    //Runtime
    //8
    //ms
    //Beats
    //50.00%
    //Analyze Complexity
    //Memory
    //160.33
    //MB
    //Beats
    //100.00%

    public int levelMedian(TreeNode root, int level) {
        if (level == 0) return root.val;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int lvl = 0;

        while (queue.size() > 0) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            lvl++;
            if (lvl == level) break;
        }

        if (queue.size() == 0) return -1;

        int[] arr = new int[queue.size()];
        for (int i = 0; i < arr.length; i++) arr[i] = queue.poll().val;

        return arr[arr.length / 2];
    }
}
