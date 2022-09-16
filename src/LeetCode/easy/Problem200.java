package LeetCode.easy;

import java.util.Arrays;
import java.util.HashMap;

public class Problem200 {
    //https://leetcode.com/problems/number-of-islands/
    public static void main(String[] args) {

        char[][] grid2 = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(countIslands(grid2));

    }


    // A utility function to do DFS for a 2D
    //  boolean matrix. It only considers
    // the 8 neighbours as adjacent vertices
    static void DFS(char[][] M, int i, int j, int ROW, int COL)
    {

        // Base condition
        // if i less than 0 or j less than 0 or i greater than ROW-1 or j greater than COL-  or if M[i][j] != 1 then we will simply return
        if (i < 0 || j < 0 || i > (ROW - 1) || j > (COL - 1) || M[i][j] != '1')
        {
            return;
        }

        if (M[i][j] == '1')
        {
            M[i][j] = '0';
            DFS(M, i + 1, j, ROW, COL);     //right side traversal
            DFS(M, i - 1, j, ROW, COL);     //left side traversal
            DFS(M, i, j + 1, ROW, COL);     //upward side traversal
            DFS(M, i, j - 1, ROW, COL);     //downward side traversal
        }
    }

    static int countIslands(char[][] M)
    {
        int ROW = M.length;
        int COL = M[0].length;
        int count = 0;
        for (int i = 0; i < ROW; i++)
        {
            for (int j = 0; j < COL; j++)
            {
                if (M[i][j] == '1')
                {
                    M[i][j] = '0';
                    count++;
                    DFS(M, i + 1, j, ROW, COL);     //right side traversal
                    DFS(M, i - 1, j, ROW, COL);     //left side traversal
                    DFS(M, i, j + 1, ROW, COL);     //upward side traversal
                    DFS(M, i, j - 1, ROW, COL);     //downward side traversal
                }
            }
        }
        return count;
    }

}
