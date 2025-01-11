package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem1560 {
    //https://leetcode.com/problems/most-visited-sector-in-a-circular-track
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/most-visited-sector-in-a-circular-track/solutions/6265621/java-solution-by-tbekpro-ikz4/
    //20-25min
    //Runtime
    //2
    //ms
    //Beats
    //31.58%
    //Analyze Complexity
    //Memory
    //43.42
    //MB
    //Beats
    //12.87%
    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] arr = new int[n + 1];
        for (int i = 1; i < rounds.length; i++) {
            int start = i == 1 ? rounds[i - 1] : rounds[i - 1] + 1, end = rounds[i];
            end = end < start ? n + end : end;
            for (int j = start; j <= end; j++) {
                arr[j % n]++;
            }
        }

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == max) {
                list.add(i);
            }
        }
        if (arr[0] == max) list.add(n);
        return list;
    }
}
