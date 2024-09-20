package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem3294 {
    //https://leetcode.com/problems/convert-doubly-linked-list-to-array-ii
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/convert-doubly-linked-list-to-array-ii/solutions/5811706/java-solution/
    //10min
    //Runtime
    //3
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //45.52
    //MB
    //Beats
    //100.00%
    static int[] toArray(Node node) {
        List<Integer> list = new ArrayList<>();
        Node t = node;
        while (t != null) {
            list.add(t.val);
            t = t.next;
        }
        t = node.prev;
        while (t != null) {
            list.add(0, t.val);
            t = t.prev;
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
