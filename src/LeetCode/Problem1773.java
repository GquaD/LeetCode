package LeetCode;

import java.util.List;

public class Problem1773 {
    //https://leetcode.com/problems/count-items-matching-a-rule/
    public static void main(String[] args) {

    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int type = 0;
        int color = 1;
        int name = 2;
        int countRuleMatches = 0;
        for (List<String> item : items) {
            if (ruleKey.equals("type")) {
                if (item.get(type).equals(ruleValue)) {
                    countRuleMatches++;
                }
            } else if (ruleKey.equals("color")) {
                if (item.get(color).equals(ruleValue)) {
                    countRuleMatches++;
                }
            } else {
                if (item.get(name).equals(ruleValue)) {
                    countRuleMatches++;
                }
            }
        }
        return countRuleMatches;
    }

    public static int countMatches1(List<List<String>> items, String k, String v) {
        int count = 0;

        for (List<String> i : items) {
            if (k.equals("type")) {
                if (i.get(0).equals(v)) {
                    count++;
                }
            } else if (k.equals("color")) {
                if (i.get(1).equals(v)) {
                    count++;
                }
            } else {
                if (i.get(2).equals(v)) {
                    count++;
                }
            }
        }
        return count;
    }
}
