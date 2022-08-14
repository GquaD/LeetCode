package LeetCode.medium;

import java.util.LinkedList;
import java.util.List;

public class Problem1823 {
    //https://leetcode.com/problems/find-the-winner-of-the-circular-game/
    public static void main(String[] args) {
        System.out.println(findTheWinner(5, 3));
        System.out.println(findTheWinner(5, 5));
        System.out.println(findTheWinner(5, 2));
        System.out.println(findTheWinner(6, 5));
        System.out.println(findTheWinner(3, 1));
    }

    //Runtime: 43 ms, faster than 28.92% of Java online submissions for Find the Winner of the Circular Game.
    //Memory Usage: 40.9 MB, less than 74.87% of Java online submissions for Find the Winner of the Circular Game
    static int findTheWinner(int n, int k) {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int count = 0, index = 0;
        while (list.size() > 1) {
            count++;
            if (count % k == 0) {
                list.remove(index);
                count = 0;
                index--;
            }
            index++;
            index %= list.size();
        }
        return list.get(0);
    }

    static int findTheWinner1(int n, int k) {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int count = 0;
        while (list.size() > 1) {
            for (int i = 0; i < list.size(); i++) {
                count++;
                if (count == k) {
                    list.remove(i);
                    i -= 1;
                    count = 0;
                }
            }
        }
        return list.get(0);
    }
}
