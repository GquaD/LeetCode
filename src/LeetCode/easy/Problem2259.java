package LeetCode.easy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem2259 {
    //10min
    //Runtime
    //9
    //ms
    //Beats
    //4.84%
    //Memory
    //43.62
    //MB
    //Beats
    //29.22%
    //https://leetcode.com/problems/remove-digit-from-number-to-maximize-result/solutions/8097228/java-solution-by-tbekpro-xavh/
    public String removeDigit(String number, char digit) {
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) count++;
        }

        for (int i = 0; i < count; i++) {
            int c = 0;
            for (int j = 0; j < number.length(); j++) {
                char cur = number.charAt(j);
                if (cur == digit) {
                    if (c++ != i) {
                        sb.append(cur);
                    }
                } else {
                    sb.append(cur);
                }
            }

            pq.offer(sb.toString());
            sb.setLength(0);
        }

        return pq.poll();
    }

}
