package LeetCode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem501 {
    //https://leetcode.com/problems/find-mode-in-binary-search-tree/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-mode-in-binary-search-tree/solutions/2765705/java-solution-using-dfs-and-map/
    //Runtime
    //4 ms
    //Beats
    //66.81%
    //Memory
    //44.2 MB
    //Beats
    //85.56%
    static Map<Integer, Integer> map;

    static int[] findMode(TreeNode root) {
        map = new HashMap<>();
        searchInBST(root);
        int maxFreq = -1;
        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (maxFreq < freq) {
                maxFreq = freq;
                list.clear();
                list.add(key);
                continue;
            }
            if (maxFreq == freq) {
                list.add(key);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private static void searchInBST(TreeNode node) {
        if (node == null) return;

        if (map.containsKey(node.val)) {
            map.put(node.val, map.get(node.val) + 1);
        } else {
            map.put(node.val, 1);
        }

        searchInBST(node.left);
        searchInBST(node.right);
    }
}
