package LeetCode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Problem3175 {
    //https://leetcode.com/problems/find-the-first-player-to-win-k-games-in-a-row
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-the-first-player-to-win-k-games-in-a-row/solutions/6181205/java-solution-by-tbekpro-k79z/
    //5-10min
    //Runtime
    //69
    //ms
    //Beats
    //11.11%
    //Analyze Complexity
    //Memory
    //76.21
    //MB
    //Beats
    //7.78%
    public int findWinningPlayer(int[] skills, int k) {
        if (k - 1 >= skills.length) {
            int max = 0, idx = 0;
            for (int i = 0; i < skills.length; i++) {
                if (max < skills[i]) {
                    max = skills[i];
                    idx = i;
                }
            }
            return idx;
        }
        LinkedList<Integer> list = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < skills.length; i++) {
            map.put(skills[i], i);
            list.add(skills[i]);
        }
        int count = 0;
        while (true) {
            int a = list.removeFirst(), b = list.removeFirst();
            if (a > b) {
                list.addLast(b);
                list.addFirst(a);
                count++;
            } else {
                list.addLast(a);
                list.addFirst(b);
                count = 1;
            }
            if (count >= k) {
                return map.get(list.getFirst());
            }
        }
    }
}
