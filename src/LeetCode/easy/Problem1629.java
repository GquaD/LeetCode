package LeetCode.easy;

public class Problem1629 {
    //https://leetcode.com/problems/slowest-key/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/slowest-key/solutions/3698494/java-o-n-solution/
    //5-10 min
    //Runtime
    //1 ms
    //Beats
    //89.29%
    //Memory
    //43.7 MB
    //Beats
    //50.65%
    static char slowestKey(int[] releaseTimes, String keysPressed) {
        char c = 'a';
        int max = 0, prev = 0;
        for (int i = 0; i < releaseTimes.length; i++) {
            int t = releaseTimes[i] - prev;
            prev = releaseTimes[i];
            if (max < t) {
                c = keysPressed.charAt(i);
                max = t;
            } else if (max == t) {
                c = keysPressed.charAt(i) > c ? keysPressed.charAt(i) : c;
            }
        }
        return c;
    }

    //Runtime
    //2 ms
    //Beats
    //20.45%
    //Memory
    //43.9 MB
    //Beats
    //13.31%
    static char slowestKey1(int[] releaseTimes, String keysPressed) {
        int prev = 0;
        int alph[] = new int[26];
        for (int i = 0; i < releaseTimes.length; i++) {
            char c = keysPressed.charAt(i);
            int t = releaseTimes[i] - prev;
            prev = releaseTimes[i];
            alph[c - 'a'] = Math.max(alph[c - 'a'], t);
        }
        char c = 'a';
        int max = 0;
        for (int i = 0; i < alph.length; i++) {
            if (max <= alph[i]) {
                max = alph[i];
                c = (char) ('a' + i);
            }
        }
        return c;
    }
}
