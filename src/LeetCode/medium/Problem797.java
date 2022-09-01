package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.*;

public class Problem797 {
    //https://leetcode.com/problems/all-paths-from-source-to-target/
    public static void main(String[] args) {
        LeetCodeUtils.printListWithListsOfIntegers(allPathsSourceTarget(new int[][]{
                {4,3,1},
                {3,2,4},
                {},
                {4},
                {}
        })); //[[0,4],[0,3,4],[0,1,3,4],[0,1,4]]
        System.out.println();
        LeetCodeUtils.printListWithListsOfIntegers(allPathsSourceTarget(new int[][]{
                {2},
                {3},
                {1},
                {}
        }));
        System.out.println();
        LeetCodeUtils.printListWithListsOfIntegers(allPathsSourceTarget(new int[][]{
                {4,3,1},
                {3,2,4},
                {3},
                {4},
                {}
        }));
        System.out.println();
        LeetCodeUtils.printListWithListsOfIntegers(allPathsSourceTarget(new int[][]{
                {1,2},
                {3},
                {3},
                {}
        }));
    }
    //yeap!! 1 day for solving =|
    //Runtime: 6 ms, faster than 42.26% of Java online submissions for All Paths From Source to Target.
    //Memory Usage: 43.8 MB, less than 98.44% of Java online submissions for All Paths From Source to Target.
    static List<List<Integer>> listBig;
    static List<Integer> listTemp;
    static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        listBig = new ArrayList<>();
        listTemp = new ArrayList<>();
        int[][] arr = make2DGridForGraph(graph);
        //build trie
        TrieNode root = new TrieNode(0);
        buildTrie(root, arr, 0);
        traverseTrie(root);
        return filterList(listBig, graph.length - 1);
    }

    private static List<List<Integer>> filterList(List<List<Integer>> listBig, int n) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < listBig.size(); i++) {
            List<Integer> curr = listBig.get(i);
            if (curr.get(curr.size() - 1) == n) {
                list.add(curr);
            }
        }
        return list;
    }

    private static void traverseTrie(TrieNode node) {
        if (node == null) {
            return;
        }

        listTemp.add(node.value);
        if (node.nodes.size() == 0) {
            listBig.add(listTemp);
            listTemp = new ArrayList<>(listTemp);
            listTemp.remove(listTemp.size() - 1);
            return;
        }
        for (int i = 0; i < node.nodes.size(); i++) {
            traverseTrie(node.nodes.get(i));
        }
        listTemp.remove(listTemp.size() - 1);
    }

    private static void buildTrie(TrieNode node, int[][] arr, int indexRow) {
        if (indexRow >= arr.length - 1 || node.value == arr.length - 1) {
            return;
        }
        for (int i = 0; i < arr[indexRow].length; i++) {
            if (arr[indexRow][i] == 1) {
                node.nodes.add(new TrieNode(i));
            }
        }
        for (int i = 0; i < node.nodes.size(); i++) {
            buildTrie(node.nodes.get(i), arr, node.nodes.get(i).value);
        }
    }

    static class TrieNode {
        int value;
        List<TrieNode> nodes;

        public TrieNode(int v) {
            value = v;
            nodes = new LinkedList<>();
        }
    }


    static List<List<Integer>> allPathsSourceTarget3(int[][] graph) {
        int[][] arr = make2DGridForGraph(graph);
        List<List<Integer>> list = new ArrayList<>();
        //created 0 -> all first level connections
        for (int i = 0; i < arr[0].length; i++) {
            if (arr[0][i] == 1) {
                List<Integer> temp = new ArrayList<>();
                temp.add(0);
                temp.add(i);
                list.add(temp);
            }
        }
        int countRow = 1;
        while (countRow < arr.length - 1) {
            List<Integer> integersForTheRow = new ArrayList<>();
            for (int i = 0; i < arr[countRow].length; i++) {
                if (arr[countRow][i] == 1) {
                    integersForTheRow.add(i);
                }
            }

            for (int i = 0; i < list.size(); i++) {
                List<Integer> listTemp = list.get(i);
                if (listTemp.size() != 0 && listTemp.get(listTemp.size() - 1) == countRow) {
                    for (int j = 0; j < integersForTheRow.size(); j++) {
                        List<Integer> copyPlusNewNumber = new ArrayList<>();
                        copyListToList(copyPlusNewNumber, listTemp);
                        copyPlusNewNumber.add(integersForTheRow.get(j));
                        list.add(copyPlusNewNumber);
                    }
                    list.remove(i);
                    list.add(i, Collections.emptyList());
                }
            }
            countRow++;
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).size() > 0) {
                res.add(list.get(i));
            }
        }
        return res;
    }

    private static void copyListToList(List<Integer> dest, List<Integer> src) {
        for (int i = 0; i < src.size(); i++) {
            dest.add(src.get(i));
        }
    }

    /*for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
            }

        }*/

    static List<List<Integer>> allPathsSourceTarget2(int[][] graph) {
        int[][] arr = make2DGridForGraph(graph);
        Queue<String> queue = new LinkedList<>();
        List<List<Integer>> listMain = new ArrayList<>();
        int count = -1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    if (i != 0) {
                        String t = queue.poll();
                        t += " " + j;
                        for (int k = 0; k < listMain.size(); k++) {
                            List<Integer> temp = listMain.get(k);
                            if (temp.get(temp.size() - 1) == i) {

                            }
                        }
                        queue.add(t);
                    } else {
                        String t = " " + j;
                        List<Integer> listTemp = new ArrayList<>();
                        listTemp.add(i);
                        listMain.add(listTemp);
                        queue.add(t);
                    }
                }
            }
            count++;
        }
        List<List<Integer>> res = new ArrayList<>();
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            String temp = queue.poll();
            List<Integer> list = new ArrayList<>();
            list.add(0);
            String[] nums = temp.trim().split(" ");
            for (int j = 0; j < nums.length; j++) {
                list.add(Integer.parseInt(nums[i]));
            }
            res.add(list);
        }
        return res;

        /*
        TrieNode zero = new TrieNode(0);
        List<TrieNode> list = new ArrayList<>();
        for (int j = 0; j < graph[0].length; j++) {
            TrieNode curr = new TrieNode(graph[0][j]);
            list.add(curr);
        }
        zero.nodes = list;
        for (int i = 0; i < graph.length; i++) {
            List<TrieNode> list = new ArrayList<>();
            for (int j = 0; j < graph[i].length; j++) {
                TrieNode curr = new TrieNode(graph[i][j]);
                list.add(curr);
            }
            zero.nodes = list;
        }*/
    }

    private static int[][] make2DGridForGraph(int[][] graph) {
        int[][] grid = new int[graph.length][graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                grid[i][graph[i][j]] = 1;
            }
        }
        return grid;
    }

    static List<List<Integer>> allPathsSourceTarget1(int[][] graph) {
        List<List<Integer>> queue = new LinkedList<>();

        int fixIndex = -1;

        for (int j = 0; j < graph[0].length; j++) {
            List<Integer> temp = new LinkedList<>();
            temp.add(j);
        }

        while (queue.size() > 0) {
            for (int i = 1; i < graph.length; i++) {
                for (int j = 0; j < graph[i].length; j++) {
                    List<Integer> temp = new LinkedList<>();
                    temp.add(i);
                    temp.add(graph[i][j]);
                    queue.add(temp);
                    if (temp.get(temp.size() - 1) == graph.length - 1) {
                        fixIndex++;
                    }
                }
            }
        }
        return queue;
    }


}
