package WithGoogle;

import java.util.Arrays;

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

    static int[][] visited;
    static int[][] visitsNumber;

    static int[][] variationsOfStep = new int[][] {
            {-1, 2},
            {-1, -2},
            {2, 1},
            {-2, -1},
            {-2, 1},
            {2, -1},
            {1, -2},
            {1, 2},
    };

    static int minSteps;
    static Stack stack;

    public static void main(String[] args) {
        /*solution(10, 26);
        print2dArray(visitsNumber);*/

        /*solution(19, 36); //this case is successful
        print2dArray(visitsNumber);*/

        solution(0, 1);
//        print2dArray(visited);
//        System.out.println("Visits number below: ");
        print2dArray(visitsNumber);
    }

    private static void print2dArray(int[][] visitsNumber) {
        for (int i = 0; i < visitsNumber.length; i++) {
            System.out.println(Arrays.toString(visitsNumber[i]));
        }
    }

    private static int solution(int start, int end) {
        minSteps = 10;
        visited = new int[8][8];
        visitsNumber = new int[8][8];
        //find current position's coordinates
        int[] startPosition = getPositionNoLoop(start);

        visited[startPosition[0]][startPosition[1]] = 1;
        //find end position's coordinates
        int[] endPosition = getPositionNoLoop(end);
        //step left method
        //check if step(y-2, x-1) exists
        stack = new Stack();
        //step right method
        countMinPossibleStep2(startPosition[0], startPosition[1], endPosition[0], endPosition[1]);
        System.out.println("minimal number of steps from " + start + " to " + end + " is " + visitsNumber[endPosition[0]][endPosition[1]]);
        //recursive method should pass current position and number of steps, and end position
        //which is incremented with each step (recursion run)

        //add visited 2d array
        //set first position as visited
        //add primitive stack structure
        stack = null;

        return 0;
    }

    private static void countMinPossibleStep(int yStart, int xStart, int yEnd, int xEnd, int countSteps) {
        countSteps++;
        if (!checkStepIsPossible(yStart, xStart)) return;
        for (int i = 0; i < variationsOfStep.length; i++) {
            if (countSteps >= minSteps) {
                return;
            }
            int yTemp = yStart + variationsOfStep[i][0];
            int xTemp = xStart + variationsOfStep[i][1];

            if (checkStepIsPossible(yTemp, xTemp) && !(visited[yTemp][xTemp] == 1)) {
                visitsNumber[yTemp][xTemp] = visitsNumber[yTemp][xTemp] == 0 || visitsNumber[yTemp][xTemp] > countSteps ? countSteps : visitsNumber[yTemp][xTemp];
//                countSteps++;
                if (yTemp == yEnd && xTemp == xEnd) {
                    if (minSteps > countSteps) {
                        minSteps = countSteps;
                        return;
                    }
                }
                Node current = new Node(yTemp, xTemp);
                stack.add(current);
                visited[yTemp][xTemp] = 1;
                //countMinPossibleStep(yTemp, xTemp, yEnd, xEnd, countSteps);
            }
        }

        for (int i = 0; i < variationsOfStep.length; i++) {
            int yTemp = yStart + variationsOfStep[i][0];
            int xTemp = xStart + variationsOfStep[i][1];
            countMinPossibleStep(yTemp, xTemp, yEnd, xEnd, countSteps);
            //countMinPossibleStep(yStart + variationsOfStep[countSteps % 8][0], yStart + variationsOfStep[countSteps % 8][1], yEnd, xEnd, countSteps);
        }
    }

    private static void countMinPossibleStep2(int yStart, int xStart, int yEnd, int xEnd) {
        int countSteps = 0;
        Stack[] stackBig = new Stack[10];
        Node current = new Node(yStart, xStart);
        Stack stack = new Stack();
        stack.add(current);
        stackBig[countSteps] = stack;

        visited[yStart][xStart] = 1;
        while (!isEmpty(stackBig)) {
            stack = findLastOne(stackBig);
            countSteps++;
            while (stack.getHead() != null) {
                Node node = stack.pop();

                if (node.y == yEnd && node.x == xEnd) {
                    if (minSteps > countSteps) {
                        minSteps = countSteps;
                        System.out.println("minsteps: " + minSteps);
                        countSteps--;
                        break;
                    }
                }
                if (minSteps <= countSteps) {
                    break;
                }
                Stack stackTemp = new Stack();
                for (int i = 0; i < variationsOfStep.length; i++) {
                    int yTemp = node.y + variationsOfStep[i][0];
                    int xTemp = node.x + variationsOfStep[i][1];
                    if (checkStepIsPossible(xTemp, yTemp) && visited[xTemp][yTemp] == 0) {
                        visited[yTemp][xTemp] = 1;
                        visitsNumber[yTemp][xTemp] = countSteps;
                        Node next = new Node(yTemp, xTemp);
                        stackTemp.add(next);
                    }
                }
                stackBig[countSteps] = stackTemp;
            }
            print2dArray(visitsNumber);
            System.out.println();
        }
    }

    private static void countMinPossibleStep5(int yStart, int xStart, int yEnd, int xEnd) {
        int countSteps = 0;
        Stack[] stackBig = new Stack[10];
        Node current = new Node(yStart, xStart);
        Stack stack = new Stack();
        stack.add(current);
        stackBig[countSteps] = stack;

        visited[yStart][xStart] = 1;
        while (!isEmpty(stackBig)) {
            stack = findLastOne(stackBig);
            countSteps++;
            while (stack.getHead() != null) {
                Node node = stack.pop();

                if (node.y == yEnd && node.x == xEnd) {
                    if (minSteps > countSteps) {
                        minSteps = countSteps;
                        countSteps--;
                        break;
                    }
                }
                if (minSteps <= stack.count) {
                    continue;
                }
                Stack stackTemp = new Stack();
                for (int i = 0; i < variationsOfStep.length; i++) {
                    int yTemp = node.y + variationsOfStep[i][0];
                    int xTemp = node.x + variationsOfStep[i][1];
                    if (checkStepIsPossible(xTemp, yTemp) && visited[xTemp][yTemp] == 0) {
                        visited[yTemp][xTemp] = 1;
                        visitsNumber[yTemp][xTemp] = countSteps;
                        Node next = new Node(yTemp, xTemp);
                        stackTemp.add(next);
                    }
                    countMinPossibleStep2(yTemp, xTemp, yEnd, xEnd);
                }
                stackBig[countSteps] = stackTemp;
            }

        }
    }

    private static Stack findLastOne(Stack[] stackBig) {
        for (int i = stackBig.length - 1; i >= 0; i--) {
            if (stackBig[i] != null) {
                Stack temp = stackBig[i];
                //stackBig[i] = null;
                return temp;
            }
        }
        return null;
    }

    private static boolean isEmpty(Stack[] stackBig) {
        if (stackBig == null) return true;
        for (Stack s : stackBig) {
            if (s != null) return false;
        }
        return true;
    }

    private static void countMinPossibleStep4(int yStart, int xStart, int yEnd, int xEnd) {
        int countSteps = 0;
        visited[yStart][xStart] = 1;
        while (stack.getHead() != null) {
            Node node = stack.pop();
            countSteps++;

            if (node.y == yEnd && node.x == xEnd) {
                if (minSteps > countSteps) {
                    minSteps = countSteps;
                    return;
                }
            }
            if (minSteps <= stack.count) {
                continue;
            }

            for (int i = 0; i < variationsOfStep.length; i++) {
                int yTemp = node.y + variationsOfStep[i][0];
                int xTemp = node.x + variationsOfStep[i][1];
                if (checkStepIsPossible(xTemp, yTemp) && visited[xTemp][yTemp] == 0) {
                    visited[yTemp][xTemp] = 1;
                    visitsNumber[yTemp][xTemp] = countSteps;
                    Node next = new Node(yTemp, xTemp);
                    stack.add(next);
                }
            }
        }
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

    static class Stack {
        Node head;
        int count;
        public Stack() {
            head = null;
            count = 0;
        }

        Node pop() {
            if (head == null) {
                count = 0;
                return null;
            } else {
                Node temp = head;
                head = head.prev;
                count--;
                return temp;
            }

        }

        void add(Node node) {
            if (head == null) {
                head = node;
                node.prev = null;
            } else {
                node.prev = head;
                head = node;
            }
            count++;
        }
        Node getHead(){
            return head;
        }
    }



    static class Node {
        int[] dimensions;
        int x, y;
        Node prev;
        Node[] prevArray;

        public Node() {
            dimensions = new int[2];
            x = 0;
            y = 0;
            prev = null;
            prevArray = null;
        }

        public Node(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
}
