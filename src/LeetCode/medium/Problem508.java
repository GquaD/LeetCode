package LeetCode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem508 {
    //https://leetcode.com/problems/most-frequent-subtree-sum/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/most-frequent-subtree-sum/solutions/3713762/java-o-n-using-frequency-map/
    //15 min
    //Runtime
    //4 ms
    //Beats
    //92.86%
    //Memory
    //44.2 MB
    //Beats
    //44.47%
    static int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        int maxFreq = 0;
        List<Integer> list = new ArrayList<>();
        for (int s : map.keySet()) {
            int f = map.get(s);
            if (maxFreq < f) {
                maxFreq = f;
                list.clear();
                list.add(s);
            } else if (maxFreq == f) {
                list.add(s);
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) arr[i] = list.get(i);
        return arr;
    }

    private static int dfs(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) return 0;

        int left = dfs(node.left, map);
        int right = dfs(node.right, map);
        int sum = left + right + node.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
}
