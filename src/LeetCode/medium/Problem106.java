package LeetCode.medium;

public class Problem106 {
    //https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
    public static void main(String[] args) {
        buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
        buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
    }

    //nnnn
    //Runtime
    //1 ms
    //Beats
    //100%
    //Memory
    //42.3 MB
    //Beats
    //42.77%
    static int inIdx, postIdx;
    static TreeNode buildTree(int[] inorder, int[] postorder) {
        inIdx = inorder.length - 1;
        postIdx = inIdx;
        return goRecursive(inorder, postorder, 3001);
    }

    private static TreeNode goRecursive(int[] inorder, int[] postorder, int boundary) {
        if (postIdx == -1 || inorder[inIdx] == boundary) return null;
        TreeNode node = new TreeNode(postorder[postIdx--]);
        node.right = goRecursive(inorder, postorder, node.val);
        inIdx--;
        node.left = goRecursive(inorder, postorder, boundary);
        return node;
    }

    static TreeNode buildTree1(int[] inorder, int[] postorder) {
        int rootVal = postorder[postorder.length - 1], idxRoot = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                idxRoot = i;
                break;
            }
        }
        boolean visited[] = new boolean[inorder.length];
        TreeNode root = new TreeNode(rootVal);
        constructBinarySearchTree(inorder, visited, root, 0, idxRoot, inorder.length - 1);
        return root;
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
        if (!visited[newCenterForLeft]) {
            node.left = new TreeNode(arr[newCenterForLeft]);
            constructBinarySearchTree(arr, visited, node.left, idxLeft, newCenterForLeft, idxCenter);
        }
        //go right
        int newCenterForRight = idxRight - (idxRight - idxCenter) / 2;
        if (newCenterForRight >= arr.length || newCenterForRight < 0) return;
        if (!visited[newCenterForRight]) {
            node.right = new TreeNode(arr[newCenterForRight]);
            constructBinarySearchTree(arr, visited, node.right, idxCenter, newCenterForRight, idxRight);
        }
    }
}
