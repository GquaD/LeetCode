package LeetCode.medium;

public class Problem1529 {
    //https://leetcode.com/problems/minimum-suffix-flips/
    public static void main(String[] args) {
        System.out.println(minFlips("10111"));
        System.out.println(minFlips("101"));
        System.out.println(minFlips("10101"));
    }

    //https://leetcode.com/problems/minimum-suffix-flips/solutions/2952370/java-o-n-brief-solution-explained/
    //10 min
    //Runtime
    //6 ms
    //Beats
    //93.42%
    //Memory
    //42.3 MB
    //Beats
    //96.93%
    static int minFlips(String target) {
        int flips = 0;
        char prev = target.charAt(0);
        if (prev == '1') flips++;

        for (int i = 1; i < target.length(); i++) {
            char c = target.charAt(i);
            if (c != prev) {
                flips++;
                prev = c;
            }
        }
        return flips;
    }
}
