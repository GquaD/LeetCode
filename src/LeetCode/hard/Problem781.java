package LeetCode.hard;

import java.util.HashMap;
import java.util.Map;

public class Problem781 {
    //https://leetcode.com/problems/rabbits-in-forest/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/rabbits-in-forest/solutions/3649653/java-greedy-o-n-using-frequency-map/
    //10 min
    //Runtime
    //3 ms
    //Beats
    //76.80%
    //Memory
    //41.6 MB
    //Beats
    //58.1%
    static int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : answers) map.put(n, map.getOrDefault(n, 0) + 1);
        int sum = 0;
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (freq - 1 == key) {
                sum += freq;
            } else if (freq <= key){
                sum += key + 1;
            } else {
                int t = freq / (key + 1);
                sum += t * (key + 1);
                if (freq % (key + 1) > 0) sum += key + 1;
            }
        }
        return sum;
    }
}
