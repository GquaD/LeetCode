package LeetCode.hard;

import java.util.*;

public class Problem1857 {
    //https://leetcode.com/problems/largest-color-value-in-a-directed-graph/
    public static void main(String[] args) {
        System.out.println(largestPathValue("iivvvvv", new int[][]{{0,1},{1,2},{1,3},{2,3},{3,4},{2,4},{3,5},{1,5},{4,5},{5,6}}));
        System.out.println(largestPathValue("abaca", new int[][]{{0,1},{0,2},{2,3},{3,4}}));
        System.out.println(largestPathValue("bbbhb", new int[][]{{0,2},{3,0},{1,3},{4,1}}));
        System.out.println(largestPathValue("g", new int[0][0]));
        System.out.println(largestPathValue("a", new int[][]{{0,0}}));
    }

    //nnn
    //Runtime
    //96 ms
    //Beats
    //56.36%
    //Memory
    //97.1 MB
    //Beats
    //87.27%
    static int largestPathValue(String colors, int[][] edges) {
        List<List<Integer>> listAlph = new ArrayList<>();
        List<int[]> count = new ArrayList<>();
        int n = colors.length();
        for (int i = 0; i < n; i++) {
            listAlph.add(new ArrayList<>());
            count.add(new int[26]);
        }
        int[] incomingNodesNum = new int[n];
        for (int[] edge : edges) {
            listAlph.get(edge[0]).add(edge[1]);
            incomingNodesNum[edge[1]]++;
        }
        List<Integer> queue = new ArrayList<>();
        for (int i = 0; i < n; i++) if (incomingNodesNum[i] == 0) queue.add(i);
        int result = 0, numProcessed = 0;
        while (!queue.isEmpty()) {
            List<Integer> queueTemp = new ArrayList<>();
            for (int i : queue) {
                numProcessed++;
                result = Math.max(result, ++count.get(i)[colors.charAt(i) - 'a']);
                for (int j : listAlph.get(i)) {
                    for (int k = 0; k < 26; k++) {
                        count.get(j)[k] = Math.max(count.get(j)[k], count.get(i)[k]);
                    }
                    if (--incomingNodesNum[j] == 0) queueTemp.add(j);
                }
            }
            queue = queueTemp;
        }
        return numProcessed != n ? -1 : result;
    }

    //TLE on 40/83
    static int largestPathValue1(String colors, int[][] edges) {
        if (edges.length == 0) return 1;
        int[] alph; // to keep freq of colors along the path
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            if (map.containsKey(a)) {
                map.get(a).add(b);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(b);
                map.put(a, list);
            }
        }

        GraphNode[] arrNodes = new GraphNode[colors.length()];
        for (int key : map.keySet()) {
            if (arrNodes[key] == null) arrNodes[key] = new GraphNode(key);
            List<Integer> list = map.get(key);
            for (int n : list) {
                GraphNode neighbor = new GraphNode(n);
                if (arrNodes[n] == null) arrNodes[n] = neighbor;
                arrNodes[key].neighbors.add(arrNodes[n]);
            }
        }
        int[] res = new int[1];
        int max = 0;
        boolean[] visited;

        for (GraphNode node : arrNodes) {
            alph = new int[26];
            visited = new boolean[arrNodes.length];
            alph[colors.charAt(node.val) - 'a']++;
            goDFS(node, res, visited, alph, colors);
        }
        return res[0];
    }

    private static void goDFS(GraphNode arrNode, int[] res, boolean[] visited, int[] alph, String colors) {
        if (res[0] == -1) return;
        if (visited[arrNode.val]) {
            res[0] = -1;
            return;
        }

        visited[arrNode.val] = true;

        //find max
        int max = findMax(alph);
        if (res[0] < max) res[0] = max;

        for (GraphNode child : arrNode.neighbors) {
            alph[colors.charAt(child.val) - 'a']++;
            goDFS(child, res, visited, alph, colors);
            alph[colors.charAt(child.val) - 'a']--;
        }
        visited[arrNode.val] = false;
    }

    private static int findMax(int[] alph) {
        int max = 0;
        for (int n : alph) if (max < n) max = n;
        return max;
    }

    static class GraphNode {
        public int val;
        public List<GraphNode> neighbors;
        public GraphNode() {
            val = 0;
            neighbors = new ArrayList<GraphNode>();
        }
        public GraphNode(int _val) {
            val = _val;
            neighbors = new ArrayList<GraphNode>();
        }
        public GraphNode(int _val, ArrayList<GraphNode> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

            /*Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        boolean[] visited = new boolean[map.size()];
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (visited[curr]) return -1;

        }*/
}
