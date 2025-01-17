package LeetCode.medium;

public class Problem2683 {
    //https://leetcode.com/problems/neighboring-bitwise-xor
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/neighboring-bitwise-xor/solutions/6294238/java-on-solution-by-tbekpro-up8d/
    //10min
    //Runtime
    //2
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //62.47
    //MB
    //Beats
    //40.59%
    public boolean doesValidArrayExist(int[] derived) {
        int res = 0;
        for (int i : derived) res ^= i;
        return res == 0;
    }
}
