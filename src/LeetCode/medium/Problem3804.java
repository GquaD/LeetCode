package LeetCode.medium;

public class Problem3804 {
    //10min

    //Runtime
    //244
    //ms
    //Beats
    //17.87%
    //Analyze Complexity
    //Memory
    //46.69
    //MB
    //Beats
    //87.10%
    public int centeredSubarrays(int[] nums) {
        int arr[] = new int[nums.length];
        arr[0] = nums[0];

        for (int i = 1; i < arr.length; i++) {
            arr[i] = nums[i] + arr[i - 1];
        }
        int count = nums.length;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = arr[j] - arr[i] + nums[i];
                for (int k = i; k <= j; k++) {
                    if (nums[k] == sum) {
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }

}
