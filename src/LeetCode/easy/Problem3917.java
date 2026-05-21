package LeetCode.easy;

public class Problem3917 {
    //5min

    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Memory
    //46.84
    //MB
    //Beats
    //100.00%
    public int[] countOppositeParity(int[] nums) {
        int[] arr = new int[nums.length];
        int odd = 0, even = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i + 1] % 2 == 0) {
                even++;
            } else odd++;
            arr[i] = odd * 1000 + even;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] % 2 == 0) {
                arr[i] = arr[i] / 1000;
            } else arr[i] = arr[i] % 1000;
        }

        return arr;
    }
}
