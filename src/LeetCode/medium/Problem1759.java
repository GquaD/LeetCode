package LeetCode.medium;

public class Problem1759 {
    //https://leetcode.com/problems/count-number-of-homogenous-substrings
    public static void main(String[] args) {
        System.out.println(countHomogenous("abbcccaa"));
        System.out.println(countHomogenous("xy"));
        System.out.println(countHomogenous("zzzzz"));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10_000; i++) {
            sb.append("aaaaaaaaaa");
        }
        System.out.println(countHomogenous(sb.toString()));
    }

    //https://leetcode.com/problems/count-number-of-homogenous-substrings/solutions/4268865/java-arithmetic-sum-o-n-solution/
    //10min
    //Runtime
    //9 ms
    //Beats
    //80%
    //Memory
    //44.2 MB
    //Beats
    //57.20%
    static int countHomogenous(String s) {
        long sum = 0;
        int count = 1;
        char prev = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (prev == s.charAt(i)) {
                count++;
            } else {
                sum += ((1L + count) * count) / 2;
                sum %= 1_000_000_007;
                count = 1;
                prev = s.charAt(i);
            }
        }
        sum += ((1L + count) * count) / 2;
        sum %= 1_000_000_007;
        return (int) sum;
    }
}
