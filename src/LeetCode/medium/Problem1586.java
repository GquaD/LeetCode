package LeetCode.medium;

public class Problem1586 {
    //https://leetcode.com/problems/binary-search-tree-iterator-ii
    public static void main(String[] args) {

    }
    //https://leetcode.com/problems/binary-search-tree-iterator-ii/solutions/6019053/java-dfs-100-faster-solution/
    //5min
    //Runtime
    //71
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //68.32
    //MB
    //Beats
    //84.72%
    //class BSTIterator {
    //    List<Integer> list;
    //    int idx;
    //    public BSTIterator(TreeNode root) {
    //        list = new ArrayList<>();
    //        idx = -1;
    //        dfs(root, list);
    //    }
    //
    //    public boolean hasNext() {
    //        return idx + 1 < list.size();
    //    }
    //
    //    public int next() {
    //        return list.get(++idx);
    //    }
    //
    //    public boolean hasPrev() {
    //        return idx > 0;
    //    }
    //
    //    public int prev() {
    //        return list.get(--idx);
    //    }
    //
    //    private void dfs(TreeNode node, List<Integer> list) {
    //        if (node == null) return;
    //
    //        dfs(node.left, list);
    //        list.add(node.val);
    //        dfs(node.right, list);
    //    }
    //}

}
