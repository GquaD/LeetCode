package LeetCode.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Problem341 {
    //https://leetcode.com/problems/flatten-nested-list-iterator/description/
    public static void main(String[] args) {

    }


}

//https://leetcode.com/problems/flatten-nested-list-iterator/solutions/3766158/java-dfs-100-faster-solution/
//15 min
//Runtime
//Details
//2ms
//Beats 100.00%of users with Java
//Memory
//Details
//44.37mb
//Beats 92.13%of users with Java
class NestedIterator implements Iterator<Integer> {

    int idx;
    List<Integer> list;
    public NestedIterator(List<NestedInteger> nestedList) {
        idx = 0;
        list = new ArrayList<>();
        readNestedList(nestedList);
    }

    private void readNestedList(List<NestedInteger> nestedList) {
        if (nestedList.isEmpty()) return;

        for (NestedInteger n : nestedList) {
            if (n.isInteger()) list.add(n.getInteger());
            else readNestedList(n.getList());
        }
    }

    @Override
    public Integer next() {
        return list.get(idx++);
    }

    @Override
    public boolean hasNext() {
        return idx < list.size();
    }
}


// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
