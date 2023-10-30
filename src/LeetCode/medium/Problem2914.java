package LeetCode.medium;

public class Problem2914 {
    //https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful/
    public static void main(String[] args) {
        System.out.println(minChanges("1001"));
        System.out.println(minChanges("10"));
        System.out.println(minChanges("0000"));
    }

    //https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful/solutions/4226303/java-100-faster-3-lines/
    //5min
    //Runtime
    //3 ms
    //Beats
    //100%
    //Memory
    //43.5 MB
    //Beats
    //50%
    static int minChanges(String s) {
        int count = 0;
        for (int i = 1; i < s.length(); i += 2) if (s.charAt(i - 1) != s.charAt(i)) count++;
        return count;
    }
}
