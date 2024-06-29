package LeetCode.medium;

import java.util.Arrays;

public class Problem2268 {
    //https://leetcode.com/problems/minimum-number-of-keypresses/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimum-number-of-keypresses/solutions/5387208/java-o-n-solution/
    //5-10min
    //Runtime
    //6
    //ms
    //Beats
    //57.34%
    //Analyze Complexity
    //Memory
    //44.48
    //MB
    //Beats
    //85.46%
    public int minimumKeypresses(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        Pair[] arrp = new Pair[26];
        for (int i = 0; i < 26; i++) {
            arrp[i] = new Pair(i, arr[i]);
        }

        Arrays.sort(arrp, (a, b) -> b.freq - a.freq);
        int sum = 0, count = 0;
        for (Pair p : arrp) {
            if (p.freq == 0) break;
            int coef = count++ / 9 + 1;
            sum += p.freq * coef;
        }
        return sum;
    }
    private class Pair {
        int idx, freq;

        public Pair(int i, int v) {
            idx = i;
            freq = v;
        }
    }
}

