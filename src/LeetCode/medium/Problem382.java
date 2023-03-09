package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Problem382 {
    //https://leetcode.com/problems/linked-list-random-node/
    public static void main(String[] args) {

    }


}
//https://leetcode.com/problems/linked-list-random-node/solutions/3274634/java-getrandom-o-1-solution/
//5 min
//Runtime
//11 ms
//Beats
//65.24%
//Memory
//44.8 MB
//Beats
//17.97%

class Solution {
    List<Integer> list;
    static Random random = new Random();
    public Solution(ListNode head) {
        list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
