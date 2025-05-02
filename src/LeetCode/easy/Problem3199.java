package LeetCode.easy;

public class Problem3199 {
    //https://leetcode.com/problems/count-triplets-with-even-xor-set-bits-i
    public static void main(String[] args) {

    }

    //5min
    //Runtime
    //77
    //ms
    //Beats
    //64.71%
    //Analyze Complexity
    //Memory
    //44.15
    //MB
    //Beats
    //88.24%
    public int tripletCount(int[] a, int[] b, int[] c) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                for (int k = 0; k < c.length; k++) {
                    if (Integer.bitCount(a[i] ^ b[j] ^ c[k]) % 2 == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
