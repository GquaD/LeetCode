package LeetCode.medium;

import java.util.Arrays;

public class Problem567 {
    //https://leetcode.com/problems/permutation-in-string/description/
    public static void main(String[] args) {
        System.out.println(checkInclusion("adc", "dcda"));
        System.out.println(checkInclusion("ccc", "cbac"));
        System.out.println(checkInclusion("hello", "ooolleoooleh"));
        System.out.println(checkInclusion("ab", "ddbdadcd"));
        System.out.println(checkInclusion("ab", "ddbadcd"));
    }

    //https://leetcode.com/problems/permutation-in-string/solutions/3138993/java-using-alphabet-array/
    //20 min
    //Runtime
    //104 ms
    //Beats
    //26.35%
    //Memory
    //42.3 MB
    //Beats
    //72.87%
    static boolean checkInclusion(String s1, String s2) {
        int[] alph1 = new int[26];
        for (char c : s1.toCharArray()) alph1[c - 'a']++;
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            char c = s2.charAt(i);
            if (alph1[c - 'a'] != 0) {
                int[] tempAlph = Arrays.copyOf(alph1, alph1.length);
                int len = Math.min(i + s1.length(), s2.length());
                for (int j = i; j < len; j++) {
                    int idx = s2.charAt(j) - 'a';
                    if (tempAlph[idx] > 0) tempAlph[idx]--;
                    else break;
                }

                if (arrayAllZero(tempAlph)) return true;
            }
        }
        return false;
    }

    static boolean checkInclusion1(String s1, String s2) {
        int[] alph1 = new int[26];
        for (char c : s1.toCharArray()) alph1[c - 'a']++;
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            char c = s2.charAt(i);
            if (alph1[c - 'a'] != 0) {
                int[] tempAlph = Arrays.copyOf(alph1, alph1.length);
                boolean wasBroken = false;
                outerloop:
                while (!arrayAllZero(tempAlph)) {
                    int len = Math.min(i + s1.length(), s2.length() - s1.length());
                    for (int j = i; j < len; j++) {
                        int idx = s2.charAt(j) - 'a';
                        if (tempAlph[idx] > 0) {
                            tempAlph[idx]--;
                        } else {
                            wasBroken = true;
                            break outerloop;
                        }
                    }
                }
                if (!wasBroken) return true;
            }
        }
        return false;
    }

    private static boolean arrayAllZero(int[] arr) {
        for (int i = 0; i < arr.length; i++) if (arr[i] != 0) return false;
        return true;
    }
}
