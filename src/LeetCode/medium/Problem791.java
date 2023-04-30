package LeetCode.medium;

import java.util.LinkedHashMap;

public class Problem791 {
    //https://leetcode.com/problems/custom-sort-string/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/custom-sort-string/solutions/3469052/java-2ms-linkedhashmap-solution/
    //5-10min
    //Runtime
    //2 ms
    //Beats
    //65.23%
    //Memory
    //41 MB
    //Beats
    //36.68%
    static String customSortString(String order, String s) {
        LinkedHashMap<Character, StringBuilder> map = new LinkedHashMap<>();
        StringBuilder sbUnordered = new StringBuilder();
        for (int i = 0; i < order.length(); i++) map.put(order.charAt(i), new StringBuilder());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) map.get(c).append(c);
            else sbUnordered.append(c);
        }
        StringBuilder sb = new StringBuilder();
        for (char key : map.keySet()) sb.append(map.get(key));
        return sb.append(sbUnordered).toString();
    }
}
