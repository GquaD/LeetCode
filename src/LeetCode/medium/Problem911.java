package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Problem911 {
    //https://leetcode.com/problems/online-election/
    public static void main(String[] args) {
        TopVotedCandidate t = new TopVotedCandidate(new int[]{0, 1, 1, 0, 0, 1, 0}, new int[]{0, 5, 10, 15, 20, 25, 30});
        System.out.println(t.q(3));
        System.out.println(t.q(12));
        System.out.println(t.q(25));
        System.out.println(t.q(15));
        System.out.println(t.q(24));
        System.out.println(t.q(8));
    }


}

//https://leetcode.com/problems/online-election/solutions/4339346/java-treemap-o-nlogn-solution/
//20min
//Runtime
//94 ms
//Beats
//24.40%
//Memory
//54.9 MB
//Beats
//71.5%
class TopVotedCandidate {
    //time -> person
    TreeMap<Integer, Integer> mapRes;

    public TopVotedCandidate(int[] persons, int[] times) {
        mapRes = new TreeMap<>();
        //person -> freq
        Map<Integer, Integer> map = new HashMap<>();
        int maxPerson = 0, maxFreq = 0;
        for (int i = 0; i < times.length; i++) {
            Integer f = map.getOrDefault(persons[i], 0);
            map.put(persons[i], f + 1);
            if (maxFreq <= f + 1) {
                maxPerson = persons[i];
                maxFreq = f + 1;
            }
            mapRes.put(times[i], maxPerson);
        }

    }

    public int q(int t) {
        return mapRes.get(mapRes.floorKey(t));
    }
}
