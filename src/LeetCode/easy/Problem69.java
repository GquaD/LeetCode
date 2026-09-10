package LeetCode.easy;

public class Problem69 {
    //15min

    //Runtime
    //1
    //ms
    //Beats
    //99.05%
    //Memory
    //42.50
    //MB
    //Beats
    //61.30%
    public int mySqrt(int x) {
        //implement binary search
        if (x < 2) return x;

        long left = 1, right = x / 2, max = left;


        while (left <= right) {
            long mid = (left + right) / 2;

            if (mid * mid <= x) {
                max = Math.max(max, (int) mid);

                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (int)max;
    }
}
