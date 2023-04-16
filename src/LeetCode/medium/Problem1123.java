package LeetCode.medium;

import java.util.*;

public class Problem1123 {
    //https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
    public static void main(String[] args) {

    }

    //1 hour
    //Runtime
    //4 ms
    //Beats
    //8.74%
    //Memory
    //42 MB
    //Beats
    //81.17%
    static TreeNode result;
    static TreeNode lcaDeepestLeaves(TreeNode root) {
        result = root;
        Map<Integer, List<Integer>> map = new HashMap<>();
        goDFS(root, map, 0);
        int maxLvl = 0;
        for (int lvl : map.keySet()) if (maxLvl < lvl) maxLvl = lvl;
        Set<Integer> setMaxLvl = new HashSet<>(map.get(maxLvl));
        List<List<Integer>> list = new ArrayList<>(); // can make it list of lists
        findPath(root, setMaxLvl, list, new ArrayList<>());
        int searchFor = root.val;
        for (int col = list.get(0).size() - 1; col >= 0; col--) {
            int check = list.get(0).get(col);
            boolean allEqual = true;
            for (int row = 1; row < list.size(); row++) {
                if (check != list.get(row).get(col)) {
                    allEqual = false;
                    break;
                }
            }
            if (allEqual) {
                searchFor = check;
                break;
            }
        }
        findSearchFor(root, searchFor);
        return result;
    }

    private static void findSearchFor(TreeNode node, int searchFor) {
        if (node == null) return;

        if (node.val == searchFor) {
            result = node;
            return;
        }
        findSearchFor(node.left, searchFor);
        findSearchFor(node.right, searchFor);
    }

    private static void findPath(TreeNode node, Set<Integer> setMaxLvl,
                                 List<List<Integer>> list, List<Integer> path) {
        if (node == null) return;

        path.add(node.val);

        if (setMaxLvl.contains(node.val)) {
            list.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        findPath(node.left, setMaxLvl, list, path);
        findPath(node.right, setMaxLvl, list, path);
        path.remove(path.size() - 1);
    }

    private static void goDFS(TreeNode node, Map<Integer, List<Integer>> map, int lvl) {
        if (node == null) return;

        map.computeIfAbsent(lvl++, ArrayList::new).add(node.val);

        goDFS(node.left, map, lvl);
        goDFS(node.right, map, lvl);
    }
}
