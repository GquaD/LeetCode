package LeetCode.medium;

import java.util.*;

public class Problem2096 {
    //https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/description/

    //https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/solutions/6051698/java-o-n-double-dfs-solution/
    //30min
    //Runtime
    //207
    //ms
    //Beats
    //19.52%
    //Analyze Complexity
    //Memory
    //132.22
    //MB
    //Beats
    //5.01%

    public String getDirections(TreeNode root, int startValue, int destValue) {
        HashMap<Integer, List<Node>> map = new HashMap<>();
        goDFS(root, null, map);

        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();
        String[] res = new String[1];
        goDFSFind(map, sb, startValue, destValue, set, res);
        return res[0];
    }

    private void goDFSFind(HashMap<Integer, List<Node>> map, StringBuilder sb, int cur, int dest, Set<Integer> set, String[] res) {
        if (map.get(cur) == null) return;

        if (cur == dest) {
            res[0] = sb.toString();
            return;
        }
        if (set.contains(cur)) return;
        set.add(cur);

        List<Node> list = map.get(cur);
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            sb.append(node.dir);
            goDFSFind(map, sb, node.val, dest, set, res);
            sb.setLength(sb.length() - 1);
        }
    }

    private void goDFS(TreeNode node, TreeNode parent, HashMap<Integer, List<Node>> map) {
        if (node == null) return;

        List<Node> list = new ArrayList<>();
        if (parent != null) {
            list.add(new Node(parent.val, 'U'));
        }
        if (node.left != null) {
            list.add(new Node(node.left.val, 'L'));
        }
        if (node.right != null) {
            list.add(new Node(node.right.val, 'R'));
        }
        map.put(node.val, list);
        goDFS(node.left, node, map);
        goDFS(node.right, node, map);
    }

    class Node {
        int val;
        char dir;

        public Node(int v, char d) {
            val = v;
            dir = d;
        }
    }

//    public String getDirections(TreeNode root, int s, int d) {
//        TreeNode[] arr = new TreeNode[1];
//        goDFS(root, s, d, arr);
//        boolean[] arr = new boolean[1];
//        List<String> list = new ArrayList<>();
//        if (arr[0].val == s) {
//            goLtoR(root, s, d, list);
//        } else {
//            goRtoL(root, s, d, list);
//        }
//    }
//
//    private void goLtoR(TreeNode node, int s, int d, List<String> list, boolean[] met) {
//        if (node == null) return;
//
//        if (node.val == s) {
//            met[0] = true;
//        }
//
//    }
//
//    private void goDFS(TreeNode node, int s, int d, TreeNode[] arr) {
//        if (node == null) return;
//
//        if ((node.val == s || node.val == d) && arr[0] == null) {
//            node[0] = node;
//            return;
//        }
//        if (arr[0] == null) {
//            goDFS(node.left, s, d, arr);
//        }
//        if (arr[0] == null) {
//            goDFS(node.right, s, d, arr);
//        }
//    }
}
