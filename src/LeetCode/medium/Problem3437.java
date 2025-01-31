package LeetCode.medium;

import java.util.*;

public class Problem3437 {
    //https://leetcode.com/problems/permutations-iii
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/permutations-iii/solutions/6352115/java-100-time-100-memory-solution-by-tbe-t5px/
    //20min
    //Runtime
    //15
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //50.00
    //MB
    //Beats
    //100.00%
    public int[][] permute(int n) {
        List<int[]> list = new ArrayList<>();
        int[] cur = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            findPermutation(0, i, cur, list, set);
        }
        int size = list.size();
        int[][] result = new int[size][n];
        for (int i = 0; i < size; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void findPermutation(int index, int current, int[] arr, List<int[]> list, Set<Integer> set) {
        if (index >= arr.length) {
            return;
        }

        if (!set.contains(current)) {
            set.add(current);
            arr[index] = current;
            if (index == arr.length - 1) {
                list.add(Arrays.copyOf(arr, arr.length));
            } else if (current % 2 == 0) {
                for (int i = 1; i <= arr.length; i += 2) {
                    findPermutation(index + 1, i, arr, list, set);
                }
            } else {
                for (int i = 2; i <= arr.length; i += 2) {
                    findPermutation(index + 1, i, arr, list, set);
                }
            }
            arr[index] = 0;
            set.remove(current);
        }
    }
}
