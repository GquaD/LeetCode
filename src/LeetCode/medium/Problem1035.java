package LeetCode.medium;


import java.util.LinkedList;
import java.util.Queue;

public class Problem1035 {
    //https://leetcode.com/problems/uncrossed-lines/
    public static void main(String[] args) {
        System.out.println(maxUncrossedLines(new int[]{2,1,3}, new int[]{3,1}));
        System.out.println(maxUncrossedLines(new int[]{2,1,2,3,1}, new int[]{1,3,3,3,1,1}));
        System.out.println(maxUncrossedLines(new int[]{1,4,2}, new int[]{1,2,4}));
        System.out.println(maxUncrossedLines(new int[]{2,5,1,2,5}, new int[]{10,5,2,1,5,2}));
        System.out.println(maxUncrossedLines(new int[]{1,3,7,1,7,5}, new int[]{1,9,2,5,1}));
    }

    //nnnn
    //Runtime
    //5 ms
    //Beats
    //72.30%
    //Memory
    //42 MB
    //Beats
    //73.13%
    static int maxUncrossedLines2(int[] nums1, int[] nums2) {
        int a = nums1.length, b = nums2.length, dp[][] = new int[a + 1][b + 1];
        for (int i = 1; i <= a; i++) for (int j = 1; j <= b; j++) dp[i][j] = nums1[i - 1] == nums2[j - 1] ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
        return dp[a][b];
    }

    static int maxUncrossedLines(int[] nums1, int[] nums2) {
        int a = nums1.length, b = nums2.length, dp[][] = new int[a + 1][b + 1];
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                if (nums1[i - 1] == nums2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[a][b];
    }

    static int maxUncrossedLines1(int[] nums1, int[] nums2) {
        Queue<Integer> queue1 = new LinkedList<>(), queue2 = new LinkedList<>();
        for (int n : nums1) queue1.offer(n);
        for (int n : nums2) queue2.offer(n);
        int count = 0;
        while (!(queue1.isEmpty() || queue2.isEmpty())) {
            int one = queue1.poll(), two = queue2.poll();
            if (one == two) {
                count++;
            } else if (!queue2.isEmpty() && one == queue2.peek()) {
                count++;
                queue2.poll();
            } else if (!queue1.isEmpty() && two == queue1.peek()) {
                count++;
                queue1.poll();
            } else if (count > 0){
                if (queue1.size() > queue2.size()) {
                    queue2.offer(two);
                } else {
                    queue1.offer(one);
                }
            }
        }
        return count;
    }
}
