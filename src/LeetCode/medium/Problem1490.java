package LeetCode.medium;

public class Problem1490 {
    //https://leetcode.com/problems/clone-n-ary-tree
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/clone-n-ary-tree/solutions/4680928/java-100-faster-dfs-solution/
    //10-15min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //46.90
    //MB
    //Beats
    //29.08%
    //of users with Java

/*    static Node cloneTree(Node root) {
        if (root == null) return null;
        Node n1 = new Node(root.val);
        goDFS(n1, root);
        return n1;
    }

    private void goDFS(Node a, Node b) {
        if (b == null) return;

        if (b.children != null) {
            List<Node> c = new ArrayList<>();
            for (int i = 0; i < b.children.size(); i++) {
                Node bb = b.children.get(i), aa = new Node(bb.val);
                goDFS(aa, bb);
                c.add(aa);
            }
            a.children = c;
        }
    }*/
}
