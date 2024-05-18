package LeetCode.medium;

public class Problem3147 {
    //https://leetcode.com/problems/taking-maximum-energy-from-the-mystic-dungeon/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/taking-maximum-energy-from-the-mystic-dungeon/solutions/5174900/java-100-faster-solution/
    //10min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //58.77
    //MB
    //Beats
    //97.74%
    //of users with Java
    int maximumEnergy(int[] e, int k) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            int sum = 0;
            for (int j = e.length - 1 - i; j >= 0; j -= k) {
                sum += e[j];
                max = Math.max(sum, max);
            }
        }
        return max;
    }
}
