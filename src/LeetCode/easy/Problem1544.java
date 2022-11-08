package LeetCode.easy;

public class Problem1544 {
    //https://leetcode.com/problems/make-the-string-great/
    public static void main(String[] args) {
        System.out.println(makeGood("leEeetcode"));
        System.out.println(makeGood("abBAcC"));
        System.out.println(makeGood("qFxXfQo"));
    }

    //https://leetcode.com/problems/make-the-string-great/solutions/2791757/java-2-solutions-from-42-to-99-time/
    //Runtime
    //2 ms
    //Beats
    //98.79%
    //Memory
    //42 MB
    //Beats
    //89.62%
    static String makeGood(String s) {
        int idx = 0, diff = Math.abs('a' - 'A');
        while (idx + 1 < s.length()) {
            char p = s.charAt(idx), n = s.charAt(idx + 1);
            if (Math.abs(n - p) == diff) {
                s = s.substring(0, idx) + s.substring(idx + 2);
                idx = Math.max(idx - 1, 0);
            } else {
                idx++;
            }
        }
        return s;
    }

    //30 mins
    //Runtime
    //7 ms
    //Beats
    //41.61%
    //Memory
    //43.9 MB
    //Beats
    //5.71%
    static String makeGood2(String s) {
        while (hasTwoAdjacent(s)) {
            s = makeGoodRecursively(s, 0);
        }
        return s;
    }

    private static boolean hasTwoAdjacent(String s) {
        for (int i = 1; i < s.length(); i++) {
            char p = s.charAt(i - 1), n = s.charAt(i);
            int diff = 'a' - 'A';
            if (Math.abs(n - p) == diff) {
                return true;
            }
        }
        return false;
    }

    private static String makeGoodRecursively(String s, int idx) {
        if (s.length() == 0) return "";
        if (s.length() == 1) return s;
        if (idx + 1 >= s.length()) return s;

        char p = s.charAt(idx), n = s.charAt(idx + 1);

        if (Math.abs(n - p) == Math.abs('a' - 'A')) {
            if (s.length() > 2) {
                s = s.substring(0, idx) + s.substring(idx + 2);
            } else if (s.length() == 2) {
                s = "";
            }
        }
        return makeGoodRecursively(s, idx + 1);
    }

    static String makeGood1(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            char p = s.charAt(i - 1), n = s.charAt(i);
            int diff = 'a' - 'A';
            if (Math.abs(n - p) != diff) {
                sb.append(p);
            } else {
                i++;
            }
        }
        return sb.toString();
    }
}
