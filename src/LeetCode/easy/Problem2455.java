package LeetCode.easy;

public class Problem2455 {
    //https://leetcode.com/problems/average-value-of-even-numbers-that-are-divisible-by-three/
    public static void main(String[] args) {

    }

    //2 min
    //Runtime
    //1 ms
    //Beats
    //76.98%
    //Memory
    //42.6 MB
    //Beats
    //60.15%
    static int averageValue(int[] nums) {
        int sum = 0, count = 0;
        for (int n : nums) {
            if (n % 6 == 0) {
                sum += n;
                count++;
            }
        }
        return count == 0 ? 0 : sum / count;
    }
}
