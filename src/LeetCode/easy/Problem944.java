package LeetCode.easy;

public class Problem944 {
    //https://leetcode.com/problems/delete-columns-to-make-sorted/
    public static void main(String[] args) {
        System.out.println(minDeletionSize(new String[]{"cba","daf","ghi"}));
        System.out.println(minDeletionSize(new String[]{"a","b"}));
        System.out.println(minDeletionSize(new String[]{"zyx","wvu","tsr"}));
    }

    //Runtime: 11 ms, faster than 72.10% of Java online submissions for Delete Columns to Make Sorted.
    //Memory Usage: 47.7 MB, less than 61.61% of Java online submissions for Delete Columns to Make Sorted.
    static int minDeletionSize(String[] strs) {
        int count = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            if (toDelete(i, strs)) {
                count++;
            }
        }
        return count;
    }

    private static boolean toDelete(int col, String[] strs) {
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].charAt(col) < strs[i - 1].charAt(col)) {
                return true;
            }
        }
        return false;
    }
}
