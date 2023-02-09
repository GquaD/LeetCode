package LeetCode.easy;


import java.util.ArrayList;
import java.util.List;

public class Problem2544 {
    //https://leetcode.com/problems/alternating-digit-sum/
    public static void main(String[] args) {
        System.out.println(alternateDigitSum(1_000_000_000));
    }

    //https://leetcode.com/problems/alternating-digit-sum/solutions/3162963/java-simple-100-faster-solution/
    //5 min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //39 MB
    //Beats
    //84.59%
    static int alternateDigitSum(int n) {
        int sum = 0, count = 0;
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            sum += count++ % 2 == 0 ? list.get(i) : -list.get(i);
        }
        return sum;
    }
}
