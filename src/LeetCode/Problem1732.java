package LeetCode;

public class Problem1732 {
    //https://leetcode.com/problems/find-the-highest-altitude/
    public static void main(String[] args) {
        System.out.println(largestAltitude(new int[]{-5,1,5,0,-7}));
        System.out.println(largestAltitude(new int[]{-4,-3,-2,-1,4,3,2}));
    }

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Find the Highest Altitude.
    //Memory Usage: 42.2 MB, less than 17.33% of Java online submissions for Find the Highest Altitude.
    static int largestAltitude(int[] gain) {
        int max = 0, sum = 0;
        for (int i = 0; i < gain.length; i++) {
            if (max < (sum += gain[i])) {
                max = sum;
            }
        }
        return max;
    }
}
