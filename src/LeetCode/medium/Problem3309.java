package LeetCode.medium;

public class Problem3309 {
    //https://leetcode.com/problems/maximum-possible-number-by-binary-concatenation/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/maximum-possible-number-by-binary-concatenation/solutions/5877586/java-100-time-100-memory-solution/
    //10min
    //Runtime
    //3
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //42.42
    //MB
    //Beats
    //100.00%
    public int maxGoodNumber(int[] nums) {
        int a = nums[0], b = nums[1], c = nums[2];
        StringBuilder sb = new StringBuilder();
        String max = "0";
        sb.append(Integer.toBinaryString(a));
        sb.append(Integer.toBinaryString(b));
        sb.append(Integer.toBinaryString(c));
        String s = sb.toString();
        if (max.compareTo(s) < 0) max = s;
        sb.setLength(0);

        sb.append(Integer.toBinaryString(a));
        sb.append(Integer.toBinaryString(c));
        sb.append(Integer.toBinaryString(b));
        s = sb.toString();
        if (max.compareTo(s) < 0) max = s;
        sb.setLength(0);

        sb.append(Integer.toBinaryString(b));
        sb.append(Integer.toBinaryString(a));
        sb.append(Integer.toBinaryString(c));
        s = sb.toString();
        if (max.compareTo(s) < 0) max = s;
        sb.setLength(0);

        sb.append(Integer.toBinaryString(b));
        sb.append(Integer.toBinaryString(c));
        sb.append(Integer.toBinaryString(a));
        s = sb.toString();
        if (max.compareTo(s) < 0) max = s;
        sb.setLength(0);

        sb.append(Integer.toBinaryString(c));
        sb.append(Integer.toBinaryString(a));
        sb.append(Integer.toBinaryString(b));
        s = sb.toString();
        if (max.compareTo(s) < 0) max = s;
        sb.setLength(0);

        sb.append(Integer.toBinaryString(c));
        sb.append(Integer.toBinaryString(b));
        sb.append(Integer.toBinaryString(a));
        s = sb.toString();
        if (max.compareTo(s) < 0) max = s;

        return Integer.parseInt(max, 2);
    }
}
