package LeetCode.easy;

public class Problem1812 {
    //https://leetcode.com/problems/determine-color-of-a-chessboard-square/
    public static void main(String[] args) {
        System.out.println(squareIsWhite("a1"));
        System.out.println(squareIsWhite("a2"));
        System.out.println(squareIsWhite("h3"));
        System.out.println(squareIsWhite("c7"));
        System.out.println(squareIsWhite("f4"));
        System.out.println(squareIsWhite("h8"));
        System.out.println(squareIsWhite("c2"));
    }

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Determine Color of a Chessboard Square.
    //Memory Usage: 42.9 MB, less than 5.15% of Java online submissions for Determine Color of a Chessboard Square.
    static boolean squareIsWhite(String c) {
        int y = c.charAt(0) - 96;
        int x = c.charAt(1) - 47;
        if ((x % 2 != 0 && y % 2 == 0) || (x % 2 == 0 && y % 2 != 0)) {
            return false;
        }
        if ((x % 2 == 0 && y % 2 == 0) || (x % 2 == 1 && y % 2 == 1)) {
            return true;
        }
        return false;
    }
}
