package LeetCode.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem2182 {
    //20min

    //Runtime
    //107
    //ms
    //Beats
    //9.14%
    //Analyze Complexity
    //Memory
    //48.16
    //MB
    //Beats
    //24.57%
    public String repeatLimitedString(String s, int limit) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(Pair::getLetter).reversed());
        for (char c : map.keySet()) {
            Pair p = new Pair(c, map.get(c));
            pq.offer(p);
        }

        StringBuilder sb = new StringBuilder();
        while (pq.size() > 1) {
            Pair one = pq.poll(), two = pq.poll();
            if (sb.length() == 0 || one.letter != sb.charAt(sb.length() - 1)) {
                if (one.freq > limit) {
                    for (int i = 0; i < limit; i++) {
                        sb.append(one.letter);
                    }
                    one.freq -= limit;
                    pq.offer(one);
                    pq.offer(two);
                    continue;
                } else {
                    for (int i = 0; i < one.freq; i++) {
                        sb.append(one.letter);
                    }
                }

                if (two.freq > limit) {
                    for (int i = 0; i < limit; i++) {
                        sb.append(two.letter);
                    }
                    two.freq -= limit;
                    pq.offer(two);
                } else {
                    for (int i = 0; i < two.freq; i++) {
                        sb.append(two.letter);
                    }
                }
            } else {
                sb.append(two.letter);
                two.freq--;
                pq.offer(one);
                if (two.freq > 0) pq.offer(two);
            }

        }

        if (pq.size() == 1) {
            Pair one = pq.poll();
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != one.letter) {
                int repeat = Math.min(limit, one.freq);
                for (int i = 0; i < repeat; i++) {
                    sb.append(one.letter);
                }
            }
        }

        return sb.toString();
    }
}

class Pair {
    char letter;
    int freq;

    public Pair(char l, int f) {
        letter = l;
        freq = f;
    }

    public char getLetter() {
        return letter;
    }
}
