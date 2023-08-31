package LeetCode.medium;

public class Problem2414 {
    //https://leetcode.com/problems/length-of-the-longest-alphabetical-continuous-substring/
    public static void main(String[] args) {
        System.out.println(longestContinuousSubstring("awy"));
        System.out.println(longestContinuousSubstring("zza"));
        System.out.println(longestContinuousSubstring("zzzzzz"));
        System.out.println(longestContinuousSubstring("aaa"));
        System.out.println(longestContinuousSubstring("abacaba"));
        System.out.println(longestContinuousSubstring("abcde"));
        System.out.println(longestContinuousSubstring("bcde"));
    }

    private static String alph = "abcdefghijklmnopqrstuvwxyz";


    //https://leetcode.com/problems/length-of-the-longest-alphabetical-continuous-substring/solutions/3984461/java-from-134ms-to-11ms/
    //20min
    //Runtime
    //11 ms
    //Beats
    //82.67%
    //Memory
    //44 MB
    //Beats
    //93.7%
    static int longestContinuousSubstring(String s) {
        int count = 1, max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i) - 1)
                max = Math.max(++count, max);
            else
                count = 1;
        }
        return Math.max(max, count);
    }

    //Runtime
    //134 ms
    //Beats
    //5.20%
    //Memory
    //44.3 MB
    //Beats
    //60.64%
    static int longestContinuousSubstring2(String s) {
        int count = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < alph.length(); j++) {
                if (s.charAt(i) == alph.charAt(j)) {
                    count++;
                    if (!(i + 1 < s.length() && j + 1 < alph.length() && s.charAt(i + 1) == alph.charAt(j + 1))) {
                        max = Math.max(max, count);
                        count = 0;
                        break;
                    }
                }
            }
        }
        return Math.max(max, count);
    }

    static int longestContinuousSubstring1(String s) {
        int currIdx = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = currIdx; j < alph.length(); j++) {
                if (s.charAt(i) == alph.charAt(j)) {
                    currIdx++;
                    if (s.charAt(i) == 'z') {
                        max = Math.max(max, currIdx);
                        currIdx = 0;
                    }
                    break;
                }
                if (j == alph.length() - 1) {
                    max = Math.max(max, currIdx);
                    currIdx = 0;
                    i--;
                }
            }
        }
        return Math.max(max, currIdx);
    }
}
