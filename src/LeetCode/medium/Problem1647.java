package LeetCode.medium;

import java.util.Arrays;

public class Problem1647 {
    //https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
    public static void main(String[] args) {

    }


    //https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/solutions/3646310/java-alphabet-array-solution/
    //10 mins
    //Runtime
    //12 ms
    //Beats
    //68.85%
    //Memory
    //44.2 MB
    //Beats
    //44.78%
    static int minDeletions1(String s) {
        int[] alph = new int[26];
        for (int i = 0; i < s.length(); i++) alph[s.charAt(i) - 'a']++;
        Arrays.sort(alph);
        int count = 0;
        while (weHaveEqual(alph)) {
            for (int i = 0; i < alph.length - 1; i++) {
                if (alph[i] != 0 && alph[i] == alph[i + 1]) {
                    alph[i]--;
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean weHaveEqual(int[] alph) {
        for (int i = 0; i < alph.length - 1; i++) if (alph[i] != 0 && alph[i] == alph[i + 1]) return true;
        return false;
    }
}
