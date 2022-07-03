package LeetCode;

import java.util.Arrays;

public class Problem1720 {
    //https://leetcode.com/problems/decode-xored-array/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(decode(new int[] {1,2,3}, 1)));
        System.out.println(Arrays.toString(decode(new int[] {6, 2, 7 ,3}, 4)));
    }

    //Runtime: 2 ms, faster than 79.54% of Java online submissions for Decode XORed Array.
    //Memory Usage: 56.8 MB, less than 11.11% of Java online submissions for Decode XORed Array.
    public static int[] decode(int[] encoded, int first) {
        int[] result = new int[encoded.length + 1];
        result[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            result[i + 1] = encoded[i] ^ result[i];
        }
        return result;
    }
}
