package LeetCode.medium;

public class Problem2829 {
    //https://leetcode.com/problems/determine-the-minimum-sum-of-a-k-avoiding-array/
    public static void main(String[] args) {

    }

    //nn
    //depending on n < mid(k), mid(k) < n < k, k < n
    //why mid?
    //cuz pattern when sum of 2 numbers is equal to k is: (k - 1, 1), (k-2,2), (k/2 - 1, k/2 + 1)
    //so we take part of numbers less than half and >= k depending on n
    //Runtime
    //1 ms
    //Beats
    //100%
    //Memory
    //40 MB
    //Beats
    //100%
    static int minimumSum(int n, int k) {
        int mid = k / 2;
        if (n <= mid) return n * (n + 1) / 2;
        int leftSum = mid * (mid + 1) / 2, remain = n - mid;
        int sum = (remain * (2 * k + (remain - 1))) / 2;
        return leftSum + sum;
    }
}
