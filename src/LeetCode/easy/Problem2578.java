package LeetCode.easy;

import java.util.PriorityQueue;

public class Problem2578 {
    //https://leetcode.com/problems/split-with-minimum-sum/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/split-with-minimum-sum/solutions/3418189/java-using-priorityqueue/
    //5 min
    //Runtime
    //1 ms
    //Beats
    //92.23%
    //Memory
    //40 MB
    //Beats
    //24.78%
    static int splitNum(int num) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (num > 0) {
            pq.offer(num % 10);
            num /= 10;
        }
        StringBuilder sb = new StringBuilder(), sb2 = new StringBuilder();
        boolean switching = false;
        while (!pq.isEmpty()) {
            if (switching) sb.append(pq.poll());
            else sb2.append(pq.poll());
            switching = !switching;
        }
        return Integer.parseInt(sb.toString()) + Integer.parseInt(sb2.toString());
    }
}
