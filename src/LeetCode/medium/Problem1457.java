package LeetCode.medium;

import java.util.*;

public class Problem1457 {
    //https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
    public static void main(String[] args) {

    }
    //https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/solutions/3565740/java-using-dfs-and-frequency-map/
    //45-55 min
    //Runtime
    //99 ms
    //Beats
    //14.15%
    //Memory
    //77.6 MB
    //Beats
    //19.69%
    static int res;
    static int pseudoPalindromicPaths(TreeNode root) {
        res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, 0, map);
        return res;
    }

    private static void dfs(TreeNode node, int xor, Map<Integer, Integer> map) {
        if (node == null) return;

        xor ^= node.val;
        map.put(node.val, map.getOrDefault(node.val, 0) + 1);

        if (node.left == null && node.right == null) {
            int countOdd = 0;
            for (int k : map.keySet()) if (map.get(k) % 2 == 1) countOdd++;
            if (countOdd < 2) if (xor == 0 || map.containsKey(xor) && map.get(xor) % 2 == 1) res++;
        }

        dfs(node.left, xor, map);
        dfs(node.right, xor, map);
        map.put(node.val, Math.max(map.get(node.val) - 1, 0));
    }

    static int pseudoPalindromicPaths1(TreeNode root) {
        Map<List<Integer>, Integer> mapPaths = new HashMap<>();
        dfs(root, new ArrayList<>(), mapPaths);
        int count = 0;
        for (List<Integer> list: mapPaths.keySet()) {
            Map<Integer, Integer> mapFreq = new HashMap<>();
            for (int i = 0; i < list.size(); i++) {
                int n = list.get(i);
                mapFreq.put(n, mapFreq.getOrDefault(n, 0) + 1);
            }
            int countOdd = 0;
            for (int n : mapFreq.keySet()) if (mapFreq.get(n) % 2 == 1) countOdd++;
            if (countOdd < 2) count += mapPaths.get(list);
        }
        return count;
    }

    private static void dfs(TreeNode node, List<Integer> list, Map<List<Integer>, Integer> mapPaths) {
        if (node == null) {
            return;
        }

        list.add(node.val);
        if (node.left == null && node.right == null) {
            List<Integer> l = new ArrayList<>(list);
            mapPaths.put(l, mapPaths.getOrDefault(l, 0) + 1);
        }
        dfs(node.left, list, mapPaths);
        dfs(node.right, list, mapPaths);
        list.remove(list.size() - 1);
    }

    /*static int pseudoPalindromicPaths1(TreeNode root) {
        List<List<Integer>> listPaths = new ArrayList<>();
        dfs(root, new ArrayList<>(), listPaths);
        int count = 0;
        for (List<Integer> list: listPaths) {
            Set<Integer> set = new HashSet<>();
            int xor = list.get(0);
            set.add(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                xor ^= list.get(i);
                set.add(list.get(i));
            }
            if (set.contains(xor)) count++;
        }
        return count;
    }*/
}
