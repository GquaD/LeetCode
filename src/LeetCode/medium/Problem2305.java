package LeetCode.medium;

import java.util.Arrays;

public class Problem2305 {
    //https://leetcode.com/problems/fair-distribution-of-cookies/description/
    public static void main(String[] args) {
        System.out.println(distributeCookies(new int[]{8, 15, 10, 20, 8}, 2));
        System.out.println(distributeCookies(new int[]{6, 1, 3, 2, 2, 4, 1, 2}, 3));
        System.out.println(distributeCookies(new int[]{8, 15, 10, 20, 8}, 3));
    }

    //nnn
    //Runtime
    //409 ms
    //Beats
    //38.2%
    //Memory
    //40.1 MB
    //Beats
    //30.73%
    static int res;

    static int distributeCookies(int[] cookies, int k) {
        res = Integer.MAX_VALUE;
        goDFS(cookies, k, 0, new int[k]);
        return res;
    }

    private static void goDFS(int[] cookies, int k, int idx, int[] arr) {
        if (idx >= cookies.length) {
            int maxCurr = 0;
            for (int n : arr) maxCurr = Math.max(maxCurr, n);
            res = Math.min(res, maxCurr);
            return;
        }

        for (int i = 0; i < k; i++) {
            arr[i] += cookies[idx];
            goDFS(cookies, k, idx + 1, arr);
            arr[i] -= cookies[idx];
        }
    }

    //Wrong Answer
    //
    //33 / 38
    static int distributeCookies1(int[] cookies, int k) {
        Arrays.sort(cookies);
        int[] arr = new int[k];
        int sum = 0, max = 0;
        for (int n : cookies) sum += n;
        int avg = sum % k == 0 ? sum / k : (sum / k) + (sum % k);
        for (int i = cookies.length - 1; i >= 0; i--) {
            int curr = cookies[i];
            boolean added = false;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] + curr <= avg) {
                    arr[j] += curr;
                    max = Math.max(max, arr[j]);
                    added = true;
                    break;
                }
            }
            if (!added) {
                int idxMin = 0, min = Integer.MAX_VALUE;
                for (int j = 0; j < arr.length; j++) {
                    if (min > arr[j]) {
                        min = arr[j];
                        idxMin = j;
                    }
                }
                arr[idxMin] += curr;
                max = Math.max(max, arr[idxMin]);
            }
        }
        return max;
    }
}
