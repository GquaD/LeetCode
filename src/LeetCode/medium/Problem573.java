package LeetCode.medium;

public class Problem573 {
    //https://leetcode.com/problems/squirrel-simulation
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/squirrel-simulation/solutions/5807773/java-o-n-solution-using-manhattan-distance/
    //15min
    //Runtime
    //7
    //ms
    //Beats
    //5.13%
    //Analyze Complexity
    //Memory
    //45.14
    //MB
    //Beats
    //38.46%
    static int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        //manhattan distance
        int res = 0;
        for (int i = 0; i < nuts.length; i++) {
            int toTree = (Math.abs(tree[0] - nuts[i][0]) + Math.abs(tree[1]- nuts[i][1]));
            res += 2 * toTree;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nuts.length; i++) {
            int toTree = (Math.abs(tree[0] - nuts[i][0]) + Math.abs(tree[1]- nuts[i][1]));
            int toNut = Math.abs(squirrel[0] - nuts[i][0]) + Math.abs(squirrel[1] - nuts[i][1]);
            min = Math.min(res - toTree + toNut, min);
        }
        return min;
    }
}
