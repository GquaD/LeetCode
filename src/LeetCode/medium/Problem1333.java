package LeetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem1333 {
    //https://leetcode.com/problems/filter-restaurants-by-vegan-friendly-price-and-distance/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/filter-restaurants-by-vegan-friendly-price-and-distance/solutions/4272850/java-optimized-from-12ms-to-6ms/
    //5-10min
    //Runtime
    //6 ms
    //Beats
    //77.67%
    //Memory
    //50.8 MB
    //Beats
    //14.56%
    static List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        //Arrays.sort(restaurants, (a, b) -> b[1] == a[1] ? b[0] - a[0] : b[1] - a[1]);
        List<int[]> list = new ArrayList<>();
        for (int[] arr : restaurants) {
            int vegan = arr[2], price = arr[3], dist = arr[4];
            if ((veganFriendly == 0 || vegan == veganFriendly) && price <= maxPrice && dist <= maxDistance) list.add(arr);
        }
        Collections.sort(list, (a, b) -> b[1] == a[1] ? b[0] - a[0] : b[1] - a[1]);
        List<Integer> res = new ArrayList<>();
        for (int[] arr : list) res.add(arr[0]);
        return res;
    }

    //5-10min
    //Runtime
    //12 ms
    //Beats
    //7.77%
    //Memory
    //50.6 MB
    //Beats
    //22.33%
    static List<Integer> filterRestaurants1(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        Arrays.sort(restaurants, (a, b) -> b[1] == a[1] ? b[0] - a[0] : b[1] - a[1]);
        List<Integer> list = new ArrayList<>();
        for (int[] arr : restaurants) {
            int vegan = arr[2], price = arr[3], dist = arr[4];
            if ((veganFriendly == 0 || vegan == veganFriendly) && price <= maxPrice && dist <= maxDistance) list.add(arr[0]);
        }
        return list;
    }
}
