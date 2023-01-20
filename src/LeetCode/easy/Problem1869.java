package LeetCode.easy;

public class Problem1869 {
    //https://leetcode.com/problems/longer-contiguous-segments-of-ones-than-zeros/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/longer-contiguous-segments-of-ones-than-zeros/solutions/3076351/java-o-n-solution/
    //15 min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //40.3 MB
    //Beats
    //73.55%
    static boolean checkZeroOnes(String s) {
        int count0 = 0, count1 = 0, max0 = 0, max1 = 0;
        char one = '1';
        for (char c : s.toCharArray()) {
            if(c == one) {
                max1 = Math.max(max1, ++count1);
                count0 = 0;
            } else {
                max0 = Math.max(max0, ++count0);
                count1 = 0;
            }
        }
        return max1 > max0;
    }
}
