package LeetCode.easy;

public class Problem2379 {
    //https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/solutions/3811111/java-o-n-1ms/
    //5-10 min
    //Runtime
    //1 ms
    //Beats
    //95.27%
    //Memory
    //40.2 MB
    //Beats
    //95.76%
    static int minimumRecolors(String blocks, int k) {
        int w = 0, min = k, idx = 0;
        for (int i = 0; i < k; i++) if (blocks.charAt(i) == 'W') w++;
        if (w == 0) return 0;
        min = Math.min(w, min);
        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(idx++) == 'W') w--;
            if (blocks.charAt(i) == 'W') w++;
            min = Math.min(w, min);
            if (min == 0) return 0;
        }
        return min;
    }
}
