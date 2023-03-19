package LeetCode.easy;

public class Problem2549 {
    //https://leetcode.com/problems/count-distinct-numbers-on-board/description/


    //https://leetcode.com/problems/count-distinct-numbers-on-board/solutions/3313925/java-1-line-100-faster-solution/
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //39.5 MB
    //Beats
    //23.68%
    static int distinctIntegers(int n) {
        return n != 1 ? n - 1 : 1;
    }
}
