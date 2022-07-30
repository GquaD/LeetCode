package LeetCode.medium;

import java.util.*;

public class Problem6 {
    //https://leetcode.com/problems/zigzag-conversion/
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
    }

    //Runtime: 9 ms, faster than 74.75% of Java online submissions for Zigzag Conversion.
    //Memory Usage: 42.5 MB, less than 96.22% of Java online submissions for Zigzag Conversion.
    static String convert(String s, int numRows) {
        List<List<Character>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Character> temp = new ArrayList<>();
            list.add(temp);
        }
        int index = 0;
        while (index < s.length()) {
            //move down
            for (int i = 0; i < numRows; i++) {
                if (index >= s.length()) break;;
                list.get(i).add(s.charAt(index++));
            }
            //move diagonally up
            for (int i = numRows - 2; i > 0 ; i--) {
                if (index >= s.length()) break;;
                list.get(i).add(s.charAt(index++));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                sb.append(list.get(i).get(j));
            }
        }
        return sb.toString();
    }
}
