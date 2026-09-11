package LeetCode.easy;

import java.util.*;

public class Problem3483 {
    //https://leetcode.com/problems/unique-3-digit-even-numbers
    public static void main(String[] args) {

    }

    //Runtime
    //6
    //ms
    //Beats
    //50.40%
    //Memory
    //46.17
    //MB
    //Beats
    //69.07%
    public int totalNumbers1(int[] digits) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < digits.length; i++) {
            int di = digits[i];
            if (di == 0) continue;
            for (int j = 0; j < digits.length; j++) {
                for (int k = 0; k < digits.length; k++) {
                    int d = digits[k];
                    if (i == j || i == k || j == k || d % 2 != 0) continue;
                    int num = di * 100 + digits[j] * 10 + d;
                    if (num > 99) set.add(num);
                }
            }
        }

        return set.size();
    }

    //https://leetcode.com/problems/unique-3-digit-even-numbers/solutions/6567348/java-backtracking-solution-explained-by-g6qr5/
    //30min
    //Runtime
    //70
    //ms
    //Beats
    //5.15%
    //Analyze Complexity
    //Memory
    //45.12
    //MB
    //Beats
    //8.14%
    public int totalNumbers(int[] digits) {
        Set<Integer> nums = new HashSet<>(), idxs = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            calculate(digits, nums, idxs, sb, i);
        }
        return nums.size();
    }

    private void calculate(int[] digits, Set<Integer> nums, Set<Integer> idxs, StringBuilder sb, int i) {
        if (sb.length() == 3) {
            int n = Integer.parseInt(sb.toString());
            if (n > 99 && n % 2 == 0)
                nums.add(n);
            return;
        }

        if (!idxs.contains(i)) {
            idxs.add(i);
            sb.append(digits[i]);
            for (int j = 0; j < digits.length; j++) {
                if (!idxs.contains(j)) {
                    calculate(digits, nums, idxs, sb, j);
                }
            }
            if (sb.length() == 3) {
                int n = Integer.parseInt(sb.toString());
                if (n > 99 && n % 2 == 0)
                    nums.add(n);
            }
            idxs.remove(i);
            sb.setLength(sb.length() - 1);
        }
    }
}
