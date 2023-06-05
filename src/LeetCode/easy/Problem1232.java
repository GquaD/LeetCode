package LeetCode.easy;

public class Problem1232 {
    //https://leetcode.com/problems/check-if-it-is-a-straight-line/description/
    public static void main(String[] args) {
        System.out.println(checkStraightLine(new int[][]{{0,0},{0,1},{0,-1}}));
        System.out.println(checkStraightLine(new int[][]{{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}}));
    }

    //30 min
    //nnnn
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //43.2 MB
    //Beats
    //11.63%
    static boolean checkStraightLine(int[][] c) {
        if (c.length == 2) return true;
//        for (int i = 0; i < c.length; i++) if (!onOneLine(c[i], c[0], c[1])) return false;
        for (int i = 0; i < c.length; i++) if ((c[i][1] - c[0][1]) * (c[1][0] - c[0][0]) != (c[1][1] - c[0][1]) * (c[i][0] - c[0][0])) return false;
        return true;
    }

    private static boolean onOneLine(int[] p1, int[] p2, int[] p3) {
        int x = p1[0], y = p1[1], x1 = p2[0], y1 = p2[1], x2 = p3[0], y2 = p3[1];
        return (y - y1) * (x2 - x1) == (y2 - y1) * (x - x1);
    }


    static boolean checkStraightLine3(int[][] c) {
        if (c.length == 2) return true;
        boolean y = c[0][0] == 0, x = c[0][1] == 0;
        if (y) {
            for (int i = 0; i < c.length; i++) if (c[i][0] != 0) return false;
            return true;
        } else if (x) {
            for (int i = 0; i < c.length; i++) if (c[i][1] != 0) return false;
            return true;
        } else {
            int diffX = c[0][0] == 0 ? Integer.MAX_VALUE : c[1][0] / c[0][0];
            int diffY = c[0][1] == 0 ? Integer.MAX_VALUE : c[1][1] / c[0][1];
            for (int i = 2; i < c.length; i++) {
                int diffX1 = c[0][0] == 0 ? Integer.MAX_VALUE : c[i][0] / c[0][0];
                int diffY1 = c[0][1] == 0 ? Integer.MAX_VALUE : c[i][1] / c[0][1];
                if (diffX != diffX1 || diffY != diffY1) return false;
            }
            return true;
        }
    }

    static boolean checkStraightLine2(int[][] c) {
        if (c.length == 2) return true;
        boolean y = c[0][0] == 0, x = c[0][1] == 0;
        if (y) {
            for (int i = 0; i < c.length; i++) if (c[i][0] != 0) return false;
            return true;
        } else if (x) {
            for (int i = 0; i < c.length; i++) if (c[i][1] != 0) return false;
            return true;
        } else {
            double diff = (c[0][1] - c[0][0]) == 0 ? 0 : ((c[1][1] - c[0][1])) / (c[0][1] - c[0][0]);
            for (int i = 1; i < c.length; i++)
                if ((c[i][0] - c[0][0]) == 0 || ((c[i][1] - c[0][1])) / (c[i][0] - c[0][0]) != diff) return false;
            return true;
        }
    }


    static boolean checkStraightLine1(int[][] c) {
        if (c.length == 2) return true;
        int diff = c[0][1] - c[0][0];
        boolean y = c[0][0] == 0, x = c[0][1] == 0;
        if (y) {
            for (int i = 0; i < c.length; i++) if (c[i][0] != 0) return false;
            return true;
        } else if (x) {
            for (int i = 0; i < c.length; i++) if (c[i][1] != 0) return false;
            return true;
        } else {
            for (int i = 1; i < c.length; i++) if (c[i][1] - c[i][0] != diff) return false;
            return true;
        }
    }
}
