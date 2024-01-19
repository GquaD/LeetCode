package LeetCode.medium;

import java.util.Arrays;
import java.util.Random;

public class Problem528 {
    //https://leetcode.com/problems/random-pick-with-weight/
    public static void main(String[] args) {

    }


}

//https://leetcode.com/problems/random-pick-with-weight/solutions/4592748/java-prefix-sum-binary-search-o-nlogn/
//20 min
//Runtime
//23
//ms
//Beats
//91.37%
//of users with Java
//Memory
//49.97
//MB
//Beats
//21.74%
//of users with Java
class SolutionI1 {

    int[] arr;
    int sum;
    Random rand;

    public SolutionI1(int[] w) {
        rand = new Random();
        arr = w;
        sum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
            arr[i] += arr[i - 1];
        }
    }

    public int pickIndex() {
        int r = rand.nextInt(sum) + 1, i = Arrays.binarySearch(arr, r);
        if (i < 0) i = -i - 1;
        if (i >= arr.length) i--;
        return i;
    }
}
