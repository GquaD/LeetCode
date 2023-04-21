package LeetCode.easy;

public class Problem2643 {
    //https://leetcode.com/problems/row-with-maximum-ones/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/row-with-maximum-ones/solutions/3439826/java-o-n-99-97-faster-solution/
    //3 min
    //Runtime
    //2 ms
    //Beats
    //99.97%
    //Memory
    //44.2 MB
    //Beats
    //77.64%
    static int[] rowAndMaximumOnes(int[][] mat) {
        int[] res = new int[2];
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                count += mat[i][j];
            }
            if (res[1] < count) {
                res[0] = i;
                res[1] = count;
            }
        }
        return res;
    }
}
