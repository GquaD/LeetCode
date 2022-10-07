package LeetCode.medium;

public class Problem1860 {
    //https://leetcode.com/problems/incremental-memory-leak/

    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/incremental-memory-leak/solutions/2673008/java-solution/
    //30-60mins
    //Runtime
    //9 ms
    //Beats
    //39.58%
    //Memory
    //41.9 MB
    //Beats
    //29.86%
    public int[] memLeak(int memory1, int memory2) {
        int count = 1;
        while (memory1 - count >= 0 || memory2 - count >= 0) {
            int diff1 = memory1 - count, diff2 = memory2 - count;
            if (memory1 - count >= 0 && memory2 - count >= 0) {
                if (diff2 > diff1) {
                    memory2 -= count;
                    count++;
                    continue;
                } else {
                    memory1 -= count;
                    count++;
                    continue;
                }
            }
            if (memory1 - count >= 0) {
                memory1 -= count;
                count++;
            } if (memory2 - count >= 0) {
                memory2 -= count;
                count++;
            }
        }
        return new int[]{count, memory1, memory2};
    }
}
