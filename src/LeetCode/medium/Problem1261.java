package LeetCode.medium;

import java.util.*;

public class Problem1261 {
    //https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/
    public static void main(String[] args) {

    }

    //BEST result so far
    //Runtime: 48 ms, faster than 34.44% of Java online submissions for Find Elements in a Contaminated Binary Tree.
    //Memory Usage: 57 MB, less than 21.33% of Java online submissions for Find Elements in a Contaminated Binary Tree.
    //if use hashset instead of Arraylist

    //Runtime: 1078 ms, faster than 14.86% of Java online submissions for Find Elements in a Contaminated Binary Tree.
    //Memory Usage: 56.3 MB, less than 54.72% of Java online submissions for Find Elements in a Contaminated Binary Tree.
    class FindElements5 {
        TreeNode root;
        boolean exists;
        Set<Integer> set;
        public FindElements5(TreeNode root) {
            this.root = root;
            this.set = new HashSet<>();
        }

        public boolean find(int target) {
            this.exists = false;
            if (set.contains(target)) {
                return true;
            }
            find(this.root, 0, target);
            return this.exists;
        }

        private void find(TreeNode root, int val, int target) {
            if (root == null) {
                return;
            }
            if (root.val == -1) {
                root.val = val;
                this.set.add(val);
            }
            if (root.val == target) {
                exists = true;
                return;
            }
            find(root.left, val * 2 + 1, target);
            find(root.right, val * 2 + 2, target);
        }
    }

    //Runtime: 1169 ms, faster than 11.54% of Java online submissions for Find Elements in a Contaminated Binary Tree.
    //Memory Usage: 45.7 MB, less than 98.25% of Java online submissions for Find Elements in a Contaminated Binary Tree.
    class FindElements4 {
        TreeNode root;
        boolean exists;

        public FindElements4(TreeNode root) {
            this.root = root;
            //recover(root, 0);
        }

        public boolean find(int target) {
            this.exists = false;
            find(this.root, 0, target);
            return this.exists;
        }

        private void find(TreeNode root, int val, int target) {
            if (root == null) {
                return;
            }
            if (root.val == -1) {
                root.val = val;
            }
            if (root.val == target) {
                exists = true;
                return;
            }
            find(root.left, val * 2 + 1, target);
            find(root.right, val * 2 + 2, target);
        }
    }

    //Runtime: 1584 ms, faster than 5.07% of Java online submissions for Find Elements in a Contaminated Binary Tree.
    //Memory Usage: 52.5 MB, less than 73.25% of Java online submissions for Find Elements in a Contaminated Binary Tree.
    class FindElements {
        TreeNode root;
        boolean exists;

        public FindElements(TreeNode root) {
            this.root = root;
            recover(root, 0);
        }

        public boolean find(int target) {
            this.exists = false;
            find(root, target);
            return this.exists;
        }

        private void find(TreeNode root, int target) {
            if (root == null) {
                return;
            }
            if (root.val == target) {
                exists = true;
                return;
            }
            find(root.left, target);
            find(root.right, target);
        }

        private void recover(TreeNode root, int val) {
            if (root == null) {
                return;
            }
            root.val = val;
            //left
            recover(root.left, val * 2 + 1);
            //right
            recover(root.right, val * 2 + 2);
        }
    }

    //Runtime: 480 ms, faster than 24.65% of Java online submissions for Find Elements in a Contaminated Binary Tree.
    //Memory Usage: 47.1 MB, less than 93.71% of Java online submissions for Find Elements in a Contaminated Binary Tree
    //if use linkedlist instead of arraylist

    //Runtime: 48 ms, faster than 34.44% of Java online submissions for Find Elements in a Contaminated Binary Tree.
    //Memory Usage: 57 MB, less than 21.33% of Java online submissions for Find Elements in a Contaminated Binary Tree.
    //if use hashset instead of Arraylist
    class FindElements2 {
        Set<Integer> list;

        public FindElements2(TreeNode root) {
            list = new HashSet<>();
            recover(root, 0);
        }

        public boolean find(int target) {
            return list.contains(target);
        }

        private void recover(TreeNode root, int val) {
            if (root == null) {
                return;
            }
            root.val = val;
            list.add(val);
            //left
            recover(root.left, val * 2 + 1);
            //right
            recover(root.right, val * 2 + 2);
        }
    }


    //Runtime: 734 ms, faster than 20.46% of Java online submissions for Find Elements in a Contaminated Binary Tree.
    //Memory Usage: 55.9 MB, less than 63.11% of Java online submissions for Find Elements in a Contaminated Binary Tree.
    class FindElements1 {
        List<Integer> list;

        public FindElements1(TreeNode root) {
            list = new LinkedList<>();
            recover(root, 0);
        }

        public boolean find(int target) {
            return list.contains(target);
        }

        private void recover(TreeNode root, int val) {
            if (root == null) {
                return;
            }
            root.val = val;
            list.add(val);
            //left
            recover(root.left, val * 2 + 1);
            //right
            recover(root.right, val * 2 + 2);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
