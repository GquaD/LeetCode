package LeetCode.easy;

public class Problem1165 {
    //https://leetcode.com/problems/single-row-keyboard/
    public static void main(String[] args) {
        System.out.println(calculateTime("abcdefghijklmnopqrstuvwxyz", "cba"));
        System.out.println(calculateTime("pqrstuvwxyzabcdefghijklmno", "leetcode"));
    }

    //https://leetcode.com/problems/single-row-keyboard/solutions/4837750/java-straightforward-solution/
    //5min
    //Runtime
    //7
    //ms
    //Beats
    //51.89%
    //of users with Java
    //Memory
    //41.81
    //MB
    //Beats
    //96.74%
    //of users with Java
    static int calculateTime(String keyboard, String word) {
        int res = 0, cur = 0;
        char[] k = keyboard.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            int idx = getIdx(k, word.charAt(i));
            res += Math.abs(idx - cur);
            cur = idx;
        }
        return res;
    }

    private static int getIdx(char[] k, char c) {
        for (int i = 0; i < 26; i++) {
            if (k[i] == c) return i;
        }
        return -1;
    }
}
