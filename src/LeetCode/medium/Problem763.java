package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.*;

public class Problem763 {
    //https://leetcode.com/problems/partition-labels/
    public static void main(String[] args) {
        LeetCodeUtils.printList(partitionLabels("ababcbacadefegdehijhklij"));
        LeetCodeUtils.printList(partitionLabels("eccbbbbdec"));
    }

    //https://leetcode.com/problems/partition-labels/discuss/2586975/Java-Average-Solution
    //Runtime: 17 ms, faster than 13.17% of Java online submissions for Partition Labels.
    //Memory Usage: 43.3 MB, less than 18.23% of Java online submissions for Partition Labels.
    static List<Integer> partitionLabels(String s) {
        //char -> list of indexes
        Map<Character, List<Integer>> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.get(c).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(c, list);
            }
        }
        List<Integer> res = new ArrayList<>();
        int start = 0, end = 0;
        for (char key : map.keySet()) {
            List<Integer> idxs = map.get(key);
            int lastIdx = idxs.get(idxs.size() - 1);
            if (start < lastIdx && end < lastIdx && end < idxs.get(0)) {
                res.add(end - start + 1);
                start = idxs.get(0);
                end = lastIdx;
            } else if (start < lastIdx && end < lastIdx) {
                end = lastIdx;
            }
        }
        res.add(end - start + 1);
        return res;
    }
}
