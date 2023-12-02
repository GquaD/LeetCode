package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem2698 {
    //https://leetcode.com/problems/find-the-punishment-number-of-an-integer/
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        System.out.println(punishmentNumber(1000));
        System.out.println((System.currentTimeMillis() - time) + "ms");
        System.out.println(punishmentNumber(10));
        System.out.println((System.currentTimeMillis() - time) + "ms");
//        System.out.println(punishmentNumber(37));
    }

    static int[] arr;
    static int lastMax;
    private static boolean isGood;

    //https://leetcode.com/problems/find-the-punishment-number-of-an-integer/solutions/4354200/java-recursive-caching/
    //2 hours
    //Runtime
    //74 ms
    //Beats
    //53.57%
    //Memory
    //44.5 MB
    //Beats
    //5.36%

    //Time Limit Exceeded
    //216 / 216 testcases passed
    //Testcases passed, but took too long.
    //before added start
    static int punishmentNumber(int n) {
        isGood = false;
        if (arr == null) {
            arr = new int[1001];
            arr[1] = 1;
            lastMax = 1;
            for (int i = lastMax + 1; i <= 1000; i++) {
                int mult = i * i;
                if (canBePartitioned(i, mult)) {
                    isGood = false;
                    arr[i] = arr[i - 1] + mult;
                    lastMax = i;
                } else {
                    arr[i] = arr[i - 1];
                }
            }
        }

        return arr[n];
    }

    private static boolean canBePartitioned(int num, int mult) {
        String sMult = String.valueOf(mult);
        goRecursive(num, sMult, "", 0, 1, 1, new ArrayList<>());
        return isGood;
    }

    private static void goRecursive(int num, String sMult, String curr,
                                    int idx, int start, int size, List<Integer> list) {
        if (isGood) return;

        if (idx >= sMult.length()) {
            int sum = 0;
            int listSize = list.size();
            list.add(Integer.parseInt(curr));
            for (int n : list) sum += n;
            if (sum == num) isGood = true;
            list.remove(listSize);
            return;
        }

        if (curr.length() == size) {
            int listSize = list.size();
            list.add(Integer.parseInt(curr));
            goRecursive(num, sMult, "", idx, 1, size, list);
            list.remove(listSize);
        } else {
            for (int i = start; i <= sMult.length(); i++) {
                if (idx < sMult.length()) goRecursive(num, sMult, curr + sMult.charAt(idx), idx + 1, i, i, list);
            }
        }


        /*if (curr.length() == size) {
            int listSize = list.size();
            list.add(Integer.parseInt(curr));
            goRecursive(num, sMult, "", idx, size, list);
            list.remove(listSize);
        } else {
            for (int i = 1; i <= size; i++) {
                goRecursive(num, sMult, curr + sMult.charAt(idx), idx + 1, i, list);
            }
        }*/
    }


    private static void generateArray() {
        arr = new int[1001];
        int sum = 1;
        arr[1] = sum;
        for (int i = 2; i <= 1000; i++) {
            int square = i * i;
            if (square > 9) {
                String num = Integer.toString(square);
                for (int j = 0; j < num.length() - 1; j++) {
                    int a = Integer.parseInt(num.substring(0, j + 1));
                    int b = Integer.parseInt(num.substring(j + 1));
                    if (a + b == i) {
                        sum += square;
                        break;
                    }
                }
            }
            arr[i] = sum;
        }
    }
}
