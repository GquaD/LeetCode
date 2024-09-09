package LeetCode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Problem2904 {
    //https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string/
    public static void main(String[] args) {
        System.out.println(shortestBeautifulSubstring("100011001", 3));
        System.out.println(shortestBeautifulSubstring("1011", 2));
        System.out.println(shortestBeautifulSubstring("000", 1));
        System.out.println(shortestBeautifulSubstring("1011", 3));
    }

    //https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string/solutions/5760201/java-o-n-solution/
    //15min
    //Runtime
    //3
    //ms
    //Beats
    //46.94%
    //Analyze Complexity
    //Memory
    //42.51
    //MB
    //Beats
    //72.45%
    static String shortestBeautifulSubstring(String s, int k) {
        //queue for idx
        //substring and compare
        String res = "";
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                queue.add(i);
            }
            if (queue.size() > k) queue.poll();
            if (queue.size() == k) {
                String sub = s.substring(queue.peek(), i + 1);
                if (res.isEmpty()) {
                    res = sub;
                } else {
                    if (res.length() > sub.length()) {
                        res = sub;
                    } else if (res.length() == sub.length()){
                        res = res.compareTo(sub) > 0 ? sub : res;
                    }
                }
            }
        }
        return res;
    }
}
