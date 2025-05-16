package LeetCode.easy;

public class Problem3046 {
    //https://leetcode.com/problems/split-the-array
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/split-the-array/solutions/6750054/java-simplest-solution-by-tbekpro-ijgl/
    //2min
    //Runtime
    //142
    //ms
    //Beats
    //3.48%
    //Analyze Complexity
    //Memory
    //42.56
    //MB
    //Beats
    //92.47%
    public boolean isPossibleToSplit(int[] nums) {
        int[] arr = new int[101];
        for (int n: nums) if (++arr[n] > 2) return false;
        return true;
    }
}
