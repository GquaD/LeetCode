package LeetCode.easy;

public class Problem3861 {
    //2min

    //Runtime
    //94
    //ms
    //Beats
    //2.23%
    //Memory
    //44.21
    //MB
    //Beats
    //98.58%
    public int minimumIndex(int[] capacity, int itemSize) {
        int idx = -1, cap = 101;
        for (int i = 0; i < capacity.length; i++) {
            int cur = capacity[i];
            if (cur >= itemSize && cur < cap) {
                cap = cur;
                idx = i;
            }
        }

        return idx;
    }

}
