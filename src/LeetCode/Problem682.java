package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class Problem682 {
    //https://leetcode.com/problems/baseball-game/
    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5", "2", "C", "D", "+" }));
        System.out.println(calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+" }));
        System.out.println(calPoints(new String[]{"1", "C" }));
    }

    //Runtime: 6 ms, faster than 22.88% of Java online submissions for Baseball Game.
    //Memory Usage: 42.2 MB, less than 57.97% of Java online submissions for Baseball Game.
    static int calPoints(String[] ops) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < ops.length; i++) {
            String op = ops[i];
            if (op.equals("C")) {
                list.remove(list.size() - 1);
            } else if (op.equals("D")) {
                list.add(list.get(list.size() - 1) * 2);
            } else if (op.equals("+")) {
                list.add(list.get(list.size() - 2) + list.get(list.size() - 1));
            } else {
                list.add(Integer.parseInt(op));
            }
        }
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }
}
