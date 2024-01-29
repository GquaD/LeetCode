package LeetCode.medium;

import java.util.LinkedList;

public class Problem1750 {
    //https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/
    public static void main(String[] args) {
        System.out.println(minimumLength("ca"));
        System.out.println(minimumLength("cabaabac"));
        System.out.println(minimumLength("aabccabba"));
    }

    //https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/solutions/4643750/java-2-solutions-o-n-optimized-from-18ms-to-4ms/
    //10min
    //Runtime
    //4
    //ms
    //Beats
    //82.79%
    //of users with Java
    //Memory
    //44.70
    //MB
    //Beats
    //81.40%
    //of users with Java
    static int minimumLength(String s) {
        int n = s.length(), l = 0, r = n - 1;
        while (l < r) { //!!! <=
            char c = s.charAt(l);
            if (!(s.charAt(l) == c && s.charAt(r) == c)) break;
            while (l < r && s.charAt(l) == c) l++;
            while (r >= l && s.charAt(r) == c) r--;
        }
        return r - l + 1;
    }

    //
    //20min
    //Runtime
    //18
    //ms
    //Beats
    //7.44%
    //of users with Java
    //Memory
    //53.63
    //MB
    //Beats
    //6.98%
    //of users with Java
    static int minimumLength1(String s) {
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }
        boolean deletable = true;
        while (deletable && list.size() > 0) {
            char c = list.getFirst();
            if (list.size() == 1 || c != list.getLast()) break;
            while (list.size() > 0 && list.getFirst() == c) list.removeFirst();
            while (list.size() > 0 && list.getLast() == c) list.removeLast();
        }
        return list.size();
    }
}
