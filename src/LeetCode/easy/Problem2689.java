package LeetCode.easy;

public class Problem2689 {

    //20min
    //Runtime
    //2
    //ms
    //Beats
    //41.03%
    //Analyze Complexity
    //Memory
    //52.13
    //MB
    //Beats
    //53.76%
    /**
     * Definition for a rope tree node.
     * class RopeTreeNode {
     *     int len;
     *     String val;
     *     RopeTreeNode left;
     *     RopeTreeNode right;
     *     RopeTreeNode() {}
     *     RopeTreeNode(String val) {
     *         this.len = 0;
     *         this.val = val;
     *     }
     *     RopeTreeNode(int len) {
     *         this.len = len;
     *         this.val = "";
     *     }
     *     RopeTreeNode(int len, RopeTreeNode left, RopeTreeNode right) {
     *         this.len = len;
     *         this.val = "";
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
//    class Solution {
//        public char getKthCharacter(RopeTreeNode root, int k) {
//            return goDFS(root, k).charAt(k - 1);
//        }
//
//        private String goDFS(RopeTreeNode node, int k) {
//            if (node == null) return "";
//
//            String s = goDFS(node.left, k);
//            s += node.val;
//            s += goDFS(node.right, k);
//
//            return s;
//        }
//    }
}
