package LeetCode.medium;

public class Problem1781 {
    //https://leetcode.com/problems/sum-of-beauty-of-all-substrings/
    public static void main(String[] args) {
        System.out.println(beautySum("aabcbaa"));
        System.out.println(beautySum("aabcb"));
    }

    //https://leetcode.com/problems/sum-of-beauty-of-all-substrings/solutions/4399879/java-straightforward-solution/
    //15 min
    //Runtime
    //852 ms
    //Beats
    //6.24%
    //Memory
    //40.3 MB
    //Beats
    //98.98%
    static int beautySum(String s) {
        int len = s.length(), sum = 0;
        int[] alph = new int[26];
        for (int i = 3; i <= len; i++) {
            for (int j = 0; j <= len - i; j++) {
                for (int k = j; k < j + i; k++) {
                    alph[s.charAt(k) - 'a']++;
                }
                int max = -1, min = Integer.MAX_VALUE;
                for (int k = 0; k < 26; k++) {
                    max = Math.max(max, alph[k]);
                    if (alph[k] != 0) min = Math.min(min, alph[k]);
                }
                refreshAlphabetArray(alph);
                if (min == Integer.MAX_VALUE) continue;
                sum += max - min;
            }
        }
        return sum;
    }

    private static void refreshAlphabetArray(int[] alph) {
        for (int i = 0; i < 26; i++) {
            alph[i] = 0;
        }
    }
}
