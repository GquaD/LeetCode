package LeetCode.easy;

public class Problem3200 {
    //10min

    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Memory
    //42.88
    //MB
    //Beats
    //7.48%
    //https://leetcode.com/problems/maximum-height-of-a-triangle/solutions/8352726/java-100-fast-solution-by-tbekpro-9ccw/
    public int maxHeightOfTriangle(int red, int blue) {
        int max = 0, count = 0, r = red, b = blue;
        boolean turn = true;

        while (true) {
            if (turn) {
                if (count > r) break;
                r -= ++count;
            } else {
                if (count > b) break;
                b -= ++count;
            }
            turn = !turn;
        }

        max = Math.max(max, r < 0 || b < 0 ? count - 1 : count);
        r = red;
        b = blue;
        count = 0;
        turn = true;

        while (true) {
            if (turn) {
                if (count > b) break;
                b -= ++count;
            } else {
                if (count > r) break;
                r -= ++count;
            }
            turn = !turn;
        }

        return Math.max(max, r < 0 || b < 0 ? count - 1 : count);
    }
}
