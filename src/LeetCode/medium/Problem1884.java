package LeetCode.medium;

public class Problem1884 {
    //https://leetcode.com/problems/egg-drop-with-2-eggs-and-n-floors/
    public static void main(String[] args) {
        System.out.println(twoEggDrop(100));
    }

    static int maxDepth;
    static int twoEggDrop(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) arr[i] = i;
        TreeNode root = sortedArrayToBST1(arr);
        maxDepth = 0;
        traverseTree(0, root);
        return maxDepth;
    }

    private static void traverseTree(int lvl, TreeNode node) {
        if (node == null) return;

        lvl++;
        if (maxDepth < lvl) maxDepth = lvl;
        traverseTree(lvl, node.left);
        traverseTree(lvl, node.right);
    }

    static TreeNode sortedArrayToBST1(int[] nums) {
        boolean visited[] = new boolean[nums.length];
        TreeNode node = new TreeNode(nums[nums.length / 2]);
        constructBinarySearchTree(nums, visited, node, 0, nums.length / 2, nums.length - 1);
        return node;
    }

    private static void constructBinarySearchTree(int[] arr, boolean[] visited, TreeNode node,
                                                  int idxLeft, int idxCenter, int idxRight) {
        if (visited[idxCenter]) {
            return;
        }

        visited[idxCenter] = true;
        //go left
        int newCenterForLeft = idxLeft + (idxCenter - idxLeft) / 2;
        if (newCenterForLeft >= arr.length || newCenterForLeft < 0) return;
        if (!visited[newCenterForLeft] && arr[newCenterForLeft] < node.val) {
            node.left = new TreeNode(arr[newCenterForLeft]);
            constructBinarySearchTree(arr, visited, node.left, idxLeft, newCenterForLeft, idxCenter);
        }
        //go right
        int newCenterForRight = idxRight - (idxRight - idxCenter) / 2;
        if (newCenterForRight >= arr.length || newCenterForRight < 0) return;
        if (!visited[newCenterForRight] && arr[newCenterForRight] > node.val) {
            node.right = new TreeNode(arr[newCenterForRight]);
            constructBinarySearchTree(arr, visited, node.right, idxCenter, newCenterForRight, idxRight);
        }
    }
}
