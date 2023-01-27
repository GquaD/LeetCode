package LeetCode.easy;

public class Problem2520 {
    //https://leetcode.com/problems/count-the-digits-that-divide-a-number/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/count-the-digits-that-divide-a-number/solutions/3104374/java-0ms-solution/
    //2 min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //40.6 MB
    //Beats
    //13.26%

    static int countDigits(int num) {
        int temp = num, count = 0;
        while (temp > 0) {
            if (num % (temp % 10) == 0) count++;
            temp /= 10;
        }
        return count;
    }
}
