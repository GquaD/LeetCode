package LeetCode.medium;

import java.util.*;

public class Problem1181 {
    //https://leetcode.com/problems/before-and-after-puzzle/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/before-and-after-puzzle/solutions/5815767/java-using-hashmaps/
    //15min
    //Runtime
    //7
    //ms
    //Beats
    //90.00%
    //Analyze Complexity
    //Memory
    //44.46
    //MB
    //Beats
    //100.00%
    private List<String> beforeAndAfterPuzzles(String[] phrases) {
        // keyword -> <phrase, idx>
        Map<String, List<Pair>> map1 = new HashMap<>(), map2 = new HashMap<>();

        for (int i = 0; i < phrases.length; i++) {
            String[] split = phrases[i].split(" ");

            List<Pair> l = map1.get(split[split.length - 1]);
            if (l == null) {
                l = new ArrayList<>();
                map1.put(split[split.length - 1], l);
            }
            l.add(new Pair(phrases[i], i));

            l = map2.get(split[0]);
            if (l == null) {
                l = new ArrayList<>();
                map2.put(split[0], l);
            }
            l.add(new Pair(phrases[i], i));
        }

        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (String key : map1.keySet()) {
            List<Pair> list1 = map1.get(key);
            List<Pair> list2 = map2.get(key);
            if (list2 == null) continue;
            for (Pair first : list1) {
                for (Pair second : list2) {
                    if (first.idx != second.idx) {
                        sb.append(first.phrase);
                        int start = second.phrase.indexOf(" ");

                        if (start > 0) {
                            sb.append(" ");
                            sb.append(second.phrase.substring(start + 1));
                        }
                    }
                    if (sb.length() > 0) set.add(sb.toString());
                    sb.setLength(0);
                }
            }
        }
        List<String> res = new ArrayList<>(set);
        Collections.sort(res);
        return res;
    }
    private class Pair {
        String phrase;
        int idx;

        public Pair (String p, int i) {
            phrase = p;
            idx = i;
        }
    }

}
