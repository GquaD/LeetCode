package LeetCode.easy;

public class Problem859 {
    //https://leetcode.com/problems/buddy-strings/
    public static void main(String[] args) {

    }

    //10-15min
    //Runtime
    //7 ms
    //Beats
    //14.31%
    //Memory
    //41.4 MB
    //Beats
    //92.92%
    static boolean buddyStrings(String s, String goal) {
        if (s.length() == 1 || goal.length() == 1 || s.length() != goal.length()) return false;
        int count = 0, alph1[] = new int[26], alph2[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) count++;
            alph1[s.charAt(i) - 'a']++;
            alph2[goal.charAt(i) - 'a']++;
        }
        boolean hasMoreThan2 = false, allEqual = true;
        for (int f : alph1) if (f > 1) hasMoreThan2 = true;
        for (int i = 0; i < alph1.length; i++) {
            if (alph1[i] != alph2[i]) {
                allEqual = false;
                break;
            }
        }
        return count == 2 && allEqual || count == 0 && hasMoreThan2 && allEqual;
    }
}
