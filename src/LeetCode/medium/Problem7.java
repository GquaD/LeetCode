package LeetCode.medium;

public class Problem7 {
    //https://leetcode.com/problems/reverse-integer/
    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(-2147483648));
    }

    //less than 20 minutes
    //Runtime: 5 ms, faster than 13.59% of Java online submissions for Reverse Integer.
    //Memory Usage: 41.5 MB, less than 38.67% of Java online submissions for Reverse Integer.
    static int reverse(int x) {
        if (x == 0) return x;
        boolean isPositive = x > 0;
        String xString = isPositive ? x + "" :  (x + "").substring(1);
        StringBuilder sb = new StringBuilder();
        sb.append(xString);
        sb.reverse();
        /*char[] arr = xString.toCharArray();
        for (int i = 0; i < arr.length / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            sb.a
        }*/
        long res = Long.parseLong(sb.toString());
        res = isPositive ? res : -res;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) res;
    }

}
