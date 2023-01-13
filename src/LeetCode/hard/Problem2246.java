package LeetCode.hard;

import java.util.*;

public class Problem2246 {
    //https://leetcode.com/problems/longest-path-with-different-adjacent-characters/
    public static void main(String[] args) {
        System.out.println(longestPath(new int[]{-1, 0, 0, 1, 1, 2}, "abacbe"));
        System.out.println(longestPath(new int[]{-1, 0, 0, 0}, "aabc"));
        System.out.println(longestPath(new int[]{-1, 0, 1}, "aab"));
        System.out.println(longestPath(new int[]{-1, 0}, "aa"));
        System.out.println(longestPath(new int[]{-1,137,65,60,73,138,81,17,45,163,145,99,29,162,19,20,132,132,13,60,21,18,155,65,13,163,125,102,96,60,50,101,100,86,162,42,162,94,21,56,45,56,13,23,101,76,57,89,4,161,16,139,29,60,44,127,19,68,71,55,13,36,148,129,75,41,107,91,52,42,93,85,125,89,132,13,141,21,152,21,79,160,130,103,46,65,71,33,129,0,19,148,65,125,41,38,104,115,130,164,138,108,65,31,13,60,29,116,26,58,118,10,138,14,28,91,60,47,2,149,99,28,154,71,96,60,106,79,129,83,42,102,34,41,55,31,154,26,34,127,42,133,113,125,113,13,54,132,13,56,13,42,102,135,130,75,25,80,159,39,29,41,89,85,19},
                "ajunvefrdrpgxltugqqrwisyfwwtldxjgaxsbbkhvuqeoigqssefoyngykgtthpzvsxgxrqedntvsjcpdnupvqtroxmbpsdwoswxfarnixkvcimzgvrevxnxtkkovwxcjmtgqrrsqyshxbfxptuvqrytctujnzzydhpal"));
    }

    //nnnn
    //todo
    //Runtime
    //146 ms
    //Beats
    //74.67%
    //Memory
    //129.5 MB
    //Beats
    //49.68%
    static int res;
    static int longestPath(int[] parent, String s) {
        res = 0;
        ArrayList<Integer>[] children = new ArrayList[parent.length];
        for (int i = 0; i < parent.length; i++)
            children[i] = new ArrayList<>();
        for (int i = 1; i < parent.length; i++)
            children[parent[i]].add(i);
        dfs(children, s, 0);
        return res;
    }

    private static int dfs(ArrayList<Integer>[] children, String s, int i) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int j : children[i]) {
            int cur = dfs(children, s, j);
            if (s.charAt(j) != s.charAt(i))
                queue.offer(-cur);
        }
        int big1 = queue.isEmpty() ? 0 : -queue.poll();
        int big2 = queue.isEmpty() ? 0 : -queue.poll();
        res = Math.max(res, big1 + big2 + 1);
        return big1 + 1;
    }

    //static int pathLen;
    //
    static int longestPath1(int[] parent, String s) {
        int n = parent.length;
        if (n == 1) return 1;
        NTreeNode[] arr = new NTreeNode[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new NTreeNode(s.charAt(i));
        }
        //adding children
        for (int i = 1; i < n; i++) {
            int parentIdx = parent[i];
            arr[parentIdx].children.add(arr[i]);
        }
        //pathLen = 0;

        traverseGraphDFS(arr[0], arr[0], 0);

        int max = 0;
        for (NTreeNode node : arr) {
            if (max < node.maxLen + node.prevMaxLen) max = node.maxLen + node.prevMaxLen;
        }
        return max + 1;
    }

    private static void traverseGraphDFS(NTreeNode node, NTreeNode parent, int lenCurrent) {
        if (node == null) return;

        int len = node.maxLen;
        for (int i = 0; i < node.children.size(); i++) {
            NTreeNode child = node.children.get(i);
            if (child.val != node.val) {
                child.maxLen = len + 1;
                traverseGraphDFS(child, parent == null ? node : parent, lenCurrent + 1);
            } else traverseGraphDFS(child, null, 0);
        }
        if (parent != null) {
            if (parent.maxLen <= node.maxLen) {
                parent.prevMaxLen = parent.maxLen;
                parent.maxLen = node.maxLen;
            } else if (parent.prevMaxLen < node.maxLen) parent.prevMaxLen = node.maxLen;
        }
    }

    /*static int[] countSubTrees(int n, int[][] edges, String labels) {
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
    }*/

    static class NTreeNode {
        public char val;
        public List<NTreeNode> children;
        public int maxLen;
        public int prevMaxLen;

        public NTreeNode(char _val) {
            val = _val;
            children = new ArrayList<>();
            maxLen = 0;
            prevMaxLen = 0;
        }

        public NTreeNode(char _val, List<NTreeNode> _children) {
            val = _val;
            children = _children;
        }
    }
}
