package LeetCode.medium;

public class Problem686 {
    //https://leetcode.com/problems/repeated-string-match
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/repeated-string-match/solutions/5794250/java-straightforward-solution/
    //5min
    //Runtime
    //5
    //ms
    //Beats
    //91.23%
    //Analyze Complexity
    //Memory
    //41.92
    //MB
    //Beats
    //85.36%
    static int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }
        if (sb.toString().lastIndexOf(b) >= 0) {
            return count;
        } else {
            sb.append(a);
            count++;
        }

        return sb.toString().lastIndexOf(b) >= 0 ? count : -1;
    }
}
