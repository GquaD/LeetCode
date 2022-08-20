package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Problem118 {
    //https://leetcode.com/problems/pascals-triangle/
    public static void main(String[] args) {
        LeetCodeUtils.printListWithListsOfIntegers(generate(1));
        System.out.println();
        LeetCodeUtils.printListWithListsOfIntegers(generate(5));
        System.out.println();
        LeetCodeUtils.printListWithListsOfIntegers(generate(30));
    }

    //Runtime: 1 ms, faster than 73.27% of Java online submissions for Pascal's Triangle.
    //Memory Usage: 42.3 MB, less than 9.64% of Java online submissions for Pascal's Triangle.
    static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        one.add(1);
        list.add(one);
        if (numRows == 1) {
            return list;
        }
        for (int i = 2; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            List<Integer> prev = list.get(list.size() - 1);
            for (int j = 0; j < i; j++) {
                if (j - 1 < 0) {
                    temp.add(prev.get(j));
                } else if (j >= prev.size()) {
                    temp.add(prev.get(j - 1));
                } else {
                    temp.add(prev.get(j - 1) + prev.get(j));
                }
            }
            list.add(temp);
        }
        return list;
    }
}
