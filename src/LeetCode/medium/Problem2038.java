package LeetCode.medium;

public class Problem2038 {
    //https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/
    public static void main(String[] args) {
        System.out.println(winnerOfGame("AAAABBBB"));
    }

    //https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/solutions/3637844/java-greedy-o-n-solution/
    //Runtime
    //17 ms
    //Beats
    //78.60%
    //Memory
    //44.4 MB
    //Beats
    //22.94%
    static boolean winnerOfGame(String colors) {
        int currALen = 0, countAMoves = 0, currBLen = 0, countBMoves = 0;
        for (int i = 0; i < colors.length(); i++) {
            if (colors.charAt(i) == 'A') {
                currALen++;
                countBMoves += Math.max(currBLen - 2, 0);
                currBLen = 0;
            } else {
                countAMoves += Math.max(currALen - 2, 0);
                currALen = 0;
                currBLen++;
            }
        }
        if (currALen > 0) countAMoves += Math.max(currALen - 2, 0);
        if (currBLen > 0) countBMoves += Math.max(currBLen - 2, 0);

        return countAMoves > countBMoves;
    }

    //Runtime
    //21 ms
    //Beats
    //73.65%
    //Memory
    //44.1 MB
    //Beats
    //49.89%
    static boolean winnerOfGame1(String colors) {
        int currALen = 0, countAMoves = 0;
        int currBLen = 0, countBMoves = 0;
        for (int i = 0; i < colors.length(); i++) {
            if (colors.charAt(i) == 'A') {
                currALen++;
            } else {
                countAMoves += Math.max(currALen - 2, 0);
                currALen = 0;
            }
            if (colors.charAt(i) == 'B') {
                currBLen++;
            } else {
                countBMoves += Math.max(currBLen - 2, 0);
                currBLen = 0;
            }
        }
        if (currALen > 0) countAMoves += Math.max(currALen - 2, 0);
        if (currBLen > 0) countBMoves += Math.max(currBLen - 2, 0);

        return countAMoves > countBMoves;
    }
}
