package LeetCode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem1443 {
    //https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/description/
    public static void main(String[] args) {
        /*List<Boolean> hasApple = Arrays.asList(false, false, true, false, true, true, false);
        int[][] edges = new int[][] {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
        System.out.println(minTime(7, edges, hasApple));

        List<Boolean> hasApple1 = Arrays.asList(true, true, true, true);
        int[][] edges1 = new int[][] {{0,1},{1,2},{0,3}};
        System.out.println(minTime(4, edges1, hasApple1));

        List<Boolean> hasApple2 = Arrays.asList(false, true, false);
        int[][] edges2 = new int[][] {{0,1},{0,2}};
        System.out.println(minTime(3, edges2, hasApple2));*/

        List<Boolean> hasApple3 = Arrays.asList(true,true,false,true,false,true,true,false);
        int[][] edges3 = new int[][] {{0,1},{1,2},{2,3},{1,4},{2,5},{2,6},{4,7}};
        System.out.println(minTime(8, edges3, hasApple3));
    }

    //1 - 1.25 hour
    //https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/solutions/3034397/java-dfs-multinode-tree-solution/
    //Runtime
    //43 ms
    //Beats
    //78.24%
    //Memory
    //85.4 MB
    //Beats
    //67.6%
    static int countApples, seconds;
    static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        if (n == 1) return 0;
        NTreeNode[] arr = new NTreeNode[n];
        for (int i = 0; i < n; i++) {
            int val = hasApple.get(i) ? 1 : 0;
            arr[i] = new NTreeNode(val);
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

        countApples = 0;
        seconds = 0;
        traverseAndSignPathInTree(arr[0], arr[0].val);
        traverseAndCountInTree(arr[0]);
        return arr[0].val == 1 ? seconds - 2 : seconds;
    }

    private static void traverseAndCountInTree(NTreeNode node) {
        if (node == null) return;
        if (node.val == 1) seconds+=2;
        for (int i = 0; i < node.children.size(); i++) traverseAndCountInTree(node.children.get(i));
    }

    private static void traverseAndSignPathInTree(NTreeNode node, int apples) {
        if (node == null) return;
        if (node.val == 1) countApples++;
        for (int i = 0; i < node.children.size(); i++) traverseAndSignPathInTree(node.children.get(i), countApples);
        if (apples < countApples) node.val = 1;
    }
}
