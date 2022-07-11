package LeetCode;

public class Problem1534 {
    //https://leetcode.com/problems/count-good-triplets/
    public static void main(String[] args) {
        System.out.println(countGoodTriplets(new int[]{3,0,1,1,9,7}, 7, 2, 3));
        System.out.println(countGoodTriplets(new int[]{1,1,2,2,3}, 0, 0, 1));
    }
    //Runtime: 100 ms, faster than 5.14% of Java online submissions for Count Good Triplets.
    //Memory Usage: 42.4 MB, less than 12.20% of Java online submissions for Count Good Triplets.
    static int countGoodTriplets(int[] arr, int a, int b, int c) {
        if (arr.length < 3) return 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                for (int k = 2; k < arr.length; k++) {
                    if (Math.abs(arr[i] - arr[j])  <= a
                    && Math.abs(arr[j] - arr[k]) <= b
                    && Math.abs(arr[i] - arr[k]) <= c
                    && i < j
                    && j < k) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
