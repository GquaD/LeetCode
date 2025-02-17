package LeetCode.medium;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem767 {
    //https://leetcode.com/problems/reorganize-string/
    public static void main(String[] args) {
        System.out.println(reorganizeString("aabbcc"));
        System.out.println(reorganizeString("aaabc"));
        System.out.println(reorganizeString("aab"));
        System.out.println(reorganizeString("aaab"));
        System.out.println(reorganizeString("aaab"));
    }

    //https://leetcode.com/problems/reorganize-string/solutions/6434251/java-hashmap-max-heap-solution-by-tbekpr-xlax/
    //15min
    //Runtime
    //4
    //ms
    //Beats
    //53.59%
    //Analyze Complexity
    //Memory
    //41.94
    //MB
    //Beats
    //37.03%
    public static String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        for (char key: map.keySet()) {
            pq.offer(new Pair(key, map.get(key)));
        }

        StringBuilder sb = new StringBuilder();
        while (pq.size() > 1) {
            Pair one = pq.poll(), two = pq.poll();
            int count = one.freq == two.freq ? 1 : two.freq;
            while (count-- > 0) {
                sb.append(one.letter);
                sb.append(two.letter);
            }
            if (one.freq > two.freq) {
                one.freq -= two.freq;
                pq.offer(one);
            } else if (one.freq == two.freq) {
                one.freq--;
                if (one.freq > 0) pq.offer(one);
                two.freq--;
                if (two.freq > 0) pq.offer(two);
            }
        }
        if (pq.size() == 1) {
            Pair p = pq.poll();
            if (p.freq > 1) return "";
            sb.append(p.letter);
        }

        return sb.toString();
    }

    static class Pair {
        char letter;
        int freq;

        public Pair(char c, int f) {
            letter = c;
            freq = f;
        }
    }


    //https://leetcode.com/problems/reorganize-string/solutions/3649843/java-o-n-greedy-using-frequency-map-and-priorityqueue/
    //30 min
    //Runtime
    //5 ms
    //Beats
    //48.65%
    //Memory
    //41.3 MB
    //Beats
    //27.19%
//    static String reorganizeString(String s) {
//        if (s.length() == 1) return s;
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
//        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>((x, z) -> z.getValue() - x.getValue());
//        for (Character c : map.keySet()) pq.offer(new Pair<>(c, map.get(c)));
//        StringBuilder sb = new StringBuilder();
//        while (pq.size() > 1) {
//            Pair<Character, Integer> a = pq.poll(), b = pq.poll();
//            if (a.getValue() == b.getValue()) {
//                sb.append(a.getKey()).append(b.getKey());
//                if (a.getValue() > 1) pq.offer(new Pair<>(a.getKey(), a.getValue() - 1));
//                if (b.getValue() > 1) pq.offer(new Pair<>(b.getKey(), b.getValue() - 1));
//            } else {
//                for (int i = 0; i < b.getValue(); i++) sb.append(a.getKey()).append(b.getKey());
//                if (a.getValue() > b.getValue()) pq.offer(new Pair<>(a.getKey(), a.getValue() - b.getValue()));
//            }
//        }
//        if (pq.size() > 0) sb.append(pq.poll().getKey());
//        String res = sb.toString();
//        return res.length() == s.length() ? res : "";
//    }
//
//    static String reorganizeString2(String s) {
//        int[] alph = new int[26];
//        for (int i = 0; i < s.length(); i++) alph[s.charAt(i) - 'a']++;
//        StringBuilder sb = new StringBuilder();
//        while (sb.length() < s.length()) {
//            boolean appended = false;
//            for (int i = 0; i < alph.length; i++) {
//                char c = (char)('a' + i);
//                if (alph[i] > 0 && (sb.length() == 0 || sb.charAt(sb.length() - 1) != c)) {
//                    sb.append(c);
//                    appended = true;
//                    alph[i]--;
//                }
//            }
//            if (!appended) break;
//        }
//        String res = sb.toString();
//        return res.length() == s.length() ? res : "gap";
//    }


    static String reorganizeString1(String s) {
        int max = 0, alph[] = new int[26];
        for (int i = 0; i < s.length(); i++) alph[s.charAt(i) - 'a']++;
        for (int i = 0; i < alph.length; i++) max = Math.max(max, alph[i]);
        if (s.length() - max < max - 1) return "";
        StringBuilder sb = new StringBuilder();
        while (!allAreZero(alph)) {
            for (int i = 0; i < alph.length; i++) if (alph[i]-- > 0) sb.append((char) (i + 'a'));
        }
        return sb.toString();
    }

    private static boolean allAreZero(int[] alph) {
        for (int n : alph) if (n > 0) return false;
        return true;
    }
}
