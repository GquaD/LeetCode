package LeetCode.easy;

public class Problem2710 {
    //https://leetcode.com/problems/remove-trailing-zeros-from-a-string/
    public static void main(String[] args) {
        System.out.println(removeTrailingZeros("51230100"));
        System.out.println(removeTrailingZeros("123"));
    }

    //https://leetcode.com/problems/remove-trailing-zeros-from-a-string/solutions/3700692/java-100-faster-solution/
    //5min
    //Runtime
    //1 ms
    //Beats
    //100%
    //Memory
    //44 MB
    //Beats
    //39.67%
    static String removeTrailingZeros(String num) {
        int idx = num.length();
        for (int i = num.length() - 1; i >= 0; i--) {
            if (num.charAt(i) != '0') break;
            else idx = i;
        }
        return num.substring(0, idx);
    }

    //Runtime
    //2 ms
    //Beats
    //71.72%
    //Memory
    //43.6 MB
    //Beats
    //97.24%
    static String removeTrailingZeros1(String num) {
        int idx = num.length();
        boolean hasNonZero = false;
        for (int i = num.length() - 1; i >= 0; i--) {
            if (!hasNonZero && num.charAt(i) == '0') idx = i;
            else if (num.charAt(i) != '0') hasNonZero = true;
        }
        return num.substring(0, idx);
    }
}
