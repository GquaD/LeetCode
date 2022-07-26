package LeetCode;

public class Problem657 {
    //https://leetcode.com/problems/robot-return-to-origin/
    public static void main(String[] args) {
        System.out.println(judgeCircle("UD"));
        System.out.println(judgeCircle("LL"));
        System.out.println(judgeCircle("URLD"));
    }

    //Runtime: 8 ms, faster than 51.28% of Java online submissions for Robot Return to Origin.
    //Memory Usage: 45 MB, less than 46.76% of Java online submissions for Robot Return to Origin.
    static boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if (c == 'U') {
                y--;
            } else if (c == 'D') {
                y++;
            } else if (c == 'R') {
                x++;
            } else {
                x--;
            }
        }
        return x == 0 && y == 0;
    }

    //Runtime: 10 ms, faster than 30.41% of Java online submissions for Robot Return to Origin.
    //Memory Usage: 45.1 MB, less than 40.73% of Java online submissions for Robot Return to Origin
    static boolean judgeCircle1(String moves) {
        int[] count = new int[4];
        //[ U, D, R, L ]
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if (c == 'U') {
                count[0]++;
            } else if (c == 'D') {
                count[1]++;
            } else if (c == 'R') {
                count[2]++;
            } else {
                count[3]++;
            }
        }

        return count[0] == count[1] && count[2] == count[3];
    }
}
