package LeetCode.easy;

public class Problem168 {
    //https://leetcode.com/problems/excel-sheet-column-title/
    public static void main(String[] args) {
        System.out.println(convertToTitle(25));
        System.out.println(convertToTitle(52));
    }

    //https://leetcode.com/problems/excel-sheet-column-title/solutions/2844239/java-100-faster-solution/
    //40 mins
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //39.8 MB
    //Beats
    //87.89%
    static String convertToTitle(int n) {
        if (n >= 1 && n <= 26) return ((char)('A' + n - 1)) + "";
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int r = n % 26;
            if (r == 0) {
                sb.append('Z');
            } else {
                sb.append((char) ('A' + r - 1));
            }
            n /= 26;
            if (r == 0) {
                n--;
            }
        }
        return sb.reverse().toString();
    }
}
