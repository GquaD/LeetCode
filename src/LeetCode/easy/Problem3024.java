package LeetCode.easy;

public class Problem3024 {
    //10min

    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Memory
    //43.75
    //MB
    //Beats
    //58.12%
    //https://leetcode.com/problems/type-of-triangle/solutions/8073940/java-solution-by-tbekpro-t2vc/
    public String triangleType(int[] nums) {
        int a = nums[0], b = nums[1], c = nums[2];
        if (!(a < b + c && b < a + c && c < a + b)) return "none";
        if (a == b && b == c) return "equilateral";
        if (a == b || b == c || a == c) return "isosceles";
        return "scalene";
    }
}
