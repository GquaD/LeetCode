package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem507 {
    //
    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(6));
        System.out.println(checkPerfectNumber(28));
        System.out.println(checkPerfectNumber(7));
        long time = System.currentTimeMillis();
        System.out.println(checkPerfectNumber(99999998));
        System.out.println(System.currentTimeMillis() - time);
    }
    //Runtime: 2772 ms, faster than 5.06% of Java online submissions for Perfect Number.
    //Memory Usage: 40.8 MB, less than 55.24% of Java online submissions for Perfect Number.
    static boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        List<Integer> list = new ArrayList<>();
        int div = 1;
        list.add(div++);
        int half = num / 2;
        while (div <= half) {
            if (num % div == 0) {
                list.add(div);
            }
            div++;
        }
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum == num;
    }

    static boolean checkPerfectNumber1(int num) {
        List<Integer> list = new ArrayList<>();
        int div = 1, tempNum = num;
        list.add(div++);
        while (tempNum > 1) {
            if (tempNum % div == 0) {
                list.add(div);
                tempNum = tempNum / div;
                div = 1;
            }
            div++;
        }


        int sum = 0;
        sum = calculateSumOfDivisors(list, 0, 0);
        /*for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }*/
        return sum == num;
    }

    private static int calculateSumOfDivisors(List<Integer> list, int index, int sum) {
        if(index > list.size() - 1) {
            return sum;
        }
        sum += list.get(index);
        return calculateSumOfDivisors(list, index + 1, sum) + calculateSumOfDivisors(list, index + 1, 0);
    }



}
