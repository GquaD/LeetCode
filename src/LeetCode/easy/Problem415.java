package LeetCode.easy;

public class Problem415 {
    //https://leetcode.com/problems/add-strings/description/
    public static void main(String[] args) {
        System.out.println(addStrings("123", "11"));
        System.out.println(addStrings("456", "77"));
        System.out.println(addStrings("0", "0"));
        System.out.println(addStrings("99", "99"));
        System.out.println(addStrings("10", "90"));
    }

    //https://leetcode.com/problems/add-strings/solutions/3018615/java-o-n-2ms-99-memory-solution/
    //15 min
    //Runtime
    //2 ms
    //Beats
    //92.39%
    //Memory
    //41.9 MB
    //Beats
    //98.69%
    static String addStrings(String num1, String num2) {
        String big = num1.length() >= num2.length() ? num1 : num2;
        String small = num1.length() < num2.length() ? num1 : num2;
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < big.length(); i++) {
            int b = big.charAt(big.length() - i - 1) - '0';
            int s = i < small.length() ? (small.charAt(small.length() - i - 1) - '0') : 0;
            sum += b + s;
            sb.append(sum % 10);
            sum /= 10;
        }
        if (sum > 0) sb.append(sum);
        return sb.reverse().toString();
    }
}
