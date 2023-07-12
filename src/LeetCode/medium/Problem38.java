package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem38 {
    //https://leetcode.com/problems/count-and-say/
    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
    }

    //https://leetcode.com/problems/count-and-say/solutions/3756427/java-array-as-a-cache-recursive-1ms-solution/
    //5min
    //Runtime
    //1 ms
    //Beats
    //99.37%
    //Memory
    //39.8 MB
    //Beats
    //98.51%
    static String[] arr;
    static StringBuilder sb;
    static String countAndSay(int n) {
        if (arr == null) generateArr();
        return arr[n];
    }

    private static void recursive(int n) {
        if (arr[n] != null) return;

        recursive(n - 1);
        String s = arr[n - 1];
        char prev = s.charAt(0);
        int count = 1;
        sb.setLength(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == prev) {
                count++;
            } else {
                sb.append(count);
                sb.append(prev);
                prev = s.charAt(i);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(prev);
        arr[n] = sb.toString();
    }

    private static void generateArr() {
        arr = new String[31];
        arr[1] = "1";
        sb = new StringBuilder();
        recursive(30);
    }

    //15min
    //Runtime
    //2 ms
    //Beats
    //98.60%
    //Memory
    //39.1 MB
    //Beats
    //100%
    static Map<Integer, String> map;
    static String countAndSay1(int n) {
        if (map == null) generateMap1();
        recursive1(n);
        return map.get(n);
    }

        private static void recursive1(int n) {
            if (map.containsKey(n)) return;

            recursive1(n - 1);
            String s = map.get(n - 1);
            StringBuilder sb = new StringBuilder();
            char prev = s.charAt(0);
            int count = 1;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == prev) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(prev);
                    prev = s.charAt(i);
                    count = 1;
                }
            }
            sb.append(count);
            sb.append(prev);
            map.put(n, sb.toString());
        }

        private static void generateMap1() {
            map = new HashMap<>();
            map.put(1, "1");
        }
}
