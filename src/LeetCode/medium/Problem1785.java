package LeetCode.medium;

public class Problem1785 {
    //https://leetcode.com/problems/minimum-elements-to-add-to-form-a-given-sum/
    public static void main(String[] args) {
        System.out.println(minElements(new int[]{1,-1,1}, 3, -4));
    }

    //https://leetcode.com/problems/minimum-elements-to-add-to-form-a-given-sum/solutions/4092657/java-o-n-100-faster-4-lines/
    //5-10min
    //Runtime
    //1 ms
    //Beats
    //100%
    //Memory
    //55.8 MB
    //Beats
    //75.86%
    static int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int n : nums) sum += n;
        long diff = goal - sum < 0 ? -(goal - sum) : goal - sum;
        return diff % limit == 0 ? (int) (diff / limit) : (int) (diff / limit + 1);
    }
}
