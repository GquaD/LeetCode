package LeetCode.medium;

import javafx.util.Pair;

import java.util.*;

public class Problem979 {
    //https://leetcode.com/problems/distribute-coins-in-binary-tree/
    public static void main(String[] args) {
        /*TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(0);
        TreeNode n3 = new TreeNode(0);
        n1.left = n2;
        n1.right = n3;*/
        /*TreeNode n1 = new TreeNode(0);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(0);
        n1.left = n2;
        n1.right = n3;*/
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(0);
        TreeNode n3 = new TreeNode(0);
        TreeNode n4 = new TreeNode(0);
        n1.left = n2;
        n2.right = n3;
        n3.right = n4;
        System.out.println(distributeCoins(n1));
    }

    //nnnn
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //42.1 MB
    //Beats
    //53.50%
    static int res;
    static int distributeCoins(TreeNode root) {
        res = 0;
        helperDFS(root);
        return res;
    }

    private static int helperDFS(TreeNode node) {
        if (node == null) return 0;
        int left = helperDFS(node.left), right = helperDFS(node.right);
        res += Math.abs(left) + Math.abs(right);
        return node.val + left + right - 1;
    }


    static int distributeCoins3(TreeNode root) {
        //adj map
        //BFS and count
        Map<Integer, List<Integer>> mapAdj = new HashMap<>();
        Map<Integer, Integer> mapVal = new HashMap<>();
        goDFS(root, 0, mapAdj, mapVal, -1);
        int runningSum = 0, count = 0;
        for (int key : mapVal.keySet()) {
            int val = mapVal.get(key);
            if (val > 1) {
                runningSum += val - 1;
                mapVal.put(key, 1);
                Queue<Integer> queue = new LinkedList<>();
                queue.add(key);
                int step = 1;
                while (!queue.isEmpty() && runningSum > 0) {
                    LinkedHashSet<Integer> queueNext = new LinkedHashSet<>();
                    while (!queue.isEmpty()) {
                        int currId = queue.poll();
                        List<Integer> list = mapAdj.get(currId);
                        for (int id : list) {
                            if (mapVal.get(id) > 1) {
                                runningSum += mapVal.get(id) - 1;
                                mapVal.put(id, 1);
                            } else if (mapVal.get(id) == 0) {
                                mapVal.put(id, 1);
                                count += step;
                                runningSum--;
                            }
                            if (runningSum > 0) queueNext.addAll(mapAdj.get(currId));
                        }
                    }
                    step++;
                    queue = new LinkedList<>(queueNext);
                }
            }
        }
        return count;
    }

    private static void goDFS(TreeNode node, int id, Map<Integer, List<Integer>> mapAdj, Map<Integer, Integer> mapVal, int parent) {
        if (node == null) return;

        mapVal.put(id, node.val);
        List<Integer> list = mapAdj.computeIfAbsent(id, ArrayList::new);
        if (parent != -1) list.add(parent);
        if (node.left != null) list.add(id + 1);
        if (node.right != null) list.add(id + 2);

        goDFS(node.left, id + 1, mapAdj, mapVal, id);
        goDFS(node.right, id + 2, mapAdj, mapVal, id);
    }

    static class iPair {
        int id, val;

        public iPair(int id, int val) {
            this.id = id;
            this.val = val;
        }
    }
}
