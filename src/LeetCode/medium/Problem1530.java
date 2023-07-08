package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;


public class Problem1530 {
    //https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        System.out.println(countPairs(n1, 3));
    }

    //
    //50 - 60 min
    //Runtime
    //199 ms
    //Beats
    //5.10%
    //Memory
    //44.2 MB
    //Beats
    //13.27%
    static int countPairs(TreeNode root, int distance) {
        List<List<TreeNode>> paths = new ArrayList<>();
        dfs(root, new ArrayList<>(), paths);
        int count = 0;
        for (int i = 0; i < paths.size() - 1; i++) {
            for (int j = i + 1; j < paths.size(); j++) {
                if (i != j) {
                    List<TreeNode> path1 = paths.get(i);
                    List<TreeNode> path2 = paths.get(j);
                    int lastIdx = 0;
                    for (int k = 0; k < Math.min(path1.size(), path2.size()); k++) {
                        if (path1.get(k) == path2.get(k)) lastIdx = k;
                        else break;
                    }
                    int d = path1.size() - lastIdx + path2.size() - lastIdx - 2;
                    if (d <= distance) count++;
                }
            }
        }
        return count;
    }

    private static void dfs(TreeNode node, ArrayList<TreeNode> list, List<List<TreeNode>> paths) {
        if (node == null) return;
        list.add(node);

        if (node.left == null && node.right == null) paths.add(new ArrayList<>(list));
        dfs(node.left, list, paths);
        dfs(node.right, list, paths);
        list.remove(list.size() - 1);
    }


    //Wrong Answer
    //
    //46 / 113
    static int countPairs1(TreeNode root, int distance) {
        int[] res = new int[]{0};
        dfs(root, distance, res);
        return res[0];
    }

    private static int dfs(TreeNode node, int distance, int[] res) {
        if (node == null) return 0;

        int left = dfs(node.left, distance, res);
        int right = dfs(node.right, distance, res);

        int ans = left + right;
        if (left == 0 || right == 0) ans++;
        if (ans <= distance && left > 0 && right > 0) res[0]++;
        if (left > 0 && right > 0) ans = Math.min(left, right) + 1;
        return ans;
    }
}
