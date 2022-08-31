package LeetCode.medium;

import LeetCode.LeetCodeUtils;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;
import java.util.stream.Collectors;

public class Problem692 {
    //https://leetcode.com/problems/top-k-frequent-words/
    public static void main(String[] args) {
        LeetCodeUtils.printList(topKFrequent(new String[]{"i","love","leetcode","i","love","coding"}, 2));
        LeetCodeUtils.printList(topKFrequent(new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"}, 4));
    }

    //25 mins
    //Runtime: 17 ms, faster than 7.90% of Java online submissions for Top K Frequent Words.
    //Memory Usage: 45.4 MB, less than 35.44% of Java online submissions for Top K Frequent Words.
    static List<String> topKFrequent(String[] words, int k) {
        Map<String, Pair> map = new HashMap<>();
        for (String key : words) {
            if (map.containsKey(key)) {
                Pair pair = map.get(key);
                pair.frequency++;
            } else {
                Pair pair = new Pair();
                pair.word = key;
                pair.frequency++;
                map.put(key, pair);
            }
        }

        return map.values().stream()
                .sorted(Comparator.comparing(Pair::getFrequency).reversed().thenComparing(Pair::getWord))
                .limit(k)
                .map(pair -> pair.word)
                .collect(Collectors.toList());
    }

    static class Pair {
        public String word;
        public int frequency;

        public String getWord() {
            return word;
        }

        public int getFrequency() {
            return frequency;
        }
    }
}
