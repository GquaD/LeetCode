package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Problem1268 {
    //https://leetcode.com/problems/search-suggestions-system/
    public static void main(String[] args) {
        LeetCodeUtils.printListWithListsOfStrings(suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad"}, "mouse"));
    }

    //https://leetcode.com/problems/search-suggestions-system/solutions/3442713/java-straightforward-solution/
    //10 min
    //Runtime
    //34 ms
    //Beats
    //56.68%
    //Memory
    //46 MB
    //Beats
    //69.52%
    static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            String s = searchWord.substring(0, i + 1);
            List<String> pq = new ArrayList<>();
            int idx = 0;
            while (pq.size() < 3 && idx < products.length) {
                if (products[idx].startsWith(s)) pq.add(products[idx]);
                idx++;
            }
            list.add(pq);
        }
        return list;
    }
}
