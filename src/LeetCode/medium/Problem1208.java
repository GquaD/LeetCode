package LeetCode.medium;

public class Problem1208 {
    //https://leetcode.com/problems/get-equal-substrings-within-budget
    public static void main(String[] args) {
//        System.out.println(equalSubstring("abcd", "bcdf", 3));
        System.out.println(equalSubstring("abcd", "cdef", 3));
        System.out.println(equalSubstring("abcd", "acde", 0));
    }

    //nn
    //40min
    //Runtime
    //5
    //ms
    //Beats
    //97.52%
    //of users with Java
    //Memory
    //43.30
    //MB
    //Beats
    //23.45%
    //of users with Java

    static int equalSubstring1(String s, String t, int maxCost) {
        int[] arr = new int[s.length()];

        for (int i = 0; i < arr.length; i++) {
            int diff = Math.abs(s.charAt(i) - t.charAt(i));
            arr[i] = diff;
        }

        int l = 0, i;
        for (i = 0; i < arr.length; i++) {
            maxCost -= arr[i];
            if (maxCost < 0) {
                maxCost += arr[l];
                l++;
            }
        }
        return i - l;
    }
    static int equalSubstring(String s, String t, int maxCost) {
        int[] arr = new int[s.length()];

        for (int i = 0; i < arr.length; i++) {
            int diff = Math.abs(s.charAt(i) - t.charAt(i));
            if (i > 0) {
                arr[i] = arr[i - 1] + diff;
            } else {
                arr[i] = diff;
            }
        }

        int l = 0, maxLen = 0;
        if (arr[0] <= maxCost)
            maxLen++;

        for (int i = 0; i < arr.length; i++) {
            int diff = arr[i] - arr[l];
            if (diff > maxCost && l <= i) {
                l++;
                diff =arr[i] - arr[l];
            }
            if (diff <= maxCost) {
                maxLen = Math.max(maxLen, i - l + 1) ;
            }

        }
        return maxLen;
    }
}
