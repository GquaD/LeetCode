package LeetCode.easy;

public class Problem263 {
    //https://leetcode.com/problems/ugly-number/
    public static void main(String[] args) {
        System.out.println(isUgly(6));
        System.out.println(isUgly(17));
        System.out.println(isUgly(1));
    }

    //https://leetcode.com/problems/ugly-number/solutions/2823095/java-2ms-solution/
    //Runtime
    //2 ms
    //Beats
    //80.55%
    //Memory
    //40.9 MB
    //Beats
    //75.24%
    static boolean isUgly(int n) {
        if (n == 0) return false;
        while (true) {
            if (n % 2 == 0) {
                n /= 2;
                continue;
            } else if (n % 3 == 0) {
                n /= 3;
                continue;
            } else if (n % 5 == 0) {
                n /= 5;
                continue;
            }
            break;
        }
        return n == 1;
    }
}
