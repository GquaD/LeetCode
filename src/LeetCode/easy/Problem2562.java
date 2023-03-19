package LeetCode.easy;

public class Problem2562 {
    //https://leetcode.com/problems/find-the-array-concatenation-value/
    public static void main(String[] args) {
        System.out.println(findTheArrayConcVal(new int[]{5,14,13,8,12}));
    }

    //
    //Runtime
    //4 ms
    //Beats
    //60.10%
    //Memory
    //41.9 MB
    //Beats
    //69.80%
    static long findTheArrayConcVal(int[] nums) {
        if (nums.length == 1) return nums[0];
        long res = 0;
        int left = 0, right = nums.length - 1;
        StringBuilder sb = new StringBuilder();
        while (left < right) {
            sb.append(nums[left++]).append(nums[right--]);
            res += Long.parseLong(sb.toString());
            sb.setLength(0);
        }
        if (left == right) res += Long.parseLong(nums[left] + "");
        return res;
    }

    //5 min
    //Runtime
    //11 ms
    //Beats
    //13.71%
    //Memory
    //42.7 MB
    //Beats
    //7.61%
    static long findTheArrayConcVal1(int[] nums) {
        if (nums.length == 1) return nums[0];
        long res = 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            res += Long.parseLong(nums[left++] + "" + nums[right--]);
        }
        if (left == right) res += Long.parseLong(nums[left] + "");
        return res;
    }
}
