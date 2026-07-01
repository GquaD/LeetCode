package LeetCode.medium;

public class Problem3968 {
    //5min

    //Runtime
    //17
    //ms
    //Beats
    //62.26%
    //Memory
    //47.64
    //MB
    //Beats
    //88.29%
    //https://leetcode.com/problems/maximum-manhattan-distance-after-all-moves/solutions/8365923/java-simple-fast-solution-by-tbekpro-m8yk/
    public int maxDistance(String moves) {
        int ud = 0, lr = 0, s = 0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            switch (c) {
                case 'U' -> ud++;
                case 'D' -> ud--;
                case 'L' -> lr++;
                case 'R' -> lr--;
                default -> s++;
            }
        }

        return Math.abs(ud) + Math.abs(lr) + s;
    }
}
