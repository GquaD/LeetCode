package LeetCode.medium;

public class Problem12 {
    //https://leetcode.com/problems/integer-to-roman/
    public static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1994));
        System.out.println(intToRoman(3999));
    }

    //https://leetcode.com/problems/integer-to-roman/solutions/2644848/java-simple-dimple-solution-86-73/
    //10 min
    //Runtime
    //7 ms
    //Beats
    //85.61%
    //Memory
    //45.2 MB
    //Beats
    //72.92%
    static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            if (num / 1000 >= 1) {
                num -= 1000;
                sb.append("M");
            } else if (num / 900 >= 1) {
                num -= 900;
                sb.append("CM");
            } else if (num / 500 >= 1) {
                num -= 500;
                sb.append("D");
            } else if (num / 400 >= 1) {
                num -= 400;
                sb.append("CD");
            } else if (num / 100 >= 1) {
                num -= 100;
                sb.append("C");
            } else if (num / 90 >= 1) {
                num -= 90;
                sb.append("XC");
            } else if (num / 50 >= 1) {
                num -= 50;
                sb.append("L");
            } else if (num / 40 >= 1) {
                num -= 40;
                sb.append("XL");
            } else if (num / 10 >= 1) {
                num -= 10;
                sb.append("X");
            } else if (num / 9 >= 1) {
                num -= 9;
                sb.append("IX");
            } else if (num / 5 >= 1){
                num -= 5;
                sb.append("V");
            } else if (num / 4 >= 1) {
              num -= 4;
              sb.append("IV");
            } else {
                num--;
                sb.append("I");
            }
        }
        return sb.toString();
    }
}
