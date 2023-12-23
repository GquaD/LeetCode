package LeetCode.easy;
import java.util.*;

public class Problem1496 {
    //https://leetcode.com/problems/path-crossing
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/path-crossing/solutions/4446655/java-hashset-o-n/
    //10min
    //Runtime
    //5 ms
    //Beats
    //42.95%
    //Memory
    //42.1 MB
    //Beats
    //6.17%
    static boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        int[] dir = new int[]{0, -1, 1, 0, 0, 1, -1, 0};
        int[] cur = new int[2];
        for (int i = 0; i < path.length(); i++) {
            String s = cur[0] + "_" + cur[1];
            if (set.contains(s)) return true;
            set.add(s);
            char c = path.charAt(i);
            switch (c) {
                case 'N': {
                    cur[0] += dir[0];
                    cur[1] += dir[1];
                    break;
                }
                case 'E': {
                    cur[0] += dir[2];
                    cur[1] += dir[3];
                    break;
                }
                case 'S': {
                    cur[0] += dir[4];
                    cur[1] += dir[5];
                    break;
                }
                default: {
                    cur[0] += dir[6];
                    cur[1] += dir[7];
                    break;
                }
            }
        }
        return set.contains(cur[0] + "_" + cur[1]);
    }
}
