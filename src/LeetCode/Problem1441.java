package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Problem1441 {
    //https://leetcode.com/problems/build-an-array-with-stack-operations/
    public static void main(String[] args) {
        LeetCodeUtils.printList(buildArray(new int[]{1, 3}, 3));
        LeetCodeUtils.printList(buildArray(new int[]{1, 2, 3}, 3));
        LeetCodeUtils.printList(buildArray(new int[]{1, 2}, 4));
        LeetCodeUtils.printList(buildArray(new int[]{2, 3, 4}, 4));
    }

    //Runtime: 1 ms, faster than 53.29% of Java online submissions for Build an Array With Stack Operations.
    //Memory Usage: 44 MB, less than 6.36% of Java online submissions for Build an Array With Stack Operations.
    static List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (count == target.length) {
                break;
            }
            list.add("Push");
            if (target[count++] != i) {
                list.add("Pop");
                count--;
            }
        }
        return list;
    }
}
