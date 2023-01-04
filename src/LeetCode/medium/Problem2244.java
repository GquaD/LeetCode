package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem2244 {
    //https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/description/
    public static void main(String[] args) {
        System.out.println(minimumRounds(new int[]{69,65,62,64,70,68,69,67,60,65,69,62,65,65,61,66,68,61,65,63,60,66,68,66,67,65,63,65,70,69,70,62,68,70,60,68,65,61,64,65,63,62,62,62,67,62,62,61,66,69}));
    }

    //https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/solutions/2996056/java-solution-using-map/
    //15 min
    //Runtime
    //120 ms
    //Beats
    //10.96%
    //Memory
    //108.5 MB
    //Beats
    //17.39%
    static int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            int t = tasks[i];
            if (map.containsKey(t)) map.put(t, map.get(t) + 1);
            else map.put(t, 1);
        }
        int count = 0;
        for (int key : map.keySet()) {
            int n = map.get(key);
            if (n == 1) return -1;
            if (n == 2 || n == 3) count++;
            else if (n % 3 == 1) count += ((n - 4) / 3) + 2;
            else if (n % 3 == 2) count += ((n - 2) / 3) + 1;
            else if (n % 3 == 0) count += n / 3;
        }
        return count;
    }
}
