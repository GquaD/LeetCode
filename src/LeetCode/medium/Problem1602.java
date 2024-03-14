package LeetCode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1602 {
    //https://leetcode.com/problems/find-nearest-right-node-in-binary-tree/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-nearest-right-node-in-binary-tree/solutions/4874624/java-o-n-dfs-solution/
    //5min
    //Runtime
    //10
    //ms
    //Beats
    //75.38%
    //of users with Java
    //Memory
    //55.63
    //MB
    //Beats
    //38.46%
    //of users with Java
    static TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        int[] arr = new int[]{-1};
        TreeNode[] res = new TreeNode[]{null};
        goDFS(root, 0, u.val, arr, res);
        return res[0];
    }

    private static void goDFS(TreeNode node, int lvl, int target, int[] arr, TreeNode[] res) {
        if (node == null) return;

        if (arr[0] == lvl) {
            res[0] = node;
            return;
        }

        if (node.val == target) {
            arr[0] = lvl;
        }

        goDFS(node.left, lvl + 1, target, arr, res);
        goDFS(node.right, lvl + 1, target, arr, res);
    }


    //5-10min
    //Runtime
    //12
    //ms
    //Beats
    //67.69%
    //of users with Java
    //Memory
    //55.30
    //MB
    //Beats
    //53.85%
    //of users with Java
    static TreeNode findNearestRightNode1(TreeNode root, TreeNode u) {
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        goDFS1(root, 0, u.val, map);
        for (int k : map.keySet()) {
            List<TreeNode> l = map.get(k);
            if (l.size() > 0) return l.get(0);
        }
        return null;
    }

    private static void goDFS1(TreeNode node, int lvl, int target, Map<Integer, List<TreeNode>> map) {
        if (node == null) return;

        if (node.val == target) {
            if (map.size() == 0) {
                List<TreeNode> l = new ArrayList<>();
                map.put(lvl, l);
            }
        } else if (map.containsKey(lvl)) {
            map.get(lvl).add(node);
        }

        goDFS1(node.left, lvl + 1, target, map);
        goDFS1(node.right, lvl + 1, target, map);
    }
}
