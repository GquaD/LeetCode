package LeetCode.easy;

public class Problem4061 {
    //10min
    //Runtime
    //2
    //ms
    //Beats
    //2.30%
    //Memory
    //43.59
    //MB
    //Beats
    //98.27%
    public int minQueenMoves(int[] source, int[] target) {
        int x1 = source[0], y1 = source[1], x2 = target[0], y2 = target[1];
        if (x1 == x2 && y1 == y2) return 0;
        if (x1 == x2 || y1 == y2) return 1;

        for (int i = -7; i < 8; i++) {
            if ((cellExists(x2 + i, y2 + i) && x1 == x2 + i && y1 == y2 + i)
                    || (cellExists(x2 + i, y2 - i) && x1 == x2 + i && y1 == y2 - i))
                return 1;
        }

        return 2;
    }

    private boolean cellExists(int r, int c) {
        return r >= 1 && r <= 8 && c >= 1 && c <= 8;
    }
}
