package LeetCode.medium;

public class Problem3271 {
    //https://leetcode.com/problems/hash-divided-string/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/hash-divided-string/solutions/5730768/java-o-n-solution/
    //2min
    //Runtime
    //2
    //ms
    //Beats
    //96.32%
    //Analyze Complexity
    //Memory
    //44.69
    //MB
    //Beats
    //86.84%
    static String stringHash(String s, int k) {
        int n = s.length(), times = n / k;
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (int i = 0; i < times; i++) {
            int sum = 0;
            for (int j = start; j < start + k; j++) {
                sum += (s.charAt(j) - 'a');
            }
            sum %= 26;
            sb.append(((char)(sum + 'a')));
            start += k;
        }
        return sb.toString();
    }
}
