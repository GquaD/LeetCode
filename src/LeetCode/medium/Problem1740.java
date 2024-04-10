package LeetCode.medium;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Problem1740 {
    //https://leetcode.com/problems/find-distance-in-a-binary-tree/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-distance-in-a-binary-tree/solutions/5004025/java-dfs-find-path-solution/
    //15min
    //Runtime
    //11
    //ms
    //Beats
    //13.53%
    //of users with Java
    //Memory
    //47.42
    //MB
    //Beats
    //5.85%
    //of users with Java
    public int findDistance(TreeNode root, int p, int q) {
        Set<Integer> setp = new LinkedHashSet<>(), setq = new LinkedHashSet<>();

        findPath(root, p, setp);
        findPath(root, q, setq);

        int count = 0;
        List<Integer> listp = new ArrayList(setp), listq = new ArrayList(setq);
        // if (setq.contains(p)) {//means p is parent of q
        for (int i = listq.size() - 1; i >= 0; i--) {
            int curr = listq.get(i);
            if (curr == p) {
                return count;
            }
            if (setp.contains(curr)) {
                break;
            }
            count++;
        }
        // } else if (setp.contains(q)) {
        for (int i = listp.size() - 1; i >= 0; i--) {
            int curr = listp.get(i);
            if (curr == q) {
                return count;
            }
            if (setq.contains(curr)) {
                break;
            }
            count++;
        }
        // } else {
        // count = listp.size() + listq.size();
        // }
        return count;
    }

    private void findPath(TreeNode node, int t, Set<Integer> set) {
        if (node == null || set.contains(t)) return;

        set.add(node.val);
        if (node.val == t) {
            return;
        }
        findPath(node.left, t, set);
        findPath(node.right, t, set);
        if (!set.contains(t)) set.remove(node.val);
    }

    public int findDistance1(TreeNode root, int p, int q) {
        if (p == q) return 0;
        TreeNode[] arr1 = new TreeNode[1], arr2 = new TreeNode[1];
        find(root, p, arr1);
        find(root, q, arr2);
        TreeNode pNode = arr1[0], qNode = arr2[0];

        int[] res = new int[1];
        goDFS(pNode, qNode, 0, res);
        if (res[0] != 0) return res[0];

        goDFS(qNode, pNode, 0, res);
        if (res[0] != 0) return res[0];

        int[] dist1 = new int[1], dist2 = new int[1];
        //find distance from root for both and a + b - 1
        findDistance(root, p, 0, dist1);
        findDistance(root, q, 0, dist2);
        return dist1[0] + dist2[0];
    }

    private void findDistance(TreeNode node, int t, int lvl, int[] arr) {
        if (node == null) return;

        if (node.val == t) {
            arr[0] = lvl;
            return;
        }

        findDistance(node.left, t, lvl + 1, arr);
        findDistance(node.right, t, lvl + 1, arr);
    }

    private void goDFS(TreeNode a, TreeNode b, int lvl, int[] arr) {
        if (a == null) return;

        if (a.val == b.val) {
            arr[0] = lvl;
            return;
        }

        goDFS(a.left, b, lvl + 1, arr);
        goDFS(a.right, b, lvl + 1, arr);
    }

    private void find(TreeNode node, int n, TreeNode[] mem) {
        if (node == null) return;

        if (mem[0] != null) return;

        if (node.val == n) {
            mem[0] = node;
            return;
        }

        find(node.left, n, mem);
        find(node.right, n, mem);
    }
}
