package LeetCode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Problem738 {
    //https://leetcode.com/problems/monotone-increasing-digits/
    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(332));
        System.out.println(monotoneIncreasingDigits(10));
        System.out.println(monotoneIncreasingDigits(2));
        System.out.println(monotoneIncreasingDigits(1234));

    }

    //https://leetcode.com/problems/monotone-increasing-digits/solutions/3614564/java-greedy-solution/
    //25 - 30 min
    //Runtime
    //2 ms
    //Beats
    //22.94%
    //Memory
    //39.4 MB
    //Beats
    //92.94%
    static int monotoneIncreasingDigits(int n) {
        if (n < 10) return n;
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }
        Collections.reverse(list);
        int idx = list.size() - 1;
        while (!isMonotoneIncreasing(list)) {
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    idx = i;
                    break;
                }
            }
            list.set(idx, list.get(idx) - 1);
            for (int i = idx + 1; i < list.size(); i++) {
                if (list.get(i) != 9) list.set(i, 9);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) sb.append(list.get(i));
        return Integer.parseInt(sb.toString());
    }

    private static boolean isMonotoneIncreasing(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) if (list.get(i) > list.get(i + 1)) return false;
        return true;
    }


    static int monotoneIncreasingDigits2(int n) {
        if (n < 10) return n;
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }
        Collections.reverse(list);
        int a = list.get(list.size() - 1);
        for (int i = list.size() - 2; i >= 0; i--) {
            int curr = list.get(i);
            if (a < curr) {
                sb.append(9);
                a = curr - 1;
            } else {
                sb.append(a);
                a = curr;
            }
        }
        sb.append(a);
        return Integer.parseInt(sb.reverse().toString());
    }

    static int monotoneIncreasingDigits1(int n) {
        if (n < 10) return n;
        Stack<Integer> stack = new Stack<>();
        while (n > 0) {
            stack.push(n % 10);
            n /= 10;
        }
        StringBuilder sb = new StringBuilder();
        int a = stack.pop();
        boolean stopped = false;
        while (!stack.isEmpty()) {
            int b = stack.peek();
            if (a <= b) {
                sb.append(a);
                a = stack.pop();
            } else {
                if (a - 1 > 0) sb.append(a - 1);
                stopped = true;
                break;
            }
        }
        if (stopped) for (int i = 0; i < stack.size(); i++) sb.append(9);
        else sb.append(a);
        return Integer.parseInt(sb.toString());
    }
}
