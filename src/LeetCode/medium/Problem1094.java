package LeetCode.medium;


import java.util.Arrays;
import java.util.TreeMap;

public class Problem1094 {
    //https://leetcode.com/problems/car-pooling/
    public static void main(String[] args) {
        System.out.println(carPooling(new int[][]{{8, 16, 20}, {9, 18, 19}, {7, 13, 16}, {7, 13, 16}, {8, 15, 18}, {3, 17, 18}, {6, 6, 18}, {1, 2, 6}, {5, 3, 7}, {1, 16, 20}, {3, 12, 20}, {8, 18, 20}, {5, 7, 17}, {9, 14, 15}, {7, 9, 17}, {7, 12, 18}, {6, 15, 19}, {6, 18, 19}, {8, 18, 20}, {2, 12, 16}}, 58));
        System.out.println(carPooling(new int[][]{{9, 0, 1}, {3, 3, 7}}, 4));
        System.out.println(carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4));
        System.out.println(carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 5));
    }

    //https://leetcode.com/problems/car-pooling/solutions/3815554/java-treemap-8ms-solution/
    //30 min
    //Runtime
    //8 ms
    //Beats
    //14.41%
    //Memory
    //43.1 MB
    //Beats
    //90.2%
    static boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] arr : trips) {
            map.put(arr[1], map.getOrDefault(arr[1], 0) + arr[0]);
            map.put(arr[2], map.getOrDefault(arr[2], 0) - arr[0]);
        }
        int sum = 0;
        for (int key : map.keySet()) {
            sum += map.get(key);
            map.put(key, sum);
            if (sum > capacity) return false;
        }
        return true;
    }

    static boolean carPooling1(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);
        int sum = trips[0][0];
        if (sum > capacity) return false;
        for (int i = 1; i < trips.length; i++) {
            int[] arr1 = trips[i - 1], arr2 = trips[i];
            /*if (arr2[1] < arr1[2]) {
                if (sum + arr2[0] > capacity) return false;
                else sum += arr2[0];
            } else {
                sum -= arr1[0];
                sum += arr2[0];
            }*/

            if (arr2[1] > arr1[2]) sum -= arr1[0];
            sum += arr2[0];
            if (sum > capacity) return false;
        }
        return true;
    }
}
