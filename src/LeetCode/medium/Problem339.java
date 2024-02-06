package LeetCode.medium;

public class Problem339 {
    //https://leetcode.com/problems/nested-list-weight-sum
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/nested-list-weight-sum/solutions/4686487/java-100-faster-dfs-solution/
    //5-10min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //40.31
    //MB
    //Beats
    //88.51%
    //of users with Java
/*    static int depthSum(List<NestedInteger> list) {
        int[] res = new int[1];
        goDFS(list, 1, res);
        return res[0];
    }

    private static void goDFS(List<NestedInteger> list, int lvl, int[] res) {
        if (list == null) return;

        for (int i = 0; i < list.size(); i++) {
            NestedInteger n = list.get(i);
            if (n.isInteger()) {
                res[0] += lvl * n.getInteger();
            } else {
                goDFS(n.getList(), lvl + 1, res);
            }
        }
    }*/
}
