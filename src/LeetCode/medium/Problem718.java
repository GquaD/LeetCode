package LeetCode.medium;

public class Problem718 {
    //https://leetcode.com/problems/maximum-length-of-repeated-subarray/
    public static void main(String[] args) {
        System.out.println(findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
        System.out.println(findLength(new int[]{0, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 0}));
        System.out.println(findLength(new int[]{1, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 1}));
        System.out.println(findLength(new int[]{0, 0, 0, 0, 1}, new int[]{1, 0, 0, 0, 0}));
        System.out.println(findLength(new int[]{1, 0, 0, 0, 1}, new int[]{0, 0, 0, 0, 0}));
    }


    //not my solution
    static int findLength(int[] A, int[] B) {
        int ans = 0;
        int[][] memo = new int[A.length + 1][B.length + 1];
        for (int i = A.length - 1; i >= 0; --i) {
            for (int j = B.length - 1; j >= 0; --j) {
                if (A[i] == B[j]) {
                    memo[i][j] = memo[i+1][j+1] + 1;
                    if (ans < memo[i][j]) ans = memo[i][j];
                }
            }
        }
        return ans;
    }

    //1 hour
    //57 / 57 test cases passed, but took too long.
    //Runtime: 2759 ms, faster than 5.04% of Java online submissions for Maximum Length of Repeated Subarray.
    //Memory Usage: 44.7 MB, less than 94.80% of Java online submissions for Maximum Length of Repeated Subarray.
    static int findLength2(int[] nums1, int[] nums2) {
        int maxLength = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    int idx1 = i, idx2 = j, countLength = 0;
                    while (idx1 < nums1.length && idx2 < nums2.length && nums1[idx1] == nums2[idx2]) {
                        countLength++;
                        idx1++;
                        idx2++;
                    }
                    if (maxLength < countLength) {
                        maxLength = countLength;
                    }
                    if (idx2 == nums2.length) break;
                }
            }

        }
        return maxLength;
    }


    static int findLength1(int[] nums1, int[] nums2) {
        if (nums2.length != nums1.length) {
            int[] small = nums2.length < nums1.length ? nums2 : nums1;
            int[] great = nums2.length > nums1.length ? nums2 : nums1;
            nums1 = small;
            nums2 = great;
        }
        StringBuilder sb = new StringBuilder();
        for (int n : nums1) {
            sb.append(n);
        }
        String one = sb.toString();
        sb.setLength(0);
        for (int n : nums2) {
            sb.append(n);
        }
        String two = sb.toString();
        sb.setLength(0);
        int length = 0;
        for (int i = 0; i < one.length(); i++) {
            String sub = one.substring(i);
            String sub2 = one.substring(0, one.length() - i);
            if (sub.length() > length && two.contains(sub)) {
                length = sub.length();
            }
            if (sub2.length() > length && two.contains(sub2)) {
                length = sub2.length();
            }
            if (i <= one.length() / 2) {
                String sub3 = one.substring(i, one.length() - i);
                if (sub3.length() > length && two.contains(sub3)) {
                    length = sub3.length();
                }
            }
        }
/*
        for (int i = one.length() - 1; i >= 0; i--) {
            String sub = one.substring(0, i + 1);
            if (sub.length() > length && two.contains(sub)) {
                length = sub.length();
            }
        }*/

        return length;
    }
}
