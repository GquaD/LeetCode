package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem1372 {
    //https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(1);
        TreeNode n6 = new TreeNode(1);
        TreeNode n7 = new TreeNode(1);
        TreeNode n8 = new TreeNode(1);
        n1.right = n2;
        n2.left = n3;
        n2.right = n4;
        n4.left = n5;
        n4.right = n6;
        n5.right = n7;
        n7.right = n8;
        System.out.println(longestZigZag(n1));
    }
    //https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/solutions/3434397/java-99-7-faster-dfs-o-n-solution/
    //Runtime
    //6 ms
    //Beats
    //99.70%
    //Memory
    //52.6 MB
    //Beats
    //97.62%

    private static int maxLength;
    public static int longestZigZag(TreeNode root) {
        maxLength = 0;
        goDFS(root.left, true, 0);
        goDFS(root.right, false, 0);
        return maxLength;
    }

    private static void goDFS(TreeNode node, boolean isLeft, int len) {
        if (node == null) {
            if (maxLength < len) maxLength = len;
            return;
        }

        if (isLeft) {
            goDFS(node.right, false, len + 1);
            goDFS(node.left, true, 0);
        } else {
            goDFS(node.left, true, len + 1);
            goDFS(node.right, false, 0);
        }
    }

    //TLE 53/58
    static int maxLength1;
    static int longestZigZag1(TreeNode root) {
        maxLength = 0;
        goDFS(root, new ArrayList<>());
        return maxLength;
    }

    private static void goDFS(TreeNode node, List<Boolean> list) {
        if (node == null) {
            int len = findZigZagLength(list);
            if (maxLength < len) maxLength = len;
            return;
        }


        if (node.left != null) list.add(true);
        goDFS(node.left, list);
        if (node.left != null) list.remove(list.size() - 1);
        if (node.right != null) list.add(false);
        goDFS(node.right, list);
        if (node.right != null) list.remove(list.size() - 1);
    }

    static int findZigZagLength(List<Boolean> list) {
        int len = 0, count = 1;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) != list.get(i + 1)) {
                count++;
            } else {
                if (len < count) len = count;
                count = 1;
            }
        }
        if (len < count && list.size() > 1) len = count;
        return len;
    }

/*    static int maxLength;
    static int longestZigZag(TreeNode root) {
        maxLength = 0;
        goDFS(root.left, true, 0);
        goDFS(root.right, false, 0);
        return maxLength;
    }

    //TLE on 51/58
    private static void goDFS(TreeNode node, boolean isLeft, int len) {
        if (node == null) {
            if (maxLength < len) maxLength = len;
            return;
        }

        if (isLeft) goDFS(node.right, false, len + 1);
        else goDFS(node.left, true, len + 1);

        goDFS(node.left, true, 0);
        goDFS(node.right, false, 0);
    }*/
}
