package LeetCode.medium;

import java.util.*;

public class Problem18 {
    //https://leetcode.com/problems/4sum/

    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/4sum/solutions/2741250/java-o-n-logn-n-3-solution/
    //in 30 mins
    //O (N * logN + N ^ 3)
    //todo optimization
    //Runtime
    //708 ms
    //Beats
    //5.1%
    //Memory
    //114.7 MB
    //Beats
    //12.43%
    static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int a = nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                int b = nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    int c = nums[k];
                    long sumOfThree = ((long)a) + b + c;
                    if (sumOfThree > Integer.MAX_VALUE || sumOfThree < Integer.MIN_VALUE) {
                        continue;
                    }
                    int d = target - (a + b + c);
                    int idxOfD = Arrays.binarySearch(nums, d);
                    if (idxOfD >= 0 && idxOfD != i && idxOfD != j && idxOfD != k) {
                        List<Integer> l = new ArrayList<>();
                        l.add(a);
                        l.add(b);
                        l.add(c);
                        l.add(d);
                        Collections.sort(l);
                        set.add(l);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    static class Pair {
        int index;
        int value;
    }
}
