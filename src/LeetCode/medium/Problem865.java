package LeetCode.medium;

import java.util.*;

public class Problem865 {
    //https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/solutions/3423183/java-2-ms-solution/
    //Runtime
    //2 ms
    //Beats
    //7.4%
    //Memory
    //42.4 MB
    //Beats
    //6.48%
    private TreeNode result;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        result = root;
        Map<Integer, List<Integer>> map = new HashMap<>();
        goDFS(root, map, 0);
        int maxLvl = 0;
        for (int lvl : map.keySet()) if (maxLvl < lvl) maxLvl = lvl;
        Set<Integer> setMaxLvl = new HashSet<>(map.get(maxLvl));
        List<List<Integer>> list = new ArrayList<>();
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

    private void findSearchFor(TreeNode node, int searchFor) {
        if (node == null) return;

        if (node.val == searchFor) {
            result = node;
            return;
        }
        findSearchFor(node.left, searchFor);
        findSearchFor(node.right, searchFor);
    }

    private void findPath(TreeNode node, Set<Integer> setMaxLvl,
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

    private void goDFS(TreeNode node, Map<Integer, List<Integer>> map, int lvl) {
        if (node == null) return;

        map.computeIfAbsent(lvl++, ArrayList::new).add(node.val);

        goDFS(node.left, map, lvl);
        goDFS(node.right, map, lvl);
    }
}
