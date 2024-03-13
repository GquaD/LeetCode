package LeetCode.medium;


import java.util.HashMap;
import java.util.Map;

public class Problem1010 {
    //https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
    public static void main(String[] args) {
        System.out.println(numPairsDivisibleBy60(new int[]{60,60,60,60,60}));
        System.out.println(numPairsDivisibleBy60(new int[]{30,20,150,100,40}));
    }

    //https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/solutions/4869775/java-o-n-frequency-map/
    //45min
    //Runtime
    //14
    //ms
    //Beats
    //51.16%
    //of users with Java
    //Memory
    //53.14
    //MB
    //Beats
    //27.30%
    //of users with Java
    static int numPairsDivisibleBy60(int[] time) {
        //mod -> freq
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < time.length; i++) {
            int n = time[i], mod = n % 60;
            time[i] = mod;
            map.put(mod, map.getOrDefault(mod, 0L) + 1L);
        }

        long count = 0;
        for (int mod : time) {
            Long freq = map.get(60 - mod), freq2 = map.get(mod);
            if (map.size() == 0) break;
            if (freq2 != null && ( mod == 0 && freq2 > 1 || mod == 30)) {
                count += ((freq2 - 1L) * freq2) / 2L;
                map.remove(mod);
            } else if (freq != null && freq2 != null) {
                count += freq * freq2;
                map.remove(mod);
                map.remove(60 - mod);
            }
        }
        return (int) count;
    }
}
