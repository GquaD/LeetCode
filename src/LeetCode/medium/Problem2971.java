package LeetCode.medium;
import java.util.*;

public class Problem2971 {
    //https://leetcode.com/problems/find-polygon-with-the-largest-perimeter/description/
    public static void main(String[] args) {

    }


    //https://leetcode.com/problems/find-polygon-with-the-largest-perimeter/solutions/4452718/java-o-nlogn-100-faster-solution/
    //5min
    //Runtime
    //29 ms
    //Beats
    //100%
    //Sorry, there are not enough accepted submissions to show data
    //Memory
    //56.5 MB
    //Beats
    //100%
    static long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
        for(int n : nums) {
            sum += n;
        }

        for (int i = nums.length - 1; i >= 2; i--) {
            if (sum - nums[i] > nums[i]) {
                return sum;
            } else {
                sum -= nums[i];
            }
        }
        return -1;
    }
}
