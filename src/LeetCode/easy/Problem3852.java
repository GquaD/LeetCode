package LeetCode.easy;

public class Problem3852 {
    //5min

    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //46.70
    //MB
    //Beats
    //85.96%
    public int[] minDistinctFreqPair(int[] nums) {
        int[] arr = new int[101];

        for (int n: nums) arr[n]++;
        int one = 0, freq = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > 0) {
                one = i;
                freq = arr[i];
                break;
            }
        }

        int two = 0;

        for (int i = one + 1; i < arr.length; i++) {
            if (arr[i] > 0 && freq != arr[i]) {
                two = i;
                break;
            }
        }

        return one == 0 || two == 0 ? new int[]{-1, -1} : new int[]{one, two};
    }

}
