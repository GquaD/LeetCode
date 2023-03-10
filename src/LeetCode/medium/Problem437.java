package LeetCode.medium;

import java.util.ArrayList;

public class Problem437 {
    //https://leetcode.com/problems/path-sum-iii/
    public static void main(String[] args) {
        TreeNode n10 = new TreeNode(10);
        TreeNode n5 = new TreeNode(5);
        TreeNode n3 = new TreeNode(3);
        TreeNode n31 = new TreeNode(3);
        TreeNode nm2 = new TreeNode(-2);
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);
        TreeNode nm3 = new TreeNode(-3);
        TreeNode n11 = new TreeNode(11);
        n10.left = n5;
        n10.right = nm3;
        nm3.right = n11;
        n5.left = n3;
        n5.right = n2;
        n3.left = n31;
        n3.right = nm2;
        n2.right = n1;
        System.out.println(pathSum(n10, 8));
    }

    //https://leetcode.com/problems/path-sum-iii/solutions/3280413/java-dfs-7ms-solution/
    //1.5 hours
    //Runtime
    //7 ms
    //Beats
    //48.93%
    //Memory
    //42 MB
    //Beats
    //70.23%
    static int count;
    static int pathSum(TreeNode root, int targetSum) {
        count = 0;
        if (root != null && root.left == null && root.right == null) return root.val == targetSum ? 1 : 0;
        goDFS(root, new ArrayList<>(), targetSum);
        return count;
    }

    private static void goDFS(TreeNode node, ArrayList<Integer> list, int targetSum) {
        if (node == null) return;

        list.add(node.val);

        goDFS(node.left, list, targetSum);
        goDFS(node.right, list, targetSum);
        long tempSum = 0;
        for (int i = list.size() - 1; i >= 0 ; i--) {
            tempSum += list.get(i);
            if (tempSum == targetSum) count++;
        }

        list.remove(list.size() - 1);
    }
}
