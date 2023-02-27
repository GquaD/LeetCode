package LeetCode.medium;

public class Problem201 {
    //https://leetcode.com/problems/bitwise-and-of-numbers-range
    public static void main(String[] args) {

    }

    //bitwise AND with n and n - 1 will always give number, less than n
    //so this is applied until right <= left
    //then just return left & right, since anyway (using all numbers from the range) we will come to this point
    //nnn
    //Runtime
    //6 ms
    //Beats
    //99.89%
    //Memory
    //42.4 MB
    //Beats
    //20.36%
    static int rangeBitwiseAnd(int left, int right) {
        while (right > left) right &= right - 1;
        return left & right;
    }
}
