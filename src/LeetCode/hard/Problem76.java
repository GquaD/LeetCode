package LeetCode.hard;

public class Problem76 {
    //https://leetcode.com/problems/minimum-window-substring
    public static void main(String[] args) {
        System.out.println("BANC".equals(minWindow("ADOBECODEBANC", "ABC")));
        System.out.println("a".equals(minWindow("a", "a")));
        System.out.println("".equals(minWindow("a", "aa")));
    }

    //https://leetcode.com/problems/minimum-window-substring/solutions/4676784/java-o-m-n-solution-sliding-window/
    //30min
    //Runtime
    //14
    //ms
    //Beats
    //60.07%
    //of users with Java
    //Memory
    //43.55
    //MB
    //Beats
    //93.12%
    //of users with Java
    static String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        int[] tt = new int['z' - 'A' + 1], alph = new int[tt.length];
        for (int i = 0; i < t.length(); i++) {
            tt[t.charAt(i) - 'A']++;
            alph[s.charAt(i) - 'A']++;
        }
        int start = 0, min = Integer.MAX_VALUE, a = 0, b = 0, i = t.length();
        for (; i < s.length(); i++) {
            while (isWindow(alph, tt)) {
                if (i - start < min) {
                    a = start;
                    b = i;
                    min = i - start;
                }
                alph[s.charAt(start) - 'A']--;
                start++;
            }
            alph[s.charAt(i) - 'A']++;
        }
        while (isWindow(alph, tt)) {
            if (i - start < min) {
                a = start;
                b = i;
                min = i - start;
            }
            alph[s.charAt(start) - 'A']--;
            start++;
        }
        return s.substring(a, b);
    }

    private static boolean isWindow(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (b[i] > 0 && a[i] < b[i]) return false;
        }
        return true;
    }
}
