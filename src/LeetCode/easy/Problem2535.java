package LeetCode.easy;

public class Problem2535 {
    //https://leetcode.com/problems/difference-between-element-sum-and-digit-sum-of-an-array/
    public static void main(String[] args) {
        System.out.println(differenceOfSum(new int[]{1,15,6,3}));
        System.out.println(differenceOfSum(new int[]{1,2,3,4}));
    }

    //https://leetcode.com/problems/difference-between-element-sum-and-digit-sum-of-an-array/solutions/3121756/java-99-87-faster-solution/
    //2 min
    //Runtime
    //2 ms
    //Beats
    //99.87%
    //Memory
    //42.1 MB
    //Beats
    //91.74%
    static int differenceOfSum(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
            while (n > 0) {
                sum -= n % 10;
                n /= 10;
            }
        }
        return Math.abs(sum);
    }

    public int differenceOfSum2(int[] nums) {
        int lSum = 0, dSum = 0;
        for (int n : nums) {
            lSum += n;
            while (n > 0) {
                dSum += n % 10;
                n /= 10;
            }
        }
        return Math.abs(lSum - dSum);
    }
}
