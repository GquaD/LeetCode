package LeetCode.medium;

public class Problem2439 {
    //https://leetcode.com/problems/minimize-maximum-of-array/description/
    public static void main(String[] args) {
        System.out.println(minimizeArrayValue(new int[]{3,7,1,500,0,16,1111,435}));
        System.out.println(minimizeArrayValue(new int[]{13,13,20,0,8,9,9}));
        System.out.println(minimizeArrayValue(new int[]{3,7,1,6}));
        System.out.println(minimizeArrayValue(new int[]{10,1}));
    }

    static int minimizeArrayValue2(int[] nums) {
        long sum = 0;
        for (int n : nums) sum += n;
        int avg = (int) Math.ceil((1.0 * sum) / nums.length);
        return nums[0] > sum - nums[0] ? nums[0] : avg;
    }


    //https://leetcode.com/problems/minimize-maximum-of-array/solutions/3381797/java-o-n-solution/
    //1 hour
    //Runtime
    //10 ms
    //Beats
    //41.58%
    //Memory
    //61.8 MB
    //Beats
    //64.87%
    static int minimizeArrayValue(int[] nums) {
        long sum = 0;
        for (int n : nums) sum += n;
        int avg = nums[0], redun = 0, max = nums[0];
        for (int i = nums.length - 1; i >= 0; i--) {
            avg = (int) Math.ceil((1.0 * sum) / (i + 1));
            sum -= nums[i];
            if (nums[i] >= avg) {
                redun += nums[i] - avg;
                nums[i] = avg;
            } else {
                int diff = avg - nums[i];
                if (redun >= diff) {
                    redun -= diff;
                    nums[i] = avg;
                } else {
                    redun = 0;
                    nums[i] += redun;
                }
            }
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    static int minimizeArrayValue1(int[] nums) {
        int max = 0;
        if (nums[0] >= nums[1]) max = nums[0];
        for (int i = nums.length - 1; i > 0; i--) {
            int a = nums[i - 1], b = nums[i];
            if (a < b) {
                int sum = a + b;
                if (sum % 2 == 0) {
                    nums[i] = nums[i - 1] = sum / 2;
                } else {
                    nums[i] = sum / 2 + 1;
                    nums[i - 1] = nums[i] - 1;
                }
                if (max < nums[i]) {
                    max = nums[i];
                }
            }
        }
        return max;
    }
}
