package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem235 {
    static TreeNode tempCommonParent;

    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
    public static void main(String[] args) {
        //todo
        TreeNode root = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(8);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(9);
        TreeNode node8 = new TreeNode(3);
        TreeNode node9 = new TreeNode(5);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;
        System.out.println(lowestCommonAncestor(root, node2, node7).val);
        System.out.println(lowestCommonAncestor(root, node2, node5).val);
        System.out.println(lowestCommonAncestor(root, node2, node5).val);

        TreeNode root2 = new TreeNode(2);
        TreeNode node22 = new TreeNode(1);
        root2.left = node22;

        System.out.println(lowestCommonAncestor(root2, root2, node22).val);

        TreeNode root3 = new TreeNode(3);
        TreeNode child1 = new TreeNode(1);
        TreeNode child4 = new TreeNode(4);
        TreeNode child2 = new TreeNode(2);

        root3.left = child1;
        root3.right = child4;
        child1.right = child2;
        System.out.println(lowestCommonAncestor(root3, child2, child4).val);
    }

    //Runtime: 24 ms, faster than 5.82% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
    //Memory Usage: 49.2 MB, less than 81.21% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> listP = new ArrayList<>();
        List<TreeNode> listQ = new ArrayList<>();

        searchBST(root, p, listP);
        searchBST(root, q, listQ);

        listP = removeUnnecessaryNodesFromPath(listP);
        listQ = removeUnnecessaryNodesFromPath(listQ);

        if (listP.size() == listQ.size() && listP.size() == 1) {
            return root;
        }
        return findLowestCommonAncestorNode(listP, listQ);
    }

    private static List<TreeNode> removeUnnecessaryNodesFromPath(List<TreeNode> listP) {
        TreeNode current = listP.get(listP.size() - 1);
        for (int i = listP.size() - 1; i > 0; i--) {
            TreeNode prev = listP.get(i - 1);
            if (prev.left != current && prev.right != current) {
                listP.remove(i - 1);
            } else {
                current = prev;
            }

        }
        return listP;
    }

    private static TreeNode findLowestCommonAncestorNode(List<TreeNode> listP, List<TreeNode> listQ) {
        TreeNode result = null;
        for (int i = 0; i < listP.size(); i++) {
            for (int j = 0; j < listQ.size(); j++) {
                if (listP.get(i).equals(listQ.get(j))) {
                    result = listQ.get(j);
                }
            }
        }
        return result;
    }

    public static void searchBST(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root == null) {
            return;
        }
        path.add(root);
        if (root.equals(target)) {
            //path.add(root);
            return;
        }
        searchBST(root.left, target, path);
        if (!path.get(path.size() - 1).equals(target)) {
            searchBST(root.right, target, path);
        }
    }

    //need to check case with one child node
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        while (true) {
            if (p.left != null && p.left.equals(q) || p.right != null && p.right.equals(q)) {
                return p;
            }
            if (q.left != null && q.left.equals(p) || q.right != null && q.right.equals(p)) {
                return q;
            }
            if (root.left != null && root.right != null) {
                if (root.equals(p) && root.left.equals(q) || root.equals(p) && root.right.equals(q)) {
                    return p;
                }
                if (root.equals(q) && root.left.equals(p) || root.equals(q) && root.right.equals(p)) {
                    return q;
                }
                if (root.left.equals(p) && root.right.equals(q)
                        || root.left.equals(q) && root.right.equals(p)) {
                    return root;
                }
            } else if (root.left != null) {
                if (root.equals(p) && root.left.equals(q)) {
                    return p;
                }
                if (root.equals(q) && root.left.equals(p)) {
                    return q;
                }
                if (root.left.equals(p) || root.left.equals(q)) {
                    return root;
                }
            } else if (root.right != null) {
                if (root.equals(p) && root.right.equals(q)) {
                    return p;
                }
                if (root.equals(q) && root.right.equals(p)) {
                    return q;
                }
                if (root.right.equals(p) || root.right.equals(q)) {
                    return root;
                }
            }

            TreeNode node = lowestCommonAncestor(root.left, p, q);
            if (node == null) {
                node = lowestCommonAncestor(root.right, p, q);
            }
            return node;
        }
    }


    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
