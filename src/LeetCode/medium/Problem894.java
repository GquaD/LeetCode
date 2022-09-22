package LeetCode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Problem894 {
    //https://leetcode.com/problems/all-possible-full-binary-trees/submissions/
    //with arraylist
    //Runtime: 1 ms, faster than 100.00% of Java online submissions for All Possible Full Binary Trees.
    //Memory Usage: 43.2 MB, less than 99.12% of Java online submissions for All Possible Full Binary Trees.
    //with LinkedList
    //Runtime: 3 ms, faster than 75.62% of Java online submissions for All Possible Full Binary Trees.
    //Memory Usage: 55.5 MB, less than 73.30% of Java online submissions for All Possible Full Binary Trees.
    Map<Integer, List<TreeNode>> memo = new HashMap();
    public List<TreeNode> allPossibleFBT(int N) {
        if (!memo.containsKey(N)) {
            List<TreeNode> ans = new LinkedList();
            if  (N == 1) {
                ans.add(new TreeNode(0));
            } else if (N % 2 == 1) {
                for (int x = 0; x < N; ++x) {
                    int y = N - 1 - x;
                    for (TreeNode left: allPossibleFBT(x)) {
                        for (TreeNode right: allPossibleFBT(y)) {
                            TreeNode bns = new TreeNode(0);
                            bns.left = left;
                            bns.right = right;
                            ans.add(bns);
                        }
                    }
                }
            }
            memo.put(N, ans);
        }
        return memo.get(N);
    }
}
