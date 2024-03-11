package LeetCode.medium;

public class Problem1522 {
    //https://leetcode.com/problems/diameter-of-n-ary-tree/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/diameter-of-n-ary-tree/solutions/4859398/java-dfs-100-faster/
    //20-25min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //43.62
    //MB
    //Beats
    //94.16%
    //of users with Java
    static int diameter(Node root) {
        int[] res = new int[1];
        goDFS(root, res);
        return res[0];
    }

    private static int goDFS(Node node, int[] res) {
        if (node == null) return 0;

        int max = 0, maxn = 0;
        for (int i = 0; i < node.children.size(); i++) {
            int d = goDFS(node.children.get(i), res) + 1;
            if (max < d) {
                maxn = max;
                max = d;
            } else if (maxn < d) {
                maxn = d;
            }
        }
        res[0] = Math.max(max + maxn, res[0]);
        return max;
    }
}
