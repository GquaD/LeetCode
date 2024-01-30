package LeetCode.medium;

public class Problem2522 {
    //https://leetcode.com/problems/partition-string-into-substrings-with-values-at-most-k/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/partition-string-into-substrings-with-values-at-most-k/solutions/4649131/java-o-n-greedy/
    //15 min
    //Runtime
    //5
    //ms
    //Beats
    //90.36%
    //of users with Java
    //Memory
    //44.50
    //MB
    //Beats
    //78.31%
    //of users with Java
    static int minimumPartition(String s, int k) {
        long cur = 0, kk = k;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            long n = s.charAt(i) - '0';
            if (n > kk) return -1;

            cur = cur * 10 + n;
            if (cur > kk) {
                count++;
                cur = n;
            }
        }

        if (cur > 0L) count++;

        return count;
    }
}
