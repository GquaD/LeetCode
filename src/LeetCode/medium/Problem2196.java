package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Problem2196 {
    //https://leetcode.com/problems/create-binary-tree-from-descriptions/
    public static void main(String[] args) {
        TreeNode treeNode = createBinaryTree(new int[][]{
                {20,15,1},
                {20,17,0},
                {50,20,1},
                {50,80,0},
                {80,19,1}
        });
    }

    //Runtime: 192 ms, faster than 14.01% of Java online submissions for Create Binary Tree From Descriptions.
    //Memory Usage: 121.1 MB, less than 9.24% of Java online submissions for Create Binary Tree From Descriptions.
    static TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Map<Integer, Integer> parentMap = new HashMap<>();
        for (int[] desc : descriptions) {
            TreeNode curr = null;
            int parent = desc[0], child = desc[1];
            boolean isLeft = desc[2] == 1;
            if (!map.containsKey(parent)) {
                curr = new TreeNode(parent);
                map.put(parent, curr);
            }
            curr = map.get(parent);
            if (isLeft) {
                TreeNode left = null;
                if (!map.containsKey(child)) {
                    left = new TreeNode(child);
                    map.put(child, left);
                }
                left = map.get(child);
                curr.left = map.get(child);
                parentMap.put(left.val, curr.val);
            } else {
                TreeNode right = null;
                if (!map.containsKey(child)) {
                    right = new TreeNode(child);
                    map.put(child, right);
                }
                right = map.get(child);
                curr.right = map.get(child);
                parentMap.put(right.val, curr.val);
            }
        }
        TreeNode root = null;
        for (Integer key : map.keySet()) {
            if (!parentMap.containsKey(key)) {
                root = map.get(key);
                break;
            }
        }
        return root;
    }


    static TreeNode found;
    static TreeNode createBinaryTree1(int[][] descriptions) {
        found = null;
        int[] first = descriptions[0];
        TreeNode root = new TreeNode(first[0]);
        int rootIsLeft = first[2];
        for (int i = 0; i < descriptions.length; i++) {
            int[] current = descriptions[i];
            findNode(root, current[0]);
            TreeNode foundParent = found;
            found = null;
            findNode(root, current[1]);
            if (foundParent != null && found == null) {
                insertIntoTree(found, current[1], current[2]);
            } else if (foundParent != null && found != null) {
                if (current[2] == 1) {
                    foundParent.left = found;
                } else {
                    foundParent.right = found;
                }
            }
            else {
                TreeNode p = new TreeNode(current[0]);
                insertIntoTree(p, current[1], current[2]);
                if (rootIsLeft == 1) {
                    p.left = root;
                } else {
                    p.right = root;
                }
                root = p;
                rootIsLeft = current[2];
            }
            found = null;
        }
        return root;
    }

    private static void insertIntoTree(TreeNode find, int val, int isLeft) {
        if (isLeft == 1) {
            find.left = new TreeNode(val);
        } else {
            find.right = new TreeNode(val);
        }
    }

    private static void findNode(TreeNode node, int val) {
        if (node == null) return;

        if (node.val == val) {
            found = node;
        }

        findNode(node.left, val);
        findNode(node.right, val);
    }
}
