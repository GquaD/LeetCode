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

    static int[][] variationsOfStep = new int[][] {
            {2, 1},
            {-1, 2},
            {-1, -2},
            {-2, -1},
            {-2, 1},
            {2, -1},
            {1, -2},
            {1, 2},
    };

    static int minSteps;

    public static void main(String[] args) {
        solution(19, 36); //this case is successful
        int result = solution(0, 1);
        solution(10, 26);

    }

    private static int solution(int start, int end) {
        minSteps = 5;
        //find current position's coordinates
        int[] startPosition = getPositionNoLoop(start);
        //find end position's coordinates
        int[] endPosition = getPositionNoLoop(end);
        //step left method
        //check if step(y-2, x-1) exists

        //step right method
        countMinPossibleStep(startPosition[0], startPosition[1], endPosition[0], endPosition[1], startPosition[0], startPosition[1], 0, 0);
        System.out.println("minimal number of steps from " + start + " to " + end + " is " + minSteps);
        //recursive method should pass current position and number of steps, and end position
        //which is incremented with each step (recursion run)


        return 0;
    }

    private static void countMinPossibleStep(int yStart, int xStart, int yEnd, int xEnd, int yPrevious, int xPrevious, int variation, int countSteps) {
        //for (int i = 0; i < variationsOfStep.length; i++) {
        if (countSteps > minSteps) {
            return;
        }
        if (variation >= variationsOfStep.length -1) {
            return;
        }
            int yTemp = yStart + variationsOfStep[variation][0];
            int xTemp = xStart + variationsOfStep[variation][1];

            if (checkStepIsPossible(yTemp, xTemp) && !(yTemp == yPrevious && xTemp == xPrevious)) {
                ++countSteps;

                if (yTemp == yEnd && xTemp == xEnd) {
                    if (minSteps > countSteps) {
                        minSteps = countSteps;
                        return;
                    }
                }
                countMinPossibleStep(yTemp, xTemp, yEnd, xEnd, yStart, xStart, ++variation, countSteps);
            }
        //}
    }

    private static void countMinPossibleStep1(int yStart, int xStart, int yEnd, int xEnd, int yPrevious, int xPrevious, int countSteps) {
        for (int i = 0; i < variationsOfStep.length; i++) {
            int yTemp = yStart + variationsOfStep[i][0];
            int xTemp = xStart + variationsOfStep[i][1];
            if (checkStepIsPossible(yTemp, xTemp) && !(yTemp == yPrevious && xTemp == xPrevious) ) {
                System.out.print("[ step: y = " + yTemp + ", x = " + xTemp + " ");
                ++countSteps;
                if (yTemp == yEnd && xTemp == xEnd) {
                    if (minSteps > countSteps) {
                        System.out.println("\n!!!from " + minSteps + " decreased to " + countSteps);
                        minSteps = countSteps;
                        return;
                    }
                }
                if (countSteps > minSteps) {
                    System.out.println("\nminsteps = " + minSteps + " - no more than that");
                    continue;
                }
                countMinPossibleStep1(yTemp, xTemp, yEnd, xEnd, yStart, xStart, countSteps);
                System.out.print("]");
            } else {
                continue;
            }
        }
        System.out.println();
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

    private static boolean checkStepIsPossible(int y, int x) {
        try {
            int number = board[y][x];
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
