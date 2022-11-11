package LeetCode.easy;

public class Problem231 {
    //https://leetcode.com/problems/power-of-two/

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(-2));
        System.out.println(isPowerOfTwo(2));
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(4096));
    }




    //5 mins
    //Runtime
    //2 ms
    //Beats
    //82.54%
    //Memory
    //41.1 MB
    //Beats
    //61.66%
    static int[] values = new int[32];
    static boolean isPowerOfTwo(int n) {
        if (n < 1) return false;
        if (values[0] == 0) {
            fillValues();
        }
        for (int v : values) {
            if (n == v) return true;
        }
        return false;
    }

    private static void fillValues() {
        int mult = 1;
        for (int i = 0; i < values.length; i++) {
            values[i] = mult;
            mult *= 2;
        }
    }
}
