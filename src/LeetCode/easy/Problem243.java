package LeetCode.easy;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem243 {
    //https://leetcode.com/problems/shortest-word-distance
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/shortest-word-distance/solutions/4883703/java-2ms-solution/
    //2min
    //used 244's logic
    //Runtime
    //2
    //ms
    //Beats
    //92.97%
    //of users with Java
    //Memory
    //45.90
    //MB
    //Beats
    //41.05%
    //of users with Java
    static int shortestDistance(String[] arr, String word1, String word2) {
        List<Integer> la = new ArrayList<>(), lb = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(word1)) la.add(i);
            if (arr[i].equals(word2)) lb.add(i);
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
