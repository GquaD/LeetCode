package LeetCode.medium;

public class Problem1485 {
    //https://leetcode.com/problems/clone-binary-tree-with-random-pointer
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/clone-binary-tree-with-random-pointer/solutions/4762512/java-dfs-o-n-solution/
    //10min
    //Runtime
    //5
    //ms
    //Beats
    //90.24%
    //of users with Java
    //Memory
    //45.52
    //MB
    //Beats
    //57.93%
    //of users with Java
    /*NodeCopy copyRandomBinaryTree(Node root) {
        if (root == null) return null;
        NodeCopy node = new NodeCopy(root.val);
        Map<Node, NodeCopy> map = new HashMap<>();

        copyVal(root, node, map);
        copyRandom(root, node, map);
        return node;
    }

    private void copyVal(Node a, NodeCopy b, Map<Node, NodeCopy> map) {
        if (a == null) return;

        map.put(a, b);

        if (a.left != null) b.left = new NodeCopy(a.left.val);
        if (a.right != null) b.right = new NodeCopy(a.right.val);

        copyVal(a.left, b.left, map);
        copyVal(a.right, b.right, map);
    }

    private void copyRandom(Node a, NodeCopy b, Map<Node, NodeCopy> map) {
        if (a == null) return;

        if (a.random != null) b.random = map.get(a.random);

        copyRandom(a.left, b.left, map);
        copyRandom(a.right, b.right, map);
    }*/
}
