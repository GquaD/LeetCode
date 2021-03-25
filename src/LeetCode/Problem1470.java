package LeetCode;

import java.util.Arrays;

/**
 * Created by Behzod on 25, March, 2021
 */
public class Problem1470 {
    public static void main(String[] args) {
        int[] one = {2,5,1,3,4,7};
        int[] two = {1,2,3,4,4,3,2,1};
        //          { , , , , , , , }
        int[] three = {1,1,2,2};
        int[] four = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(shuffle(one,3)));
        System.out.println(Arrays.toString(shuffle(two,4)));
        System.out.println(Arrays.toString(shuffle(three,2)));
        System.out.println(Arrays.toString(shuffle(four,3)));
    }

    public static int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        for (int i = 0, j = 0; i < nums.length; i++, j++) {
            result[i] = nums[j];
            result[i+1] = nums[j+n];
            i++;
        }
        return result;
    }
  //O(n)
}
