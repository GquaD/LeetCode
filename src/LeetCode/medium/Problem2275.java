package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem2275 {
    //https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero/
    public static void main(String[] args) {

        int[] arr = new int[]{8,24,8};
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            temp &= arr[i];
        }

        System.out.println(largestCombination(new int[]{16,16,48,71,62,12,24,14,17,18,19,20,10000}));
        System.out.println(largestCombination(new int[]{16, 17, 71, 62, 12, 24, 14}));
        System.out.println(largestCombination(new int[]{8, 8}));
        System.out.println(largestCombination(new int[]{33,93,31,99,74,37,3,4,2,94,77,10,75,54,24,95,65,100,41,82,35,65,38,49,85,72,67,21,20,31}));
    }

    //Runtime: 142 ms, faster than 11.71% of Java online submissions for Largest Combination With Bitwise AND Greater Than Zero.
    //Memory Usage: 80.1 MB, less than 66.66% of Java online submissions for Largest Combination With Bitwise AND Greater Than Zero.

    static int largestCombination(int[] candidates) {
        int size = Integer.toBinaryString(10_000_000).length();
        int[] count = new int[size];
        int maxLen = 0;
        for (int i = 0; i < candidates.length; i++) {
            String bin = Integer.toBinaryString(candidates[i]);
            for (int j = 0; j < bin.length(); j++) {
                if (bin.charAt(j) == '1') {
                    count[size - bin.length() + j]++;
                }
            }
        }
        int max = 0;
        for (int j = 0; j < count.length; j++) {
            if (max < count[j]) max = count[j];
        }
        return max;
    }

    static int largestCombination4(int[] candidates) {
        int size = Integer.toBinaryString(10_000_000).length();
        int[] count = new int[size];
        for (int i = 0; i < candidates.length; i++) {
            int n = candidates[i];
            for (int j = 0; j < size; j++) {
                int left = 1 << j;
                if ((n & left) > 0) {
                    count[j]++;
                }
            }
        }
        int max = 0;
        for (int j = 0; j < count.length; j++) {
            if (max < count[j]) max = count[j];
        }
        return max;
    }

    //Runtime: 170 ms, faster than 9.46% of Java online submissions for Largest Combination With Bitwise AND Greater Than Zero.
    //Memory Usage: 60.9 MB, less than 89.19% of Java online submissions for Largest Combination With Bitwise AND Greater Than Zero.
    static int largestCombination3(int[] candidates) {
        int maxLen = 0;
        List<String> binaries = new ArrayList<>(candidates.length);
        for (int i = 0; i < candidates.length; i++) {
            String str = Integer.toBinaryString(candidates[i]);
            if (maxLen < str.length()) {
                maxLen = str.length();
            }
            binaries.add(str);
        }

        int res = 0;
        for (int i = 0; i < maxLen; i++) {//columns
            int countOnes = 0;
            for (String bin : binaries) {
                if (bin.length() >= maxLen - i) {
                    if (bin.charAt(i - (maxLen - bin.length())) == '1') {
                        countOnes++;
                    }
                }
            }
            if (res < countOnes) res = countOnes;
        }
        return res;
    }

    //1 hour
    //Runtime: 275 ms, faster than 6.30% of Java online submissions for Largest Combination With Bitwise AND Greater Than Zero.
    //Memory Usage: 139.1 MB, less than 5.40% of Java online submissions for Largest Combination With Bitwise AND Greater Than Zero.
    static int largestCombination2(int[] candidates) {
        //find binary representation of each number
        //put in a table
        //find those which cause 0 when applying bitwise AND operation
        //count the number of the rest
        int maxLength = 0;
        List<String> binaries = new ArrayList<>(candidates.length);
        for (int i = 0; i < candidates.length; i++) {
            String str = Integer.toBinaryString(candidates[i]);
            if (maxLength < str.length()) {
                maxLength = str.length();
            }
            binaries.add(str);
        }
        //matrix to compare
        int[][] matrix = new int[candidates.length][maxLength];
        for (int i = 0; i < binaries.size(); i++) {
            String binary = binaries.get(i);
            int leadingZeros = maxLength - binary.length();
            for (int j = 0; j < binary.length(); j++) {
                matrix[i][j + leadingZeros] = binary.charAt(j) - 48;
            }
        }
        int resultMaxNums = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            int countOnes = 0;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] == 1) {
                    countOnes++;
                }
            }
            if (resultMaxNums < countOnes) {
                resultMaxNums = countOnes;
            }
            countOnes = 0;
        }
        return resultMaxNums;

        /*combinations = new ArrayList<>();
        allNums = candidates;
        maxSizeStatic = 0;
        for (int i = 0; i < candidates.length; i++) {
            findCombs(i, new ArrayList<>());
        }
        return maxSizeStatic;*/
    }

    private static void findCombs(int idxStart, List<Integer> nums) {
        if (idxStart >= allNums.length) {
            //combinations.add(new ArrayList<>(nums));
            int tempAnd = nums.get(0);
            for (int j = 1; j < nums.size(); j++) {
                tempAnd &= nums.get(j);
            }
            if (tempAnd > 0 && maxSizeStatic < nums.size()) {
                maxSizeStatic = nums.size();
            }
            return;
        }
        nums.add(allNums[idxStart]);
        for (int i = idxStart + 1; i <= allNums.length; i++) {
            findCombinations(i, nums);
        }
        nums.remove(nums.size() - 1);
    }

    static List<List<Integer>> combinations;
    static int[] allNums;
    static int maxSizeStatic;

    static int largestCombination1(int[] candidates) {
        combinations = new ArrayList<>();
        allNums = candidates;
        maxSizeStatic = 0;
        for (int i = 0; i < candidates.length; i++) {
            findCombinations(i, new ArrayList<>());
        }
        return maxSizeStatic;
    }

    private static void findCombinations(int idxStart, List<Integer> nums) {
        if (idxStart >= allNums.length) {
            //combinations.add(new ArrayList<>(nums));
            if (maxSizeStatic < nums.size()) {
                int tempAnd = nums.get(0);
                for (int j = 1; j < nums.size(); j++) {
                    tempAnd &= nums.get(j);
                }
                if (tempAnd > 0 && maxSizeStatic < nums.size()) {
                    maxSizeStatic = nums.size();
                }
            }
            return;
        }
        nums.add(allNums[idxStart]);
        for (int i = idxStart + 1; i <= allNums.length; i++) {
            findCombinations(i, nums);
        }
        nums.remove(nums.size() - 1);
    }
}
