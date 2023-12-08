package LeetCode.medium;

import java.util.*;

public class Problem279 {
    //https://leetcode.com/problems/perfect-squares/
    public static void main(String[] args) {
        System.out.println(numSquares(9999));
        System.out.println(numSquares(10));
        System.out.println(numSquares(13));
        System.out.println(numSquares(12));//3 since 4+4+4, my code will return 4, since 9+1+1+1
    }

    //https://leetcode.com/problems/perfect-squares/solutions/4378752/java-bfs-solution/
    //40-50min
    //Runtime
    //78 ms
    //Beats
    //22.93%
    //Memory
    //77.4 MB
    //Beats
    //5.13%

    static int[] squares;

    static int numSquares(int n) {
        if (squares == null) fillSquares();
        int idx = Arrays.binarySearch(squares, n);
        if (idx >= 0) {
            return 1;
        } else {
            idx = -idx - 2;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = idx; i >= 1 ; i--) {
            queue.offer(squares[i]);
        }
        int count = 1;
        Set<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int num = queue.poll();
                if (num == n) return count;
                if (visited.contains(num)) continue;
                visited.add(num);
                int idx1 = Arrays.binarySearch(squares, n - num);
                if (idx1 < 0) {
                    idx1 = -idx1 - 2;
                }
                for (int i = idx1; i >= 1 ; i--) {
                    if (num + squares[i] <= n)
                        queue.offer(num + squares[i]);
                }
            }
            count++;
        }
        return -1;
    }
    private static void fillSquares() {
        squares = new int[101];
        for (int i = 1; i < squares.length; i++) squares[i] = i * i;
    }

    static int numSquares1(int n) {
        int count = 0, idx = squares.length - 1;
        while (n > 0) {
            if (squares[idx] <= n) {
                n -= squares[idx];
                count++;
            } else idx--;
        }
        return count;
    }
}
