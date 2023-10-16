package LeetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem539 {
    //https://leetcode.com/problems/minimum-time-difference/description/
    public static void main(String[] args) {
        System.out.println(findMinDifference(Arrays.asList("23:59","00:00")));
        System.out.println(findMinDifference(Arrays.asList("00:00","23:59","00:00")));
    }

    //https://leetcode.com/problems/minimum-time-difference/solutions/4176757/java-o-nlogn-solution/
    //10min
    //Runtime
    //17 ms
    //Beats
    //25.34%
    //Memory
    //44.2 MB
    //Beats
    //50.17%
    static int findMinDifference(List<String> timePoints) {
        List<Integer> list = new ArrayList<>();
        for (String s : timePoints) {
            list.add(Integer.parseInt(s.charAt(0) + "" + s.charAt(1))
                    * 60 + Integer.parseInt(s.charAt(3) + "" + s.charAt(4)));
        }
        Collections.sort(list);
        int min = 24 * 60;
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, list.get(i) - list.get(i - 1));
        }
        min = Math.min(min, (24 * 60 - list.get(list.size() - 1)) + list.get(0));
        return min;
    }
}
