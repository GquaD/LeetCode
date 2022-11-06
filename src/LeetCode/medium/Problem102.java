package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem102 {
    //https://leetcode.com/problems/binary-tree-level-order-traversal/description/


    //https://leetcode.com/problems/binary-tree-level-order-traversal/solutions/2784197/java-in-just-1-ms/
    //old solution not added to this repo
    //Runtime
    //1 ms
    //Beats
    //94.10%
    //Memory
    //43.3 MB
    //Beats
    //71.46%
    static List<List<Integer>> resultList;
    public List<List<Integer>> levelOrder(TreeNode root) {
        resultList = new ArrayList<>();
        searchBST(root,0);
        return resultList;
    }

    void searchBST(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (level > resultList.size() - 1){
            List<Integer> levelList = new ArrayList<>();
            levelList.add(root.val);
            resultList.add(levelList);
        } else {
            resultList.get(level).add(root.val);
        }

        searchBST(root.left, ++level);
        searchBST(root.right, level);
    }
}
