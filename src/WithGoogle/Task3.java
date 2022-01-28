package WithGoogle;

public class Task3 {
    //task to count number of minimal steps for a knight
    //on chessboard to reach end position from start position
    static int[][] board = new int[][] {
            { 0,  1,  2,  3,  4,  5,  6,  7},
            { 8,  9, 10, 11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20, 21, 22, 23},
            {24, 25, 26, 27, 28, 29, 30, 31},
            {32, 33, 34, 35, 36, 37, 38, 39},
            {40, 41, 42, 43, 44, 45, 46, 47},
            {48, 49, 50, 51, 52, 53, 54, 55},
            {56, 57, 58, 59, 60, 61, 62, 63}
    };

    public static void main(String[] args) {
        int result = solution(0, 1);

    }

    private static int solution(int start, int end) {
        //find current position's coordinates
        int[] startPosition = getPositionNoLoop(start);
        //find end position's coordinates
        int[] endPosition = getPositionNoLoop(end);
        //step left method
        //check if step(y-2, x-1) exists

        //step right method

        //recursive method should pass current position and number of steps, and end position
        //which is incremented with each step (recursion run)


        return 0;
    }

    private static int[] getPosition(int num) {
        int[] result = new int[2];// row, column
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == num) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    private static int[] getPositionNoLoop(int num) {
        int[] result = new int[2];// row, column or (y, x)
        int row = num / board.length;
        int column = num % board.length;
        result[0] = row;
        result[1] = column;
        return result;
    }

    private static int getNumFromPosition(int[] pos) {
        return getNumFromPosition(pos[0], pos[1]);
    }

    private static int getNumFromPosition(int y, int x) {
        try {
            return board[y][x];
        } catch (Exception e) {
            return -1;
        }
    }

    private static boolean stepExists(int[] position, int y, int x) {
        int yStart = position[0];
        int xStart = position[1];
        if (getNumFromPosition(y, x) == -1) {
            return false;
        }
        return false;
    }
}
