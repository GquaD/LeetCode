package LeetCode.easy;

public class Problem1009 {
    //https://leetcode.com/problems/complement-of-base-10-integer/
    public static void main(String[] args) {
        System.out.println(bitwiseComplement(5));
        System.out.println(bitwiseComplement(7));
    }

    //https://leetcode.com/problems/complement-of-base-10-integer/solutions/2903419/java-o-1-1-line-solution/
    //5-10min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //39.3 MB
    //Beats
    //85.5%
    static int bitwiseComplement(int n) {
        return n ^ ((1 << Integer.toBinaryString(n).length()) - 1);
    }
}
