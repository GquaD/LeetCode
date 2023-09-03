package LeetCode.medium;

public class Problem2840 {
    //https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-ii/
    public static void main(String[] args) {
        System.out.println(checkStrings("abcdba", "cabdab"));
        System.out.println(checkStrings("abe", "bea"));
    }

    //https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-ii/solutions/3997626/java-o-n-alphabet-array/
    //5-10 min
    //Runtime
    //5 ms
    //Beats
    //66.67%
    //Memory
    //44.5 MB
    //Beats
    //33.33%
    static boolean checkStrings(String s1, String s2) {
        int[] alph1 = new int[26], alph2 = new int[26], alph3 = new int[26], alph4 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            if (i % 2 == 0) {
                alph1[c1 - 'a']++;
                alph2[c2 - 'a']++;
            } else {
                alph3[c1 - 'a']++;
                alph4[c2 - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (alph1[i] != alph2[i] || alph3[i] != alph4[i]) return false;
        }
        return true;
    }
}
