package LeetCode.easy;

public class Problem1556 {
    //https://leetcode.com/problems/thousand-separator
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/thousand-separator/solutions/6711111/java-olog10n-solution-by-tbekpro-beq0/
    //5min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //41.21
    //MB
    //Beats
    //28.57%
    public String thousandSeparator(int n) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (n > 0) {
            if (count % 3 == 0 && count > 0) sb.append('.');
            sb.append(n % 10);
            n /= 10;
            count++;
        }
        if (count == 0) return "0";
        return sb.reverse().toString();
    }
}
