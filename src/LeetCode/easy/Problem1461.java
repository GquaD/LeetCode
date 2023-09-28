package LeetCode.easy;

import java.util.HashSet;
import java.util.Set;

public class Problem1461 {
    //https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
    public static void main(String[] args) {
        System.out.println(hasAllCodes("00110", 2));
        System.out.println(hasAllCodes("00110110", 2));
    }


    //https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/solutions/4100760/java-o-n-hashset/
    //10 min
    //Runtime
    //121 ms
    //Beats
    //85.37%
    //Memory
    //67.6 MB
    //Beats
    //68.6%

    static boolean hasAllCodes1(String s, int k) {
        if (s.length() <= k) return false;
        Set<String> set = new HashSet<>();
        int check = (int) Math.pow(2, k);
        for (int i = 0; i < s.length() - k + 1; i++) {
            if (set.size() == check) return true;
            set.add(s.substring(i, i + k));
        }
        return set.size() == check;
    }


    //Runtime
    //199 ms
    //Beats
    //19.70%
    //Memory
    //67.7 MB
    //Beats
    //54.63%
    static boolean hasAllCodes(String s, int k) {
        if (s.length() <= k) return false;
        Set<String> set = new HashSet<>();
        int check = (int) Math.pow(2, k);
        StringBuilder sb = new StringBuilder();
        sb.append(s, 0, k);
        for (int i = k; i < s.length(); i++) {
            if (set.size() == check) return true;
            set.add(sb.toString());
            sb.replace(0, 1, "");
            sb.append(s.charAt(i));
        }
        set.add(sb.toString());
        return set.size() == check;
    }
}
