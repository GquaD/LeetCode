package LeetCode.easy;

public class Problem3014 {
    //5min

    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Memory
    //43.01
    //MB
    //Beats
    //84.73%
    //https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i/solutions/8335693/java-fast-solution-by-tbekpro-5rld/
    public int minimumPushes(String word) {
        int len = word.length(), count = 8, result = 0;
        while (len-- > 0) result += count++ / 8;
        return result;
    }
}
