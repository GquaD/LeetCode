package LeetCode.medium;

public class Problem4034 {
    //15min

    //Runtime
    //1
    //ms
    //Beats
    //94.99%
    //Memory
    //44.26
    //MB
    //Beats
    //29.28%
    public int minBishopMoves(int[] s, int[] t) {
        int a = s[0], b = s[1], c = t[0], d = t[1];

        if ((a + b) % 2 != (c + d) % 2) return -1;

        int d1 = Math.abs(a - c), d2 = Math.abs(b - d);
        return d1 == d2 ? 1 : 2;
    }
}
