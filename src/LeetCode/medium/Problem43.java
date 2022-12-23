package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem43 {
    //https://leetcode.com/problems/multiply-strings/
    public static void main(String[] args) {
        System.out.println(multiply("408", "5"));
        System.out.println(multiply("1", "2"));
        System.out.println(multiply("0", "0"));
        System.out.println(multiply("123", "456"));
        System.out.println(multiply("2", "3"));
        System.out.println(multiply("999", "99999"));
    }

    //https://leetcode.com/problems/multiply-strings/solutions/2941439/java-ugly-solution/
    //40 min
    //Runtime
    //15 ms
    //Beats
    //42.18%
    //Memory
    //45.5 MB
    //Beats
    //19.18%
    static String multiply(String num1, String num2) {
        String big = "", small = "";
        if (num1.length() >= num2.length()) {
            big = num1;
            small = num2;
        } else {
            big = num2;
            small = num1;
        }
        String[] arr = new String[small.length()];
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = small.length() - 1; i >= 0 ; i--) {
            int s = small.charAt(i) - '0', mem = 0;
            for (int j = big.length() - 1; j >= 0; j--) {
                int b = big.charAt(j) - '0';
                int res = s * b + mem;
                sb.append(res % 10);
                mem = res / 10;
            }
            if (mem > 0) sb.append(mem);
            arr[count++] = sb.toString();
            sb.setLength(0);
        }
        int rows = small.length(), cols = big.length() + 1 + small.length();
        int[][] arrInt = new int[rows][cols];
        for (int i = 0; i < arr.length; i++) {
            char[] chars = arr[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                arrInt[i][cols - 1 - i - j] = chars[j] - '0';
            }
        }

        //sum cols
        sb.setLength(0);
        int sum = 0;
        for (int c = arrInt[0].length - 1; c >= 0;  c--) {
            for (int r = 0; r < arrInt.length; r++) {
                sum += arrInt[r][c];
            }
            sb.append(sum % 10);
            sum /= 10;
        }
        String result = sb.reverse().toString();
        result = removeLeadingZeros(result);
        return result.isEmpty() ? "0" : result;
    }

    private static String removeLeadingZeros(String result) {
        while (result.startsWith("0")) result = result.substring(1);
        return result;
    }


    static String multiply1(String num1, String num2) {
        /*String temp = num1.length() > num2.length() ? num1 : num2;
        num2 = num1.length() <= num2.length() ? num1 : num2;
        num1 = temp;*/
        StringBuilder sb = new StringBuilder();
        int mem = 0;
        List<String> multiples = new ArrayList<>();
        for (int i = 0; i < num1.length() ; i++) {
            int c1 = num1.charAt(num1.length() - i - 1);
            int c2 = num2.length() - i - 1 >= 0 ? num2.charAt(num2.length() - i - 1) : '1';
            int a = c1 - '0', b = c2 - '0';
            int res = a * b + mem;
            mem = res / 10;
            sb.append(res % 10);
        }
        return sb.reverse().toString();
    }
}
