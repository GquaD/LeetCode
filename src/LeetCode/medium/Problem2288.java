package LeetCode.medium;

import java.text.DecimalFormat;

public class Problem2288 {
    //https://leetcode.com/problems/apply-discount-to-prices/
    public static void main(String[] args) {
        System.out.println(discountPrices("$76111 ab $6 $", 48));
        System.out.println(discountPrices("there are $1 $2 and 5$ candies in the shop", 50));
        System.out.println(discountPrices("1 2 $3 4 $5 $6 7 8$ $9 $10$", 100));
    }

    //https://leetcode.com/problems/apply-discount-to-prices/solutions/4332464/java-straightforward-solution/
    //15min
    //Runtime
    //70 ms
    //Beats
    //95.83%
    //Memory
    //48.2 MB
    //Beats
    //78.12%
    private static final DecimalFormat formatter = new DecimalFormat("0.00");

    static String discountPrices(String sentence, int discount) {
        String[] split = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            if (isPrice(s)) {
                sb.append('$');
                sb.append(applyDiscount(s, discount));
            } else {
                sb.append(s);
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    private static String applyDiscount(String s, int discount) {
        double before = Double.parseDouble(s.substring(1));
        before = before - ((before / 100) * discount);
        return formatter.format(before);
    }

    private static boolean isPrice(String s) {
        if (s.charAt(0) != '$' || s.length() < 2) return false;
        for (int i = 1; i < s.length(); i++) if (!Character.isDigit(s.charAt(i))) return false;
        return true;
    }
}
