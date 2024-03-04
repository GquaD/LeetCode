package LeetCode.medium;

import java.util.*;
import java.util.stream.Collectors;

public class Problem1244 {
    //https://leetcode.com/problems/design-a-leaderboard/
    public static void main(String[] args) {

    }

}

//https://leetcode.com/problems/design-a-leaderboard/solutions/4821630/java-hashmap-sorting/
//10min
//Runtime
//27
//ms
//Beats
//11.05%
//of users with Java
//Memory
//44.66
//MB
//Beats
//37.72%
//of users with Java

class Leaderboard {

    Map<Integer, Integer> map;
    public Leaderboard() {
        map = new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        map.put(playerId, map.getOrDefault(playerId, 0) + score);
    }

    public int top(int K) {
        int sum = 0;
        List<Integer> list = map.values().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        for (int i = 0; i < K; i++) {
            sum += list.get(i);
        }
        return sum;
    }

    public void reset(int playerId) {
        map.put(playerId, 0);
    }
}
