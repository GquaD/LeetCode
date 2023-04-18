package LeetCode.medium;

import java.util.Arrays;

public class Problem1663 {
    //https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/
    public static void main(String[] args) {
        System.out.println(getSmallestString(3, 27));
        System.out.println(getSmallestString(5, 73));
        System.out.println(getSmallestString(16, 410));
    }

    //https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/solutions/3429111/java-o-n-solution/
    //10 min
    //Runtime
    //40 ms
    //Beats
    //22.90%
    //Memory
    //44.5 MB
    //Beats
    //5.14%
    static String getSmallestString(int n, int k) {
        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        k -= n;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (k == 0) break;
            if (k < 26) {
                arr[i] += k;
                k = 0;
            } else {
                arr[i] += 25;
                k -= 25;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : arr) sb.append((char) (i + 'a' - 1));
        return sb.toString();
        /*int max = n * 26;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (max > k) {
                sb.append('a');
                k--;
            } else if (max == k) {
                sb.append('z');
                k -= 26;
            } else {

            }
            max -= 26;
        }*/
    }
}
