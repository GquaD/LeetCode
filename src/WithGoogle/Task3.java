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
            {-1, -2},
            {-2, -1},
            {-2, 1},
            {-1, 2},
            {1, -2},
            {2, -1},
            {2, 1},
            {1, 2},
    };

    static int minSteps;
    static Queue queue;

    public static void main(String[] args) {
        solution(10, 26);
        print2dArray(visitsNumber);

        solution(19, 36); //this case is successful
        print2dArray(visitsNumber);

        solution(0, 1);
//        print2dArray(visited);
//        System.out.println("Visits number below: ");
        print2dArray(visitsNumber);
        Node one = new Node(1, 1);
        Node two = new Node(2, 1);
        Node three = new Node(3, 1);
        Node four = new Node(4, 1);
        Queue queue = new Queue();

        queue.add(one);
        queue.add(two);
        queue.add(three);
        queue.add(four);
        while (queue.getFirst()!= null) {
            System.out.println(queue.pop().y);
        }
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
        queue = new Queue();
        //step right method
        countMinPossibleStep2(startPosition[0], startPosition[1], endPosition[0], endPosition[1]);
        System.out.println("minimal number of steps from " + start + " to " + end + " is " + visitsNumber[endPosition[0]][endPosition[1]]);
        //recursive method should pass current position and number of steps, and end position
        //which is incremented with each step (recursion run)

        //add visited 2d array
        //set first position as visited
        //add primitive stack structure
        queue = null;

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
                queue.add(current);
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
        Queue[] queueBig = new Queue[10];
        Node current = new Node(yStart, xStart);
        Queue queue = new Queue();
        queue.add(current);
        queueBig[countSteps] = queue;

        visited[yStart][xStart] = 1;
        while (queue.getFirst() != null) {
            Node node = queue.pop();
            //while (stack.getHead() != null) {
                if (node.y == yEnd && node.x == xEnd) {
                    minSteps = node.distance;
                    System.out.println("minsteps: " + minSteps);
                    return;
                }

                for (int i = 0; i < variationsOfStep.length; i++) {
                    int yTemp = node.y + variationsOfStep[i][0];
                    int xTemp = node.x + variationsOfStep[i][1];
                    if (checkStepIsPossible(yTemp, xTemp) && visited[yTemp][xTemp] == 0) {
                        visited[yTemp][xTemp] = 1;
                        Node next = new Node(yTemp, xTemp);
                        next.distance = node.distance + 1;
                        visitsNumber[yTemp][xTemp] = next.distance;
                        queue.add(next);
                    }
                }
            }
            print2dArray(visitsNumber);
            System.out.println();
//        }
    }

    private static void countMinPossibleStep5(int yStart, int xStart, int yEnd, int xEnd) {
        int countSteps = 0;
        Queue[] queueBig = new Queue[10];
        Node current = new Node(yStart, xStart);
        Queue queue = new Queue();
        queue.add(current);
        queueBig[countSteps] = queue;

        visited[yStart][xStart] = 1;
        while (!isEmpty(queueBig)) {
            queue = findLastOne(queueBig);
            countSteps++;
            while (queue.getFirst() != null) {
                Node node = queue.pop();

                if (node.y == yEnd && node.x == xEnd) {
                    if (minSteps > countSteps) {
                        minSteps = countSteps;
                        countSteps--;
                        break;
                    }
                }
                if (minSteps <= queue.count) {
                    continue;
                }
                Queue queueTemp = new Queue();
                for (int i = 0; i < variationsOfStep.length; i++) {
                    int yTemp = node.y + variationsOfStep[i][0];
                    int xTemp = node.x + variationsOfStep[i][1];
                    if (checkStepIsPossible(xTemp, yTemp) && visited[xTemp][yTemp] == 0) {
                        visited[yTemp][xTemp] = 1;
                        visitsNumber[yTemp][xTemp] = countSteps;
                        Node next = new Node(yTemp, xTemp);
                        queueTemp.add(next);
                    }
                    countMinPossibleStep2(yTemp, xTemp, yEnd, xEnd);
                }
                queueBig[countSteps] = queueTemp;
            }

        }
    }

    private static Queue findLastOne(Queue[] queueBig) {
        for (int i = queueBig.length - 1; i >= 0; i--) {
            if (queueBig[i] != null) {
                Queue temp = queueBig[i];
                //stackBig[i] = null;
                return temp;
            }
        }
        return null;
    }

    private static boolean isEmpty(Queue[] queueBig) {
        if (queueBig == null) return true;
        for (Queue s : queueBig) {
            if (s != null) return false;
        }
        return true;
    }

    private static void countMinPossibleStep4(int yStart, int xStart, int yEnd, int xEnd) {
        int countSteps = 0;
        visited[yStart][xStart] = 1;
        while (queue.getFirst() != null) {
            Node node = queue.pop();
            countSteps++;

            if (node.y == yEnd && node.x == xEnd) {
                if (minSteps > countSteps) {
                    minSteps = countSteps;
                    return;
                }
            }
            if (minSteps <= queue.count) {
                continue;
            }

            for (int i = 0; i < variationsOfStep.length; i++) {
                int yTemp = node.y + variationsOfStep[i][0];
                int xTemp = node.x + variationsOfStep[i][1];
                if (checkStepIsPossible(xTemp, yTemp) && visited[xTemp][yTemp] == 0) {
                    visited[yTemp][xTemp] = 1;
                    visitsNumber[yTemp][xTemp] = countSteps;
                    Node next = new Node(yTemp, xTemp);
                    queue.add(next);
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

    static class Queue {
        Node first;
        Node last;
        int count;

        public Queue() {
            first = null;
            last = null;
            count = 0;
        }

        Node pop() {
            if (first == null || last == null) {
                count = 0;
                return null;
            } else if (count == 1) {
                Node temp = last;
                first = last = null;
                count--;
                return temp;
            } else {
                Node temp = first;
                first = temp.next;
                count--;
                return temp;
            }

        }

        void add(Node node) {
            if (first == null && last == null) {
                first = last = node;
                node.next = null;
            } else if (last == null) {
                last = node;
                first.next = last;
            } else {
                Node preLast = last;
                last = node;
                preLast.next = node;
            }
            count++;
        }
        Node getFirst(){
            return first;
        }
    }



    static class Node {
        int[] dimensions;
        int x, y, distance;
        Node next;
        Node[] prevArray;

        public Node() {
            dimensions = new int[2];
            x = 0;
            y = 0;
            next = null;
            distance = 0;
            prevArray = null;
        }

        public Node(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
}
