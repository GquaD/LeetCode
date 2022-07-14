package LeetCode.medium;

public class Problem1689 {
    //https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/

    public static void main(String[] args) {
        System.out.println(minPartitions("32"));
        System.out.println(minPartitions("82734"));
        System.out.println(minPartitions("27346209830709182346"));
    }

    //Runtime: 8 ms, faster than 77.94% of Java online submissions for Partitioning Into Minimum Number Of Deci-Binary Numbers.
    //Memory Usage: 55.1 MB, less than 7.91% of Java online submissions for Partitioning Into Minimum Number Of Deci-Binary Numbers.
    static int minPartitions(String n) {
        int max = 0;
        for (int i = 0; i < n.length(); i++) {
            int temp = n.charAt(i) - 48;
            if (max < temp) {
                max = temp;
            }
        }
        return max;
    }
}
