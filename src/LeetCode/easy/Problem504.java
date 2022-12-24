package LeetCode.easy;

public class Problem504 {
    //https://leetcode.com/problems/base-7/
    public static void main(String[] args) {
        System.out.println(convertToBase7(-56));
        System.out.println(convertToBase7(-7));
        System.out.println(convertToBase7(-9));
        System.out.println(convertToBase7(100));
        System.out.println(convertToBase7(9));
    }

    //https://leetcode.com/problems/base-7/solutions/2944612/java-98-faster/
    //Runtime
    //1 ms
    //Beats
    //97.51%
    //Memory
    //40 MB
    //Beats
    //79.11%
    static String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        while(Math.abs(num) > 6) {
            sb.append(num % 7);
            num = num / 7;
        }
        if (num < 0) {
            sb.append(Math.abs(num)).append("-");
        } else {
            sb.append(num);
        }
        for (int i = 0; i < sb.length() - 1; i++) {
            if (!Character.isDigit(sb.charAt(i))) {
                sb.replace(i, i + 1, "");
            }
        }
        return sb.reverse().toString();
    }
}
