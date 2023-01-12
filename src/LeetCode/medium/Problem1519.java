package LeetCode.medium;

import java.util.*;

public class Problem1519 {
    //https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/description/
    public static void main(String[] args) {
        String labels3 = "abaedcd";
        int[][] edges3 = new int[][] {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
        System.out.println(Arrays.toString(countSubTrees(7, edges3, labels3)));

        String labels4 = "bbbb";
        int[][] edges4 = new int[][] {{0,1},{1,2},{0,3}};
        System.out.println(Arrays.toString(countSubTrees(4, edges4, labels4)));
    }

    //todo optimize
    //1 hour
    //Runtime
    //2041 ms
    //Beats
    //5.43%
    //Memory
    //128.6 MB
    //Beats
    //78.26%
    static int[] countSubTrees(int n, int[][] edges, String labels) {
        if (n == 1) return new int[]{1};
        NTreeNode[] arr = new NTreeNode[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new NTreeNode(labels.charAt(i), i);
        }
        Set<Integer> hasParent = new HashSet<>();
        hasParent.add(0);
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0], b = edges[i][1];
            NTreeNode aNode = arr[a], bNode = arr[b];
            if (hasParent.contains(a)) {
                aNode.children.add(bNode);
                hasParent.add(b);
            } else {
                bNode.children.add(aNode);
                hasParent.add(a);
            }
        }

        Map<Character, List<NTreeNode>> parents = new HashMap<>();
        int[] freq = new int[n];
        traverseGraphDFS(arr[0], parents);
        for (int i = 0; i < arr.length; i++) {
            freq[i] = arr[i].freq;
        }
        return freq;
    }

    private static void traverseGraphDFS(NTreeNode node, Map<Character, List<NTreeNode>> parents) {
        if (node == null) return;

        node.freq++;
        List<NTreeNode> list = parents.get(node.val);
        if (list != null) {
            for (NTreeNode parent : list) {
                parent.freq++;
            }
            list.add(node);
        } else {
            list = new ArrayList<>();
            list.add(node);
            parents.put(node.val, list);
        }

        for (NTreeNode curr : node.children) {
            traverseGraphDFS(curr, parents);
        }
        list.remove(list.size() - 1);
    }

    static class NTreeNode {
        public char val;
        public List<NTreeNode> children;
        public int freq;
        int index;

        public NTreeNode() {}

        public NTreeNode(char _val, int idx) {
            val = _val;
            index = idx;
            children = new ArrayList<>();
        }

        public NTreeNode(char _val, List<NTreeNode> _children) {
            val = _val;
            children = _children;
        }
    }
}
