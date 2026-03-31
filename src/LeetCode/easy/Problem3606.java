package LeetCode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem3606 {
    //10min

    //Runtime
    //7
    //ms
    //Beats
    //68.28%
    //Memory
    //47.05
    //MB
    //Beats
    //97.90%
    //https://leetcode.com/problems/coupon-code-validator/solutions/7730866/java-solution-by-tbekpro-q31d/
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        ArrayList<String>[] set = new ArrayList[4];
        String[] business = new String[]{"electronics", "grocery", "pharmacy", "restaurant"};

        for (int i = 0; i < code.length; i++) {
            String s = code[i];
            int bus = isBusiness(businessLine[i], business);
            if (validString(s) && isActive[i] && bus >= 0) {
                ArrayList<String> subset = set[bus];
                if (subset == null) {
                    subset = new ArrayList<>();
                    set[bus] = subset;
                }
                subset.add(s);
            }
        }

        List<String> result = new ArrayList<>();
        for (ArrayList<String> subset: set) {
            if (subset != null) {
                Collections.sort(subset);
                result.addAll(subset);
            }
        }

        return result;
    }

    private boolean validString(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9' || c == '_')) {
                return false;
            }
        }
        return s.length() != 0;
    }

    private int isBusiness(String b, String[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i].equals(b)) return i;
        }
        return -1;
    }
}
