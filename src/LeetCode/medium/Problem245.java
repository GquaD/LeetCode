package LeetCode.medium;
import java.util.*;

public class Problem245 {
    //https://leetcode.com/problems/shortest-word-distance-iii
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/shortest-word-distance-iii/solutions/4910124/java-straightforward-solution/
    //5min
    //used code from my other solution
    //Runtime
    //18
    //ms
    //Beats
    //20.34%
    //of users with Java
    //Memory
    //62.02
    //MB
    //Beats
    //93.22%
    //of users with Java
    static int shortestWordDistance(String[] arr, String word1, String word2) {
        List<Integer> la = new ArrayList<>(), lb = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(word1)) la.add(i);
            if (arr[i].equals(word2)) lb.add(i);
        }
        if (word1.equals(word2)) {
            int min = 100_001;
            for (int i = 1; i < la.size(); i++) {
                min = Math.min(min, la.get(i) - la.get(i - 1));
            }
            return min;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < la.size(); i++) {
            int x = la.get(i), y = Collections.binarySearch(lb, x);
            if (y < 0) y = -y - 1;
            if (y == lb.size()) y--;
            if (y - 1 < 0) {
                res = Math.min(res, Math.abs(lb.get(y) - x));
            } else {
                res = Math.min(res, Math.min(Math.abs(lb.get(y) - x), Math.abs(lb.get(y - 1) - x)));
            }
        }

        return res = res == 0 ? 1 : res;
    }
}
