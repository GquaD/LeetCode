package LeetCode.medium;

public class Problem2256 {
    //https://leetcode.com/problems/minimum-average-difference/
    public static void main(String[] args) {
        System.out.println(minimumAverageDifference(new int[]{65536,65536,65536,65536,65536,65536,65536,65536,65536,65536,65536,65536,65536,65536,65536,65536,65536,65536,65536, 0, 0, 0}));
        System.out.println(minimumAverageDifference(new int[]{2, 5, 3, 9, 5, 3}));
        System.out.println(minimumAverageDifference(new int[]{0}));
    }

    //https://leetcode.com/problems/minimum-average-difference/solutions/2876085/java-from-13-to-96-faster-2-solutions/
    //1 hour
    //Runtime
    //17 ms
    //Beats
    //95.63%
    //Memory
    //62.5 MB
    //Beats
    //84.93%
    static int minimumAverageDifference(int[] nums) {
        long sumLeft = 0;
        for (int n : nums) sumLeft += n;
        long sumIncr = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            sumIncr += nums[i];
            sumLeft -= nums[i];
            nums[i] = (int) Math.abs((sumIncr / (i + 1)) - (sumLeft / (nums.length - i - 1)));
        }
        sumIncr += nums[nums.length - 1];
        nums[nums.length - 1] = (int)(sumIncr / nums.length);
        int min = Integer.MAX_VALUE, idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
                idx = i;
            }
        }
        return idx;
    }

    //
    //30-40min
    //Runtime
    //33 ms
    //Beats
    //13.97%
    //Memory
    //82.2 MB
    //Beats
    //5.68%
    static int minimumAverageDifference2(int[] nums) {
        long[] avgsLeft = new long[nums.length];
        long sumOne = 0;
        for (int i = 0; i < nums.length; i++) {
            sumOne += nums[i];
            avgsLeft[i] = sumOne / (i + 1);
        }

        long[] avgsRight = new long[nums.length];
        long sumTwo = 0, count = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            sumTwo += nums[i + 1];
            avgsRight[i] = sumTwo / (count++);
        }

        long min = Integer.MAX_VALUE;
        int idx = 0;

        for (int i = 0; i < avgsLeft.length; i++) {
            avgsLeft[i] = Math.abs(avgsLeft[i] - avgsRight[i]);
            if (min > avgsLeft[i]) {
                min = avgsLeft[i];
                idx = i;
            }
        }
        return idx;
    }

    //time limit on 60/78
    static int minimumAverageDifference1(int[] nums) {
        int[] avgs = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int sumOne = 0;
            for (int j = 0; j <= i; j++) {
                sumOne += nums[j];
            }
            sumOne /= i + 1;
            int sumTwo = 0;
            for (int j = i + 1; j < nums.length; j++) {
                sumTwo += nums[j];
            }
            if (nums.length - i - 1 != 0)
                sumTwo /= nums.length - i - 1;
            else sumTwo = 0;

            avgs[i] = Math.abs(sumOne - sumTwo);
        }

        int min = Integer.MAX_VALUE, idx = 0;
        for (int i = 0; i < avgs.length; i++) {
            if (min > avgs[i]) {
                min = avgs[i];
                idx = i;
            }
        }
        return idx;
    }
}
