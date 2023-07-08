package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem1291 {
    //https://leetcode.com/problems/sequential-digits/

    public static void main(String[] args) {
        LeetCodeUtils.printList(sequentialDigits(100, 300));
        LeetCodeUtils.printList(sequentialDigits(1000, 13000));
    }

    //https://leetcode.com/problems/sequential-digits/solutions/3737999/java-o-k-o-1-pregenerated-sequence/
    //15min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //40.3 MB
    //Beats
    //32.86%
    static String maxNum = "123456789";
    static List<Integer> list;

    static List<Integer> sequentialDigits(int low, int high) {
        if (list == null) generateListOfSequentialNumbers();
        int l = Collections.binarySearch(list, low), r = Collections.binarySearch(list, high);
        l = l < 0 ? -l - 1 : l;
        r = r < 0 ? -r - 2 : r;
        List<Integer> res = new ArrayList<>();
        for (int i = l; i <= r; i++)
            res.add(list.get(i));
        return res;
    }

    private static void generateListOfSequentialNumbers() {
        list = new ArrayList<>();
        for (int i = 2; i <= 9; i++)
            for (int j = 0; j < maxNum.length() - i + 1; j++)
                list.add(Integer.parseInt(maxNum.substring(j, j + i)));
    }
}
