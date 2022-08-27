package LeetCode;

public class Problem1588 {
    //https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
    public static void main(String[] args) {
        System.out.println(sumOddLengthSubarrays(new int[]{1,4,2,5,3}));
        System.out.println(sumOddLengthSubarrays(new int[]{1,2}));
        System.out.println(sumOddLengthSubarrays(new int[]{10,11,12}));
        System.out.println(sumOddLengthSubarrays(new int[]{1,4,2,5,3,2,6}));
    }

    //Runtime: 4 ms, faster than 35.07% of Java online submissions for Sum of All Odd Length Subarrays.
    //Memory Usage: 42.2 MB, less than 23.07% of Java online submissions for Sum of All Odd Length Subarrays.
    static int sumOddLengthSubarrays(int[] arr) {
        int times = 1, sum = 0;
        int index1 = 0, index2 = 0;
        for (int i = 1; i <= arr.length; i += 2) {
            int len = arr.length - index2;
            for (int j = 0; j < len; j++) {
                for (int k = index1; k <= index2; k++) {
                    sum += arr[k];
                }
                index1++;
                index2++;
            }
            index1 = 0;
            index2 = times * 2;
            times++;
        }
        return sum;
    }

    static int sumOddLengthSubarrays1(int[] arr) {
        int times = 0, sum = 0;
        if (arr.length < 3) {
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
            return sum;
        } else if (arr.length == 3) {
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
            return sum + sum;
        }
        for (int i = 1; i <= arr.length; i += 2) {
            times++;
        }
        for (int i = 0; i < arr.length / 2 + 1; i++) {
            for (int j = 0; j < times + i; j++) {
                sum += arr[i];
                int indexRight = arr.length - 1 - i;
                if (i != indexRight) {
                    sum += arr[indexRight];
                }
            }
        }
        return sum;
    }
}
