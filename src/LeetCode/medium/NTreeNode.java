package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class NTreeNode {
    public int val;
    public List<NTreeNode> children;

    public NTreeNode() {}

    public NTreeNode(int _val) {
        val = _val;
        children = new ArrayList<>();
    }

    public NTreeNode(int _val, List<NTreeNode> _children) {
        val = _val;
        children = _children;
    }
}
