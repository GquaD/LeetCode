package LeetCode.easy;

public class Problem2833 {
    //https://leetcode.com/problems/furthest-point-from-origin/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/furthest-point-from-origin/solutions/5898909/java-100-faster-solution/
    //2min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //42.34
    //MB
    //Beats
    //56.72%
    public int furthestDistanceFromOrigin(String moves) {
        int countL = 0, countR = 0, empty = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'L') countL++;
            else if (moves.charAt(i) == 'R') countR++;
            else empty++;
        }
        return countL >= countR ? countL - countR + empty : countR - countL + empty;
    }
}
