package LeetCode.easy;

import java.util.HashSet;
import java.util.Set;

public class Problem575 {
    //https://leetcode.com/problems/distribute-candies/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/distribute-candies/solutions/2784059/java-3-lines-solution/
    //10 mins
    //Runtime
    //73 ms
    //Beats
    //41.18%
    //Memory
    //106.7 MB
    //Beats
    //45.54%
    static int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int type : candyType) set.add(type);
        return Math.min(candyType.length / 2, set.size());
    }
}
