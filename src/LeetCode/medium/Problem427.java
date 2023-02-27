package LeetCode.medium;

public class Problem427 {
    //https://leetcode.com/problems/construct-quad-tree/
    public static void main(String[] args) {
        Node node = construct(new int[][]{{0,1},{1,0}});
        System.out.println(node);
    }

    static Node construct(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        boolean containsBoth = containsBothZeroAndOne(0, rows, 0, cols, grid);
        Node node = new Node(containsBoth, !containsBoth);
        if (containsBoth) goRecursively(0, rows, 0, cols, node, grid);
        return node;
    }

    private static void goRecursively(int rS, int rE, int cS, int cE, Node node, int[][] grid) {
        if (rS == rE || cS == cE) return;

        if (rS == rE - 1 && cS == cE - 1) return; // todo

        boolean containsBothTopLeft = containsBothZeroAndOne(rS, rE / 2, cS, cE / 2, grid);
        Node nodeTopLeft = new Node(containsBothTopLeft, !containsBothTopLeft);
        node.topLeft = nodeTopLeft;
        if (containsBothTopLeft) goRecursively(rS, rE / 2, cS, cS / 2, nodeTopLeft, grid);

        boolean containsBothTopRight = containsBothZeroAndOne(rS, rE / 2, cE / 2, cE, grid);
        Node nodeTopRight = new Node(containsBothTopRight, !containsBothTopRight);
        node.topRight = nodeTopRight;
        if (containsBothTopRight) goRecursively(rS, rE / 2, cE / 2, cS, nodeTopRight, grid);

        boolean containsBothBottomLeft = containsBothZeroAndOne(rE / 2, rE, cS, cE / 2, grid);
        Node nodeBottomLeft = new Node(containsBothBottomLeft, !containsBothBottomLeft);
        node.bottomLeft = nodeBottomLeft;
        if (containsBothBottomLeft) goRecursively(rE / 2, rE, cS, cS / 2, nodeTopLeft, grid);

        boolean containsBothBottomRight = containsBothZeroAndOne(rE / 2, rE, cE / 2, cE, grid);
        Node nodeBottomRight = new Node(containsBothBottomRight, !containsBothBottomRight);
        node.bottomRight = nodeBottomRight;
        if (containsBothBottomRight) goRecursively(rE / 2, rE, cE / 2, cE, nodeBottomRight, grid);
    }

    private static boolean containsBothZeroAndOne(int rS, int rE, int cS, int cE, int[][] grid) {
        boolean hasZero = false, hasOne = false;
        for (int r = rS; r < rE ; r++) {
            for (int c = cS; c < cE; c++) {
                if (grid[r][c] == 0) hasZero = true;
                else hasOne = true;

                if (hasOne && hasZero) return true;
            }
        }
        return false;
    }


    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
