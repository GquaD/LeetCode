package LeetCode.medium;

import java.util.*;

public class Problem1604 {
    //https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/solutions/5881685/java-o-nlogn-solution/
    //10-15min
    //Runtime
    //66
    //ms
    //Beats
    //75.45%
    //Analyze Complexity
    //Memory
    //65.06
    //MB
    //Beats
    //68.23%
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            List<Integer> l = map.get(keyName[i]);
            if (l == null) {
                l = new ArrayList<>();
                map.put(keyName[i], l);
            }
            l.add(parseToInt(keyTime[i]));
        }
        List<String> res = new ArrayList<>();
        for (String key: map.keySet()) {
            List<Integer> list = map.get(key);
            if (list.size() > 2) {
                Collections.sort(list);
                for (int i = 0; i < list.size() - 2; i++) {
                    int a = list.get(i), b = list.get(i + 2);
                    if (b - a <= 60) {
                        res.add(key);
                        break;
                    }
                }
            }
        }
        Collections.sort(res);
        return res;
    }

    private int parseToInt(String s) {
        String[] split = s.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}
