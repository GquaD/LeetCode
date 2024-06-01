package LeetCode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem3160 {
    //https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls/solutions/5240474/java-using-2-maps/
    //20min
    //Runtime
    //56
    //ms
    //Beats
    //21.49%
    //of users with Java
    //Memory
    //109.06
    //MB
    //Beats
    //5.42%
    //of users with Java
    public int[] queryResults(int limit, int[][] q) {
        //color -> ball
        Map<Integer, Set<Integer>> map = new HashMap<>();
        //ball -> color
        Map<Integer, Integer> mapa = new HashMap<>();
        int[] res = new int[q.length];

        for (int i = 0; i < res.length; i++) {
            int ball = q[i][0], color = q[i][1];

            if (mapa.containsKey(ball)) {
                int prevColor = mapa.get(ball);
                mapa.remove(ball);

                map.get(prevColor).remove(ball);
                if (map.get(prevColor).size() == 0) {
                    map.remove(prevColor);
                }

            }

            Set<Integer> balls = map.get(color);
            if (balls == null) {
                balls = new HashSet<>();
                map.put(color, balls);
            }

            mapa.put(ball, color);
            balls.add(ball);
            res[i] = map.size();
        }
        return res;
    }
}
