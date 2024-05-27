package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem3157 {
    //https://leetcode.com/problems/find-the-level-of-tree-with-minimum-sum/
    public static void main(String[] args) {

    }


    //https://leetcode.com/problems/find-the-level-of-tree-with-minimum-sum/solutions/5216167/java-o-n-dfs-solution/
    //5-10min
    //Runtime
    //15
    //ms
    //Beats
    //28.85%
    //of users with Java
    //Memory
    //71.79
    //MB
    //Beats
    //17.31%
    //of users with Java
    static int minimumLevel(TreeNode root) {
        List<Long> list = new ArrayList<>();
        list.add(Long.MAX_VALUE);

        goDFS(root, list, 1);

        int lvl = 1;
        long sum = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < sum) {
                lvl = i;
                sum = list.get(i);
            }
        }
        return lvl;
    }

    private static void goDFS(TreeNode node, List<Long> list, int lvl) {
        if (node == null) return;

        if (lvl >= list.size()) {
            list.add((long) node.val);
        } else {
            list.set(lvl, list.get(lvl) + node.val);
        }
        goDFS(node.left, list, lvl + 1);
        goDFS(node.right, list, lvl + 1);
    }
}
