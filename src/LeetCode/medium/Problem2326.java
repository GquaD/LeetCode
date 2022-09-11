package LeetCode.medium;

import LeetCode.LeetCodeUtils;

public class Problem2326 {
    //https://leetcode.com/problems/spiral-matrix-iv/
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        LeetCodeUtils.print2DArray(spiralMatrix(3,3, l1));
    }
    //Runtime: 88 ms, faster than 5.21% of Java online submissions for Spiral Matrix IV.
    //Memory Usage: 287.2 MB, less than 23.72% of Java online submissions for Spiral Matrix IV.
    static boolean[][] visited;
    static int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        visited = new boolean[m][n];
        int[] coordinates = new int[]{0, 0};
        placeNext(head.val, res, coordinates);
        head = head.next;
        visited[0][0] = true;
        int direction = 0;
        int mult = m * n - 1;
        for (int i = 0; i < mult; i++) {
            int[] coordTemp = findNextCoord(coordinates, direction);
            if (!cellExists(coordTemp[0], coordTemp[1], res)) {
                direction++;
                direction %= 4;
                coordinates = findNextCoord(coordinates, direction);
            } else {
                coordinates = coordTemp;
            }
            if (head != null) {
                placeNext(head.val, res, coordinates);
                head = head.next;
            } else {
                placeNext(-1, res, coordinates);
            }
        }
        return res;
    }

    private static int[] findNextCoord(int[] coordinates, int direction) {
        int y = coordinates[0], x = coordinates[1];
        if (direction == 0) {
            x++;
        } else if (direction == 1) {
            y++;
        } else if (direction == 2) {
            x--;
        } else {
            y--;
        }
        return new int[]{y, x};
    }

    private static void placeNext(int num, int[][] res, int[] coordinates) {
        res[coordinates[0]][coordinates[1]] = num;
        visited[coordinates[0]][coordinates[1]] = true;
    }

    private static boolean cellExists(int row, int col, int[][] array) {
        return (row <= array.length - 1 && row >= 0) && (col <= array[0].length - 1 && col >= 0) && !visited[row][col];
    }
/*
    private static int[] findNextMove(int[] coordinates, int direction) {
        if (direction == 0) {
            coordinates[1]++;
        } else if (direction == 1) {
            coordinates[0]++;
        } else if (direction == 2) {
            coordinates[1]--;
        } else {
            coordinates[0]--;
        }
        if (!cellExists(coordinates[0], coordinates[1], res)) {
            direction++;
        }
    }*/
}
