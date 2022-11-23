package LeetCode.easy;

public class Problem1385 {
    //https://leetcode.com/problems/find-the-distance-value-between-two-arrays/
    public static void main(String[] args) {

    }

    //
    //Runtime
    //6 ms
    //Beats
    //71.20%
    //Memory
    //44.8 MB
    //Beats
    //32.72%
    static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        for (int a : arr1) {
            boolean countIncrease = true;
            for (int b : arr2) {
                int dist = Math.abs(a - b);
                if (dist <= d) {
                    countIncrease = false;
                    break;
                }
            }
            if (countIncrease) count++;
        }
        return count;
    }
}
