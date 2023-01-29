package LeetCode.easy;

import java.util.*;

public class Problem2231 {
    //https://leetcode.com/problems/largest-number-after-digit-swaps-by-parity/description/
    public static void main(String[] args) {
        System.out.println(largestInteger(1234));
        System.out.println(largestInteger(247));
    }

    //15 min
    //Runtime
    //3 ms
    //Beats
    //40.48%
    //Memory
    //39.3 MB
    //Beats
    //66.67%
    static int largestInteger(int num) {
        if (num < 10) return num;
        List<Integer> list = new ArrayList<>();
        while (num > 0) {
            list.add(num % 10);
            num /= 10;
        }
        Collections.reverse(list);
        List<Integer> listEven = new ArrayList<>();
        List<Integer> listOdd = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) listEven.add(list.get(i));
            else listOdd.add(list.get(i));
        }
        Collections.sort(listEven, (o1, o2) -> o2 - o1);
        Collections.sort(listOdd, (o1, o2) -> o2 - o1);
        StringBuilder sb = new StringBuilder();

        int even = 0, odd = 0;
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i) % 2 == 0 ? listEven.get(even++) : listOdd.get(odd++));
        }
        return Integer.parseInt(sb.toString());
    }
}
