package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem113 {
    //https://leetcode.com/problems/path-sum-ii/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/path-sum-ii/solutions/3208616/java-o-n-dfs-100-faster-solution/
    //15 min
    //Runtime
    //1 ms
    //Beats
    //100%
    //Memory
    //42.9 MB
    //Beats
    //36.37%
    static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> listResult = new ArrayList<>();
        goDFS(root, 0, targetSum, new ArrayList<>(), listResult);
        return listResult;
    }

    private static void goDFS(TreeNode node, int currSum, int targetSum, ArrayList<Integer> list, List<List<Integer>> listResult) {
        if (node == null) return;

        if (node.left == null && node.right == null && currSum == targetSum) {
            listResult.add(new ArrayList<>(list));
        }
        currSum += node.val;
        list.add(node.val);

        goDFS(node.left, currSum, targetSum, list, listResult);
        goDFS(node.right, currSum, targetSum, list, listResult);
        list.remove(list.size() - 1);
    }



/*    static List<List<Integer>> result;

    static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        traverseTree(root, 0, targetSum, new ArrayList<>());
        return result;
    }


    private static void traverseTree(TreeNode node, int sum, int targetSum, List<Integer> list) {
        if (node == null) return;

        sum += node.val;
        if (sum > targetSum) return;
        if (node.left == null && node.right == null && sum == targetSum) {
            list.add(node.val);
            result.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }

        list.add(node.val);
        traverseTree(node.left, sum, targetSum, list);
        traverseTree(node.right, sum, targetSum, list);
        list.remove(list.size() - 1);
    }*/
}
