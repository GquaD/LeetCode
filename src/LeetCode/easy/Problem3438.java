package LeetCode.easy;

public class Problem3438 {
    //https://leetcode.com/problems/find-valid-pair-of-adjacent-digits-in-string
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-valid-pair-of-adjacent-digits-in-string/solutions/6404527/java-1ms-solution-by-tbekpro-04tf/
    //5min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //42.36
    //MB
    //Beats
    //99.93%
    public String findValidPair(String s) {
        int[] arr = new int[10];

        for (int i = 0; i < s.length(); i++) arr[s.charAt(i) - '0']++;

        for (int i = 1; i < s.length(); i++) {
            int a = s.charAt(i - 1) - '0', b = s.charAt(i) - '0';
            if (arr[a] == a && arr[b] == b && a != b) {
                return s.substring(i - 1, i + 1);
            }
        }

        return "";
    }
}
