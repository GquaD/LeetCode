package LeetCode.medium;

import java.util.Arrays;

public class Problem1980 {
    //https://leetcode.com/problems/find-unique-binary-string/
    public static void main(String[] args) {
        System.out.println(findDifferentBinaryString(new String[]{"10","11"}));
        System.out.println(findDifferentBinaryString(new String[]{"111", "011", "001", "010"}));
        System.out.println(findDifferentBinaryString(new String[]{"01", "10"}));
        System.out.println(findDifferentBinaryString(new String[]{"00", "01"}));
    }

    //https://leetcode.com/problems/find-unique-binary-string/solutions/3145461/java-converting-to-integer-solution/
    //20 min
    //Runtime
    //2 ms
    //Beats
    //62.94%
    //Memory
    //40.3 MB
    //Beats
    //78.32%
    static String findDifferentBinaryString(String[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) arr[i] = Integer.parseInt(nums[i], 2);
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] > 1) {
                String res = Integer.toBinaryString(arr[i] - 1);
                StringBuilder sb = new StringBuilder();
                while(sb.length() + res.length() < nums[0].length()) sb.append("0");
                sb.append(res);
                return sb.toString();
            }
        }
        if (arr[0] != 0) {
            StringBuilder sb = new StringBuilder();
            while(sb.length() < nums[0].length()) sb.append("0");
            return sb.toString();
        }
        String res = Integer.toBinaryString(arr[arr.length - 1] + 1);
        StringBuilder sb = new StringBuilder();
        while(sb.length() + res.length() < nums[0].length()) sb.append("0");
        sb.append(res);
        return sb.toString();
    }
}
