package LeetCode.hard;

public class Problem1526 {
    //https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/
    public static void main(String[] args) {
        System.out.println(minNumberOperations(new int[]{1,2,3,2,1}));
        System.out.println(minNumberOperations(new int[]{3,1,1,2}));
        System.out.println(minNumberOperations(new int[]{3,1,5,4,2}));
    }

    //https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/solutions/3637803/java-100-faster-3-lines-o-n-solution/
    //Runtime
    //3 ms
    //Beats
    //100%
    //Memory
    //55.5 MB
    //Beats
    //13.84%
    static int minNumberOperations(int[] target) {
        int count = target[0];
        for (int i = 1; i < target.length; i++) if (target[i - 1] < target[i]) count += target[i] - target[i - 1];
        return count;
    }
}
