package LeetCode.medium;

public class Problem510 {
    //https://leetcode.com/problems/inorder-successor-in-bst-ii/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/inorder-successor-in-bst-ii/solutions/4937491/java-o-n-solution/
    //10min
    //Runtime
    //36
    //ms
    //Beats
    //31.65%
    //of users with Java
    //Memory
    //45.10
    //MB
    //Beats
    //91.58%
    //of users with Java
    static Node inorderSuccessor(Node node) {
        Node[] root = new Node[1], res = new Node[1];
        findRoot(node, root);

        goDFS(root[0], node.val, res);
        return res[0];
    }

    public static void findRoot(Node node, Node[] root) {
        if (node == null) return;
        if (node.parent == null) root[0] = node;
        findRoot(node.parent, root);
    }

    public static void goDFS(Node node, int t, Node[] res) {
        if (node == null) return;

        if (node.val > t) {
            if (res[0] == null) {
                res[0] = node;
            } else {
                if (node.val < res[0].val) {
                    res[0] = node;
                }
            }
        }
        goDFS(node.left, t, res);
        goDFS(node.right, t, res);
    }
}
