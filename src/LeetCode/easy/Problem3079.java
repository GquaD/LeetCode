package LeetCode.easy;

public class Problem3079 {
    //https://leetcode.com/problems/find-the-sum-of-encrypted-integers/description/
    public static void main(String[] args) {

    }

    //5min
    //Runtime
    //4
    //ms
    //Beats
    //24.28%
    //Analyze Complexity
    //Memory
    //44.37
    //MB
    //Beats
    //15.59%
    private int sumOfEncryptedInt(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += encrypt(n);
        }
        return sum;
    }

    private int encrypt(int n) {
        String s = n + "";
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            max = Math.max(max, s.charAt(i) - '0');
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(max);
        }

        return Integer.parseInt(sb.toString());
    }
}
