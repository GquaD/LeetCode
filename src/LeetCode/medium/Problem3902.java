package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem3902 {
    //15min

    //Runtime
    //43
    //ms
    //Beats
    //12.25%
    //Memory
    //199.92
    //MB
    //Beats
    //6.12%
    public List<Long> zigzagLevelSum(TreeNode root) {
        List<List<TreeNode>> list = new ArrayList<>();

        goDFS(root, 0, list);

        List<Long> result = new ArrayList<>();
        int l = 0;
        long sum = 0;
        for (List<TreeNode> lvl: list) {
            if (l++ % 2 == 0) {
                for (TreeNode node: lvl) {
                    if (node.left == null)
                        break;
                    sum += node.val;
                }
            } else {
                for (int i = lvl.size() - 1; i >= 0; i--) {
                    TreeNode node = lvl.get(i);
                    if (node.right == null)
                        break;
                    sum += node.val;
                }
            }
            result.add(sum);
            sum = 0;
        }
        return result;
    }

    private void goDFS(TreeNode node, int lvl, List<List<TreeNode>> list) {
        if (node == null) return;

        if (lvl >= list.size()) {
            list.add(new ArrayList<>());
        }

        list.get(lvl).add(node);

        goDFS(node.left, lvl + 1, list);
        goDFS(node.right, lvl + 1, list);
    }
}
