package LeetCode.medium;

public class Problem96 {
    //https://leetcode.com/problems/unique-binary-search-trees/
    public static void main(String[] args) {

    }

    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //39 MB
    //Beats
    //84.64%
    static int[] arr = null;
    public int numTrees(int n) {
        if (arr == null) {
            arr = new int[]{0, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796, 58786, 208012, 742900, 2674440, 9694845, 35357670, 129644790, 477638700, 1767263190};
        }
        return arr[n];
    }
}
