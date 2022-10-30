package LeetCode.easy;

public class Problem108 {
    //https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
    public static void main(String[] args) {

    }


    //https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/solutions/2758563/java-recursive-solution-in-just-1-ms/
    //Runtime
    //1 ms
    //Beats
    //43.88%
    //Memory
    //43.6 MB
    //Beats
    //51.31%
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
