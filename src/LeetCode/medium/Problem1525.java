package LeetCode.medium;

import java.util.HashSet;
import java.util.Set;

public class Problem1525 {
    //https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
    public static void main(String[] args) {
        System.out.println(numSplits("aacaba"));//2
        System.out.println(numSplits("aabcb"));//1
        System.out.println(numSplits("abcd"));//1
        System.out.println(numSplits("acbadbaada"));//2
    }

    //https://leetcode.com/problems/number-of-good-ways-to-split-a-string/solutions/3213300/java-alphabet-array-o-n-k-solution-explained/
    //10-15 min
    //Runtime
    //24 ms
    //Beats
    //45.2%
    //Memory
    //41.7 MB
    //Beats
    //99.67%
    static int numSplits(String s) {
        int[] alphL = new int[26], alphR = new int[26];
        for (int i = 0; i < s.length(); i++) alphR[s.charAt(i) - 'a']++;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            alphL[s.charAt(i) - 'a']++;
            alphR[s.charAt(i) - 'a']--;
            if (numOfDistinct(alphL) == numOfDistinct(alphR)) count++;
        }
        return count;
    }

    private static int numOfDistinct(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) if (arr[i] > 0) count++;
        return count;
    }

    /*static Set<Integer> indices;
    static int numSplits(String s) {
        indices = new HashSet<>();
        int count = split(s);
        count += split(new StringBuilder(s).reverse().toString());
        return count;
    }

    static int split(String s) {
        boolean[] letters = new boolean[26];
        int[] accum = new int[s.length()];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!letters[c - 'a']) {
                accum[i] = ++count;
                letters[c - 'a'] = true;
            } else {
                accum[i] = count;
            }
        }
        if (count % 2 == 0) count /= 2;
        else count = count / 2 + 1;
        int res = 0;
        for (int i = 0; i < accum.length; i++) {
            if (accum[i] == count && !indices.contains(i)) {
                res++;
                indices.add(i);
            }
        }
        return res;
    }*/
}
