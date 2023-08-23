package LeetCode.medium;

public class Problem1936 {
    //https://leetcode.com/problems/add-minimum-number-of-rungs/
    public static void main(String[] args) {
        System.out.println(addRungs(new int[]{3}, 1));
        System.out.println(addRungs(new int[]{3,4,6,7}, 2));
    }

    //https://leetcode.com/problems/add-minimum-number-of-rungs/solutions/3947917/java-o-n-100-faster/
    //5-10 min
    //Runtime
    //1 ms
    //Beats
    //100%
    //Memory
    //55.8 MB
    //Beats
    //97.9%
    static int addRungs(int[] rungs, int dist) {
        int count = 0, prev = 0;
        for (int i = 0; i < rungs.length; i++) {
            int diff = rungs[i] - prev;
            prev = rungs[i];
            if (diff > dist) count += diff % dist == 0 ? (diff / dist) - 1 : diff / dist;
        }
        return count;
    }
}
