package LeetCode.medium;

public class Problem3215 {
    //https://leetcode.com/problems/count-triplets-with-even-xor-set-bits-ii/
    public static void main(String[] args) {
        System.out.println(tripletCount(new int[]{1}, new int[]{2}, new int[]{3}));
        System.out.println(tripletCount(new int[]{1,1}, new int[]{2,3}, new int[]{1,5}));
    }

    //tip
    //https://leetcode.com/problems/count-triplets-with-even-xor-set-bits-ii/solutions/5470726/java-o-n-solution/
    //10min
    //Runtime
    //11
    //ms
    //Beats
    //40.00%
    //Analyze Complexity
    //Memory
    //62.29
    //MB
    //Beats
    //100.00%
    static long tripletCount(int[] a, int[] b, int[] c) {
        long aeven = 0, aodd = 0, beven = 0, bodd = 0, ceven = 0, codd = 0;
        for (int n : a) {
            if (Integer.bitCount(n) % 2 == 0) aeven++;
            else aodd++;
        }
        for (int n : b) {
            if (Integer.bitCount(n) % 2 == 0) beven++;
            else bodd++;
        }
        for (int n : c) {
            if (Integer.bitCount(n) % 2 == 0) ceven++;
            else codd++;
        }
        long result = aeven * beven * ceven;
        result += aodd * bodd * ceven;
        result += aodd * codd * beven;
        result += bodd * codd * aeven;
        return result;
    }
}
