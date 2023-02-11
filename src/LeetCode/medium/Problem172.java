package LeetCode.medium;

public class Problem172 {
    //https://leetcode.com/problems/factorial-trailing-zeroes/
    public static void main(String[] args) {

    }


    //https://leetcode.com/problems/factorial-trailing-zeroes/solutions/3171030/java-100-faster-solution/
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //39.1 MB
    //Beats
    //94.9%
    static int trailingZeroes(int n) {
        int result = 0;
        if (n >= 5) result += n / 5;
        if (n >= 25) result += n / 25;
        if (n >= 125) result += n / 125;
        if (n >= 625) result += n / 625;
        if (n >= 3125) result += n / 3125;
        return result;
    }
    static int trailingZeroes1(int n) {
        int temp = n, count = 0;
        while (temp % 5 == 0 && temp > 0) {
            count++;
            temp /= 5;
        }
        return (n / 5) + count - 1;
    }
}
