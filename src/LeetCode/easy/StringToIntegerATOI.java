package LeetCode.easy;

import javax.swing.plaf.nimbus.AbstractRegionPainter;


//todo not finished

public class StringToIntegerATOI {
    public static void main(String[] args) {
        System.out.println(myAtoi("-42"));
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with word"));
        System.out.println(myAtoi("---21"));
        System.out.println(myAtoi("---2100000000012"));
    }

    public static int myAtoi(String s) {
            StringBuilder number = new StringBuilder();
            int dash = '-';
            for (int i = 0; i < s.length(); i++) {
                if (isNumeric(s.charAt(i) + "") && i != 0 && s.charAt(i - 1) == dash) {
                    number = new StringBuilder("-" + number);
                }
                if (isNumeric(s.charAt(i) + "")) {
                    number.append(s.charAt(i));
                } else if (number.toString().length() > 0) {
                    break;
                }
            }
            return Integer.parseInt(number.toString());
    }

    public static boolean isNumeric(String s) {
        if (s.contains("0") || s.contains("1") || s.contains("2") ||
                s.contains("3") || s.contains("4") || s.contains("5") ||
                s.contains("6") || s.contains("7") || s.contains("8") ||
                s.contains("9")) {
            return true;
        } else return false;
    }
}
