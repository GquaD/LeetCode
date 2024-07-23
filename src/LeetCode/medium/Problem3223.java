package LeetCode.medium;

public class Problem3223 {
    //https://leetcode.com/problems/minimum-length-of-string-after-operations

    //https://leetcode.com/problems/minimum-length-of-string-after-operations/solutions/5522124/java-o-n-100-faster-solution/
    //5min
    //Runtime
    //8
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //46.39
    //MB
    //Beats
    //47.32%
    public int minimumLength(String s) {
        int[] alph = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alph[s.charAt(i) - 'a']++;
        }
        int sum = 0;
        for (int f : alph) {
            if (f != 0) {
                sum += f % 2 == 1 ? 1 : 2;
            }
        }
        return sum;
    }
}
