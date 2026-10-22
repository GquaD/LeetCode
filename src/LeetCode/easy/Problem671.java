package LeetCode.easy;

import java.util.*;

public class Problem671 {
    //15min
    //Runtime
    //1
    //ms
    //Beats
    //12.66%
    //Memory
    //42.10
    //MB
    //Beats
    //96.51%
    public int findSecondMinimumValue(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeSet<Integer> set = new TreeSet<>();

        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (!set.contains(node.val)) {
                    set.add(node.val);
                    if (set.size() > 2) {
                        set.pollLast();
                    }
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return set.size() == 2 ? set.pollLast() : -1;
    }

}
