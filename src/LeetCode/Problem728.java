package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Problem728 {
    //https://leetcode.com/problems/self-dividing-numbers/
    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(1, 22).toString());
        System.out.println(selfDividingNumbers(47, 85));
//        System.out.println(selfDividingNumbers());
    }

    //Runtime: 10 ms, faster than 10.62% of Java online submissions for Self Dividing Numbers.
    //Memory Usage: 44.2 MB, less than 16.60% of Java online submissions for Self Dividing Numbers.
    static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int num = left; num <= right; num++) {
            String s = num + "";
            if (s.contains("0")) {
                continue;
            }
            boolean isSDN = true;
            for (int j = 0; j < s.length(); j++) {
                if (num % (s.charAt(j) - 48) != 0) {
                    isSDN = false;
                }
            }
            if (isSDN) {
                list.add(num);
            }
        }
        return list;
    }
}
