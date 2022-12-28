package LeetCode.medium;

import java.util.Arrays;

public class Problem1433 {
    //https://leetcode.com/problems/check-if-a-string-can-break-another-string/description/
    public static void main(String[] args) {
        System.out.println(checkIfCanBreak("abc", "xya"));
    }

    //https://leetcode.com/problems/check-if-a-string-can-break-another-string/solutions/2961837/java-brief-solution/
    //10-15 min
    //Runtime
    //9 ms
    //Beats
    //88.46%
    //Memory
    //43.9 MB
    //Beats
    //77.47%
    static boolean checkIfCanBreak(String s1, String s2) {
        char[] a = s1.toCharArray(), b = s2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        int more = 0, less = 0;
        for (int i = 0; i < a.length; i++) {
            int diff = a[i] - b[i];
            if (diff >= 0) more++;
            if (diff <= 0) less++;
        }
        return more == a.length || less == a.length;
    }
}
