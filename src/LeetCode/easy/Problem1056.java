package LeetCode.easy;

public class Problem1056 {
    //https://leetcode.com/problems/confusing-number/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/confusing-number/solutions/6026720/java-100-faster-solution/
    //5min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //40.06
    //MB
    //Beats
    //90.00%
    public boolean confusingNumber(int n) {
        String a = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        for (int i = a.length() - 1; i >= 0; i--) {
            int c = a.charAt(i) - '0';
            if (c == 2 || c == 3 || c == 4 || c == 5 || c == 7) return false;
            else if (c == 0 || c == 1 || c == 8) sb.append(c);
            else if (c == 6) sb.append(9);
            else sb.append(6);
        }
        int b = Integer.parseInt(sb.toString());
        return n != b;
    }
}
