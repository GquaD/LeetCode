package LeetCode;

public class Problem1323 {
    //https://leetcode.com/problems/maximum-69-number/
    public static void main(String[] args) {
        System.out.println(maximum69Number(9669));
        System.out.println(maximum69Number(9996));
        System.out.println(maximum69Number(9999));
    }

    //Runtime: 10 ms, faster than 11.88% of Java online submissions for Maximum 69 Number.
    //Memory Usage: 41.7 MB, less than 9.97% of Java online submissions for Maximum 69 Number.
    static int maximum69Number (int num) {
        String s = num + "";
        if (!s.contains("6")) return num;
        int index = s.indexOf("6");
        s = s.substring(0, index) + "9" + s.substring(index + 1);
        return Integer.parseInt(s);
    }
}
