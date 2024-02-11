package LeetCode.medium;
import java.util.*;

public class Problem1650 {
    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/
    public static void main(String[] args) {

    }


    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/solutions/4711432/java-o-n-solution/
    //15-20min
    //Runtime
    //29
    //ms
    //Beats
    //62.91%
    //of users with Java
    //Memory
    //44.56
    //MB
    //Beats
    //50.38%
    //of users with Java
    static Node lowestCommonAncestor(Node p, Node q) {
        //1.take p and put parents to a set
        //take q and traverse parents and check in set. if Yes, then return the first match
        //2.take p and ckeck children for q. if yes, return p
        //3.take q and check children for p. if yes, return q


        Node[] res = new Node[1];
        goDFS(p, res, p, q);
        if (res[0] != null) return res[0];

        goDFS(q, res, q, p);
        if (res[0] != null) return res[0];

        Set<Node> set = new HashSet<>();
        Node t = p;
        while (t.parent != null) {
            set.add(t.parent);
            t = t.parent;
        }
        t = q;
        while (t.parent != null) {
            if (set.contains(t.parent)) return t.parent;
            t = t.parent;
        }
        return null;
    }

    private static void goDFS(Node cur, Node[] res, Node a, Node searched) {
        if (cur == null) return;

        if (cur.val == searched.val) {
            res[0] = a;
            return;
        }

        goDFS(cur.left, res, a, searched);
        goDFS(cur.right, res, a, searched);
    }
}
