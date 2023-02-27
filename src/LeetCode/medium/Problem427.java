package LeetCode.medium;

public class Problem427 {
    //https://leetcode.com/problems/construct-quad-tree/
    public static void main(String[] args) {
        Node node1 = construct(new int[][]{{1,1,0,0},{0,0,1,1},{1,1,0,0},{0,0,1,1}});
        System.out.println(node1);
        Node node = construct(new int[][]{{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0}});
        System.out.println(node);

    }

    //https://leetcode.com/problems/construct-quad-tree/solutions/3235324/java-recursive-solution/
    //1-1.5 hour
    //Runtime
    //1 ms
    //Beats
    //71.9%
    //Memory
    //43.3 MB
    //Beats
    //20.31%

    static Node construct(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Node node = new Node();
        boolean containsBoth = containsBothZeroAndOne(0, rows, 0, cols, node, grid);
        if (containsBoth) goRecursively(0, rows, 0, cols, node, grid);
        return node;
    }

    private static void goRecursively(int rS, int rE, int cS, int cE, Node node, int[][] grid) {
        if (rS == rE || cS == cE) return;

        int rMid = (rE + rS) / 2, cMid = (cE + cS) / 2;
        Node nodeTopLeft = new Node();
        boolean containsBothTopLeft = containsBothZeroAndOne(rS, rMid, cS, cMid, nodeTopLeft, grid);
        node.topLeft = nodeTopLeft;
        if (containsBothTopLeft) goRecursively(rS, rMid, cS, cMid, nodeTopLeft, grid);

        Node nodeTopRight = new Node();
        boolean containsBothTopRight = containsBothZeroAndOne(rS, rMid, cMid, cE, nodeTopRight, grid);
        node.topRight = nodeTopRight;
        if (containsBothTopRight) goRecursively(rS, rMid, cMid, cE, nodeTopRight, grid);

        Node nodeBottomLeft = new Node();
        boolean containsBothBottomLeft = containsBothZeroAndOne(rMid, rE, cS, cMid, nodeBottomLeft, grid);
        node.bottomLeft = nodeBottomLeft;
        if (containsBothBottomLeft) goRecursively(rMid, rE, cS, cMid, nodeBottomLeft, grid);

        Node nodeBottomRight = new Node();
        boolean containsBothBottomRight = containsBothZeroAndOne(rMid, rE, cMid, cE, nodeBottomRight, grid);
        node.bottomRight = nodeBottomRight;
        if (containsBothBottomRight) goRecursively(rMid, rE, cMid, cE, nodeBottomRight, grid);
    }

    private static boolean containsBothZeroAndOne(int rS, int rE, int cS, int cE, Node node, int[][] grid) {
        boolean hasZero = false, hasOne = false;
        node.isLeaf = true;
        for (int r = rS; r < rE ; r++) {
            for (int c = cS; c < cE; c++) {
                if (grid[r][c] == 0) {
                    hasZero = true;
                    node.val = false;
                } else {
                    hasOne = true;
                    node.val = true;
                }

                if (hasOne && hasZero) {
                    node.val = true;
                    node.isLeaf = false;
                    return true;
                }
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
