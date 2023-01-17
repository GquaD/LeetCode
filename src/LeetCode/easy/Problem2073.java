package LeetCode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class Problem2073 {
    //https://leetcode.com/problems/time-needed-to-buy-tickets/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/time-needed-to-buy-tickets/solutions/3061869/java-1ms-solution/
    //Runtime
    //1 ms
    //Beats
    //72.17%
    //Memory
    //40.3 MB
    //Beats
    //62.18%
    static int timeRequiredToBuy(int[] tickets, int k) {
        int count = 0;
        while (tickets[k] != 0) {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] > 0) {
                    count++;
                    tickets[i]--;
                }
                if (i == k && tickets[k] == 0) break;
            }
        }
        return count;
    }
}
