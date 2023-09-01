package LeetCode.medium;

public class Problem2177 {
    //https://leetcode.com/problems/find-three-consecutive-integers-that-sum-to-a-given-number/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-three-consecutive-integers-that-sum-to-a-given-number/solutions/3988323/java-o-1-math-solution/
    //2 min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //41.1 MB
    //Beats
    //5.79%
    static long[] sumOfThree(long num) {
        long a = (num - 3) / 3, b = a + 1, c = a + 2;
        if (a + b + c == num) return new long[]{a, b, c};
        else return new long[]{};
    }
}
