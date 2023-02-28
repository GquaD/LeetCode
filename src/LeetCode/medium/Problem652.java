package LeetCode.medium;

import java.util.*;

public class Problem652 {
    //https://leetcode.com/problems/find-duplicate-subtrees/description/
    public static void main(String[] args) {

    }

    //nnn
    //50 min
    //Runtime
    //10 ms
    //Beats
    //96.44%
    //Memory
    //47.6 MB
    //Beats
    //75.14%

    static List<TreeNode> findDuplicateSubtrees1(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> list = new ArrayList<>();
        goDFS(root, list, map);
        return list;
    }

    private static String goDFS(TreeNode node, List<TreeNode> list, Map<String, Integer> map) {
        if (node == null) return "";
        String left = goDFS(node.left, list, map);
        String right = goDFS(node.right, list, map);
        StringBuilder sb = new StringBuilder();
        sb.append(node.val).append("#").append(left).append("#").append(right);
        String path = sb.toString();
        if (map.getOrDefault(path, 0) == 1) list.add(node);
        map.put(path, map.getOrDefault(path, 0) + 1);
        return path;
    }

/*    static List<TreeNode> findDuplicateSubtrees1(TreeNode root) {
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        goDFS(root, map);
        for (List<TreeNode> list : map.values()) {
            for (int i = 0; i < ; i++) {
                
            }
        }
    }

    private static void goDFS(TreeNode node, Map<Integer, List<TreeNode>> map) {
        if (node == null) return;

        List<TreeNode> list = map.computeIfAbsent(node.val, ArrayList::new);
        list.add(node);
        
        goDFS(node.left, map);
        goDFS(node.right, map);
    }*/

    /*    static List<TreeNode> findDuplicateSubtrees1(TreeNode root) {
        List<List<TreeNode>> list = new ArrayList<>();
        List<TreeNode> listPath = new ArrayList<>();
        goDFS(root, list, listPath, false);
    }*/



/*    private static void goDFS(TreeNode node, List<List<TreeNode>> list, List<TreeNode> listPath, boolean isLeft) {
        if (node == null) return;

        listPath.add(node);

        goDFS(node.left, list, listPath, false);
        goDFS(node.right, list, listPath,false);
        if (list.isEmpty()) {
            list.add(new ArrayList<>(listPath));
        } else {

        }
        listPath.remove(listPath.size() - 1);
    }*/


/*    static List<TreeNode> findDuplicateSubtrees1(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        List<Boolean> listIsLeft = new ArrayList<>();
        goDFS(root, list, listIsLeft, false);
        for (int i = 0; i < list.size() - 1; i++) {
            TreeNode node1 = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                TreeNode node2 = list.get(j);
            }
        }
    }*/

/*    private static void goDFS(TreeNode node, List<TreeNode> list, List<Boolean> listIsLeft, boolean isLeft) {
        if (node == null) return;

        list.add(node);
        listIsLeft.add(isLeft);

        goDFS(node.left, list, listIsLeft, true);
        goDFS(node.right, list, listIsLeft, false);
    }*/
}
