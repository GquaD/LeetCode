package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem3926 {
    //40min

    //Runtime
    //120
    //ms
    //Beats
    //25.25%
    //Memory
    //134.06
    //MB
    //Beats
    //10.38%
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        //append all chunks
        //split by space symbol
        //trim all "-" in the beginning and end (while loop)

        //and/or split each word by "-"
        //then we'll get 2 types of cases:
        //  1: a word followed by a word
        //  2: a word followed by and empty string (consider as separate words)

        StringBuilder sb = new StringBuilder();
        for (String s: chunks) sb.append(s);
        String res = sb.toString().trim();
        String[] split = res.split(" ");

        for (int i = 0; i < split.length; i++) {
            split[i] = trimHyphens(split[i]);
        }

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < split.length; i++) {
            String[] spl = split[i].split("-");

            if (spl.length == 1) {
                map.put(spl[0], map.getOrDefault(spl[0], 0) + 1);
                continue;
            }

            String prev = "";
            sb.setLength(0);

            for (int j = 0; j < spl.length; j++) {
                String cur = spl[j];
                if (cur != "") sb.append(cur).append("-");
                if (cur == "" && prev != "") {
                    sb.setLength(sb.length() - 1);
                    map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
                    sb.setLength(0);
                }
                prev = cur;
            }

            if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            }
        }

        int[] arr = new int[queries.length];
        for (int i = 0; i < arr.length; i++) {
            Integer freq = map.get(queries[i]);
            if (freq != null) arr[i] = map.get(queries[i]);
        }

        return arr;
    }

    private String trimHyphens(String s) {
        if (s.length() <= 1) return s;
        int a = 0, b = s.length();

        while(a < b && s.charAt(a) == '-') a++;
        while(b >= 1 && b > a && s.charAt(b - 1) == '-') b--;

        return s.substring(a, b);
    }
}
