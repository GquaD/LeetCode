package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem3285 {
    //https://leetcode.com/problems/find-indices-of-stable-mountains
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-indices-of-stable-mountains/solutions/5798910/java-100-faster-solution/
    //2min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //44.63
    //MB
    //Beats
    //61.99%
    static List<Integer> stableMountains(int[] h, int t) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < h.length; i++) {
            if (h[i - 1] > t) list.add(i);
        }
        return list;
    }
}
