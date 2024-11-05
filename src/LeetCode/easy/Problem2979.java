package LeetCode.easy;

public class Problem2979 {
    //https://leetcode.com/problems/most-expensive-item-that-can-not-be-bought
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/most-expensive-item-that-can-not-be-bought/solutions/6010847/java-one-line-solution/
    //5min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //40.76
    //MB
    //Beats
    //78.38%
    public int mostExpensiveItem(int one, int two) {
        return one * two - (one + two);
    }
}
