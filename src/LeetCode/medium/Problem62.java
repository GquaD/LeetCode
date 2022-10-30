package LeetCode.medium;

import java.util.HashMap;

public class Problem62 {
    static int number;

    //https://leetcode.com/problems/unique-paths/
    public static void main(String[] args) {
        System.out.println(makeString(3, 1));
        System.out.println(makeString(3, 2));
        System.out.println(makeString(3, 3));
        System.out.println(makeString(3, 4));
        System.out.println(makeString(3, 5));
        System.out.println(makeString(3, 6));
        System.out.println(makeString(3, 7));
        System.out.println(makeString(3, 8));
        System.out.println(makeString(3, 9));
        System.out.println(makeString(3, 10));
        System.out.println(makeString(4, 1));
        System.out.println(makeString(4, 2));
        System.out.println(makeString(4, 3));
        System.out.println(makeString(4, 4));
        System.out.println(makeString(4, 5));
        System.out.println(makeString(4, 6));
        System.out.println(makeString(4, 7));
        System.out.println(makeString(4, 8));
        System.out.println(makeString(4, 9));
        System.out.println(makeString(4, 10));
        System.out.println(makeString(5, 5));
        System.out.println(uniquePaths2(19, 13));
        System.out.println(uniquePaths2(13, 23));
    }

    static String makeString(int m, int n) {
        int result = uniquePaths1(m, n);
        return m + ", " + n + " -> " + result;
    }

    public static int uniquePaths(int m, int n) {
        int[][] array = new int[m][n];
        number = 0;
        goRecursively(0, 0, array);
        return number;
    }

    //latest version working
    //Runtime: 14 ms, faster than 5.02% of Java online submissions for Unique Paths.
    //Memory Usage: 42.2 MB, less than 5.03% of Java online submissions for Unique Paths.
    public static int uniquePaths2(int m, int n) {
        cache = new HashMap<>();
        return anotherCalc(m, n);
    }

    static HashMap<String, Integer> cache;
    static int anotherCalc(int m, int n) {
        String key = m + "" + n;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        if (m == 1 || n == 1) {
            return 1;
        }

        if (m == 2) {
            return n;
        }

        if (n == 2) {
            return m;
        }

        int result = anotherCalc(m, n - 1) + anotherCalc(m - 1, n);
        if (!cache.containsKey(key)){
            cache.put(key, result);
        }
        return result;
    }
    //end of latest version

    //works but times exceeded
    //version start
    public static int uniquePaths1(int m, int n) {
        return recursiveCalc(m, n);
    }

    public static int recursiveCalc(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }

        if (m == 2) {
            return n;
        }

        if (n == 2) {
            return m;
        }

        return recursiveCalc(m, n - 1) + recursiveCalc(m - 1, n);
    }
    //end of version

    //works but time exceeded
    //start of version
    private static void goRecursively(int row, int col, int[][] array) {
        if (row == array.length - 1 && col == array[0].length - 1) {
            number++;
            return;
        }
        if (cellExist(row, col + 1, array)) {
            goRecursively(row, col + 1, array);
        }
        if (cellExist(row + 1, col, array)) {
            goRecursively(row + 1, col, array);
        }
    }
    //end of version

    private static void goRecursively1(int row, int col, int[][] array, int level) {
        if (row == array.length - 1 && col == array[0].length - 1) {
            number++;
            return;
        }
        /*if (level > array.length + array[0].length - 2) {
            return;
        }*/
        /*if (cellExist(row - 1, col, array)*//* && array[row - 1][col] == 0*//*) {
//            array[row - 1][col] = 1;
            goRecursively(row - 1, col, array, ++level);
        }*/
        if (cellExist(row, col + 1, array)/* && array[row][col+ 1] == 0*/) {
//            array[row][col + 1] = 1;
            goRecursively1(row, col + 1, array, ++level);
        }
        if (cellExist(row + 1, col, array)/* && array[row + 1][col] == 0*/) {
//            array[row + 1][col] = 1;
            goRecursively1(row + 1, col, array, ++level);
        }
        /*if (cellExist(row, col - 1, array)*//* && array[row][col - 1] == 0*//*) {
//            array[row][col - 1] = 1;
            goRecursively(row - 1, col, array, ++level);
        }*/
    }

    private static boolean cellExist(int row, int col, int[][] array) {
        return (row <= array.length - 1 && row >= 0) && (col <= array[0].length - 1 && col >= 0);
    }
}
