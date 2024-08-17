package LeetCode.easy;

import java.util.List;

public class Problem3248 {

    //https://leetcode.com/problems/snake-in-matrix


    //https://leetcode.com/problems/snake-in-matrix/solutions/5649990/java-o-n-solution/
    //2min
    //Runtime
    //2
    //ms
    //Beats
    //97.17%
    //Analyze Complexity
    //Memory
    //44.44
    //MB
    //Beats
    //45.27%
    public int finalPositionOfSnake(int n, List<String> commands) {
        int x = 0, y = 0;
        for (String s: commands) {
            if (s.equals("UP")) {
                y--;
            } else if (s.equals("RIGHT")) {
                x++;
            } else if (s.equals("DOWN")) {
                y++;
            } else {
                x--;
            }
        }
        return y * n + x;
    }
}
