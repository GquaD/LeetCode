package LeetCode.hard;

import java.util.HashMap;
import java.util.Map;

public class Problem87 {
    //https://leetcode.com/problems/scramble-string/
    public static void main(String[] args) {
        System.out.println(isScramble("great", "rgeat"));
        System.out.println(isScramble("great", "regat"));
        System.out.println(isScramble("abcde", "caebd"));
    }



    //nnnn
    //Runtime
    //9 ms
    //Beats
    //81.20%
    //Memory
    //43.7 MB
    //Beats
    //16.7%
    static boolean isScramble(String s1, String s2) {
        Map<String, Boolean> map = new HashMap<>();
        return isScramble(s1, s2, map);
    }

    static boolean isScramble(String s1, String s2, Map<String, Boolean> map) {
        if (s1.equals(s2)) return true;
        if (s1.length() == 1) return s1.charAt(0) == s2.charAt(0);
        int[] alph1 = new int[26], alph2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            alph1[s1.charAt(i) - 'a']++;
            alph2[s2.charAt(i) - 'a']++;
        }
        String key = s1 + "-" + s2;
        if (map.containsKey(key)) return map.get(key);

        for (int i = 0; i < alph1.length; i++) {
            if (alph1[i] != alph2[i]) {
                map.put(key, false);
                return map.get(key);
            }
        }
        boolean res = false;

        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i), map)
                    && isScramble(s1.substring(i), s2.substring(i), map)) {
                res = true;
                break;
            }
            if (isScramble(s1.substring(0, i), s2.substring(s1.length() - i), map)
                    && isScramble(s1.substring(i), s2.substring(0, s1.length() - i), map)) {
                res = true;
                break;
            }
        }
        map.put(key, res);
        return map.get(key);
    }

    //TLE 286/288
    static boolean isScramble2(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() == 1) return s1.charAt(0) == s2.charAt(0);
        int[] alph1 = new int[26], alph2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            alph1[s1.charAt(i) - 'a']++;
            alph2[s2.charAt(i) - 'a']++;
        }
        if (!arraysEqual(alph1, alph2)) return false;
        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i))) return true;
            if (isScramble(s1.substring(0, i), s2.substring(s1.length() - i))
                    && isScramble(s1.substring(i), s2.substring(0, s1.length() - i))) return true;
        }
        return false;
    }

        /*    static boolean isScrambled;
        static String toCompare;
        static boolean isScramble(String s1, String s2) {
            if (s1.length() == 1) return s1.charAt(0) == s2.charAt(0);
            isScrambled = false;
            toCompare = s2;
            checkRecursively(s1);
            return isScrambled;
        }

        private static String checkRecursively(String s1) {
            *//*if (s1.length() == toCompare.length()) {
            if (s1.equals(toCompare)) isScrambled = true;
            else set.add(s1);
            return;
        }

        for (int i = 0; i < s1.length(); i++) {

        }*//*
        String res = s1;
        for (int i = 1; i < s1.length(); i++) {
            String x = s1.substring(0, i), y = s1.substring(i);
            String ans = checkRecursively(y) + (checkRecursively(x));
            String ans2 = checkRecursively(x) + checkRecursively(y);
            if (ans.equals(toCompare)) return ans;
            if (ans2.equals(toCompare)) return ans2;
        }
        return res;
    }*/

    //242/288 fail
    //
    static boolean isScramble1(String s1, String s2) {
        if (s1.length() == 1) return s1.charAt(0) == s2.charAt(0);
        int[] alph1 = new int[26], alph2 = new int[26], alph2Back = new int[26], alph2Start = new int[26];
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            alph1[s1.charAt(i) - 'a']++;
            alph2[s2.charAt(i) - 'a']++;
            alph2Start[s2.charAt(i) - 'a']++;
        }
        if (!arraysEqual(alph1, alph2)) return false;
        int[] alph11 = new int[26], alph22 = new int[26];
        for (int i = 0; i < len; i++) {
            alph11[s1.charAt(i) - 'a']++;
            alph22[s2.charAt(i) - 'a']++;

            alph1[s1.charAt(i) - 'a']--;
            alph2[s2.charAt(i) - 'a']--;
            alph2Start[s2.charAt(len - i - 1) - 'a']--;
            alph2Back[s2.charAt(len - i - 1) - 'a']++;
            if (arraysEqual(alph11, alph22) && arraysEqual(alph1, alph2)
                    || arraysEqual(alph11, alph2Back) && arraysEqual(alph1, alph2Start)) return true;

        }
        return false;
    }

    private static boolean arraysEqual(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++)
            if (arr1[i] != arr2[i]) return false;
        return true;
    }

}
