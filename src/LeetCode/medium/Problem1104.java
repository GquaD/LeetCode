package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.ArrayList;
import java.util.List;

public class Problem1104 {
    //https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/
    public static void main(String[] args) {
        LeetCodeUtils.printList(pathInZigZagTree(14));
        LeetCodeUtils.printList(pathInZigZagTree(26));
    }

    //Runtime: 41 ms, faster than 5.67% of Java online submissions for Path In Zigzag Labelled Binary Tree.
    //Memory Usage: 75.7 MB, less than 5.37% of Java online submissions for Path In Zigzag Labelled Binary Tree.
    static List<Integer> pathInZigZagTree(int label) {
        int n = 0; //levels
        int l = label;

        while (l > 0) {
            l /= 2;
            n++;
        }
        int positionForPrevious = -1;
        List<Integer> list = new ArrayList<>();
        list.add(label);
        for (int i = n - 1; i >= 0; i--) {
            int lowEdgeOfTheRow = (int) Math.pow(2, i);
            int highEdgeOfTheRow = (int) Math.pow(2, i + 1) - 1;

            int[] row = new int[highEdgeOfTheRow - lowEdgeOfTheRow + 1];
            if (i % 2 == 1) {
                for (int j = 0; j < row.length; j++) {
                    row[j] = highEdgeOfTheRow - j;
                }
            } else {
                for (int j = 0; j < row.length; j++) {
                    row[j] = lowEdgeOfTheRow + j;
                }
            }

            if (positionForPrevious != -1 && positionForPrevious != 0) {
                label = row[positionForPrevious - 1];
                list.add(label);
            }

            int position = findPositionIndex(label, row);
            if (position % 2 == 1) {
                position++;
            }

            positionForPrevious = position / 2;
        }
        list.sort((o1, o2) -> o1 - o2);
        return list;
    }

    private static int findPositionIndex(int label, int[] row) {
        for (int i = 0; i < row.length; i++) {
            if (row[i] == label) {
                return i + 1;
            }
        }
        return -1;
    }


    static List<Integer> pathInZigZagTree2(int label) {
        int n = 0;
        int l = label;

        while (l > 0) {
            l /= 2;
            n++;
        }

        int[] result = new int[n];
        int prevBranchPos = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                result[i] = 1;
                continue;
            }
            int largestInRow = 0;
            int smallestInRow = 0;

            largestInRow = (int) Math.pow(2, i + 1) - 1;
            smallestInRow = (int) Math.pow(2, i);
            int numOfElementsInTheRow = smallestInRow;
            int currentPos = label - numOfElementsInTheRow;
            if (i != n - 1) {
                if (i % 2 != 0) {
                    result[i] = largestInRow - prevBranchPos;
                } else {
                    result[i] = smallestInRow + prevBranchPos;
                }
            } else {
                result[i] = numOfElementsInTheRow + currentPos;
            }
            prevBranchPos = (currentPos + 1) % (int) Math.pow(2, i - 1); // 7 % 4 = 3, 3rd branch (0-indexed)
            if (i - 1 % 2 != 0) {
                prevBranchPos = (int) Math.pow(2, i - 1) - prevBranchPos - 1;
            }

        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            list.add(result[i]);
        }
        return list;
    }


    static List<Integer> pathInZigZagTree1(int label) {
        int n = 0;
        int l = label;

        while (l > 0) {
            l /= 2;
            n++;
        }

        int[] result = new int[n];
        int prevBranchPos = 0;
        for (int i = n - 1; i >= 0; i--) {
            int numOfElementsInTheRow = (int) Math.pow(2, i); //and also row's min num is this
            int currentPos = label - numOfElementsInTheRow; //7th position (if label == 14)
            label = numOfElementsInTheRow - 1;
            if (i != n - 1) {
                result[i] = numOfElementsInTheRow - prevBranchPos;
            } else {
                result[i] = numOfElementsInTheRow + currentPos;
            }
            prevBranchPos = (currentPos + 1) % (int) Math.pow(2, i - 1); // 7 % 4 = 3, 3rd branch (0-indexed)
            if (i - 1 % 2 != 0) {
                prevBranchPos = (int) Math.pow(2, i - 1) - prevBranchPos - 1;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            list.add(result[i]);
        }
        return list;
    }
}
