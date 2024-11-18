package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem293 {
    //https://leetcode.com/problems/flip-game
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/flip-game/solutions/6058275/java-o-n-solution/
    //2min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //42.50
    //MB
    //Beats
    //65.82%
    public List<String> generatePossibleNextMoves(String s) {
        char[] c = s.toCharArray();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            if (c[i] == '+' && c[i + 1] == '+') {
                c[i] = '-';
                c[i + 1] = '-';
                list.add(new String(c));
                c[i + 1] = '+';
                c[i] = '+';
            }
        }
        return list;
    }
}
