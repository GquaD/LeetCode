package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem872 {
    //https://leetcode.com/problems/leaf-similar-trees/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/leaf-similar-trees/solutions/2780484/java-dfs-solution-1-ms/
    //Runtime
    //1 ms
    //Beats
    //76.93%
    //Memory
    //41.7 MB
    //Beats
    //65.40%
    static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        traverseTreeAndSaveLeaves(root1, list1);

        List<Integer> list2 = new ArrayList<>();
        traverseTreeAndSaveLeaves(root2, list2);

        if (list1.size() != list2.size()) {
            return false;
        } else {
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i) != list2.get(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void traverseTreeAndSaveLeaves(TreeNode node, List<Integer> list) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }
        traverseTreeAndSaveLeaves(node.left, list);
        traverseTreeAndSaveLeaves(node.right, list);
    }
}
