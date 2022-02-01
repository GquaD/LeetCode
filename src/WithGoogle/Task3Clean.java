package WithGoogle;

public class Task3Clean {
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

    public static void main(String[] args) {
        solution(19, 36);
        solution(10, 26);
        solution(0, 1);
        solution(0, 63);
    }

    private static int solution(int src, int dest) {
        minSteps = 8;
        visited = new int[8][8];
        //find current position's coordinates
        int[] startPosition = getPositionNoLoop(src);

        visited[startPosition[0]][startPosition[1]] = 1;
        //find end position's coordinates
        int[] endPosition = getPositionNoLoop(dest);

        countMinPossibleStep2(startPosition[0], startPosition[1], endPosition[0], endPosition[1]);
        System.out.println(minSteps);
        return minSteps;
    }

    private static int[] getPositionNoLoop(int num) {
        int[] result = new int[2];// row, column or (y, x)
        int row = num / board.length;
        int column = num % board.length;
        result[0] = row;
        result[1] = column;
        return result;
    }

    private static int getNumFromPosition(int y, int x) {
        try {
            return board[y][x];
        } catch (Exception e) {
            return -1;
        }
    }

    private static void countMinPossibleStep2(int yStart, int xStart, int yEnd, int xEnd) {
        Node current = new Node(yStart, xStart);
        Queue queue = new Queue();
        queue.add(current);

        visited[yStart][xStart] = 1;
        while (queue.getFirst() != null) {
            Node node = queue.pop();
            if (node.y == yEnd && node.x == xEnd) {
                minSteps = node.distance;
                return;
            }

            for (int i = 0; i < variationsOfStep.length; i++) {
                int yTemp = node.y + variationsOfStep[i][0];
                int xTemp = node.x + variationsOfStep[i][1];
                if (checkStepIsPossible(yTemp, xTemp) && visited[yTemp][xTemp] == 0) {
                    visited[yTemp][xTemp] = 1;
                    Node next = new Node(yTemp, xTemp);
                    next.distance = node.distance + 1;
                    queue.add(next);
                }
            }
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
        int x, y, distance;
        Node next;

        public Node() {
            x = 0;
            y = 0;
            next = null;
            distance = 0;
        }

        public Node(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
}
