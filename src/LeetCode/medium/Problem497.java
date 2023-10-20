package LeetCode.medium;

import java.util.*;

public class Problem497 {
    //https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/
    public static void main(String[] args) {
        Solution7 s = new Solution7(new int[][]{{-2,-2,1,1}, {2,2,4,6}});
        for (int i = 0; i < 5; i++) {
            System.out.println(Arrays.toString(s.pick()));
        }
    }


}

//https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/solutions/4189461/java-using-random-hashmap-binary-search/
//needed to find accumulated sum of space (weight) of each rect
//and then based on that weight (sum) pick a rect
//45-50 min
//Runtime
//56 ms
//Beats
//42.31%
//Memory
//50.4 MB
//Beats
//14.42%

class Solution7 {

    private Random random;
    int[][] arr;
    Map<Integer, Integer> map;
    int[] weights;
    int sum;
    public Solution7(int[][] rects) {
        random = new Random();
        map = new HashMap<>();
        arr = rects;
        sum = 0;
        weights = new int[rects.length];
        for (int i = 0; i < arr.length; i++) {
            int[] a = arr[i];
            int space = (a[2] + 1 - a[0]) * (a[3] + 1 - a[1]);
            sum += space;
            weights[i] = sum;
            map.put(sum, i);
        }
        Arrays.sort(weights);
    }

    public int[] pick() {
        int weight = random.nextInt(sum);
        int idx = Arrays.binarySearch(weights, weight);
        if (idx < 0) idx = -idx - 1;
        while (idx >= weights.length) {
            weight = random.nextInt(sum);
            idx = Arrays.binarySearch(weights, weight);
            if (idx < 0) idx = -idx - 1;
        }
        idx = map.get(weights[idx]);
        int u = random.nextInt(arr[idx][2] + 1 - arr[idx][0]) + arr[idx][0];
        int v = random.nextInt(arr[idx][3] + 1 - arr[idx][1]) + arr[idx][1];
        return new int[]{u, v};
    }
}
