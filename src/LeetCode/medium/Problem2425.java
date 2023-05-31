package LeetCode.medium;

public class Problem2425 {
    //https://leetcode.com/problems/bitwise-xor-of-all-pairings/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/bitwise-xor-of-all-pairings/solutions/3582922/java-100-faster-with-explanation/
    //I used property of xor when xor applied to 2 equal numbers, then the result is 0
    //if first array has even number of elements, it means that xor applied even number of times
    //to the elements from the second array. This means that we will have only first elements left.
    //As a result we apply xor to all elements from the first array.
    //30 min
    //Runtime
    //1 ms
    //Beats
    //100%
    //Memory
    //61.4 MB
    //Beats
    //10%
    static int xorAllNums(int[] nums1, int[] nums2) {
        int xor = 0;
        if (nums1.length % 2 == 0 && nums2.length % 2 == 0) return xor;
        if (nums1.length % 2 == 0) {
            for (int n : nums1) xor ^= n;
            return xor;
        } else if (nums2.length % 2 == 0) {
            for (int n : nums2) xor ^= n;
            return xor;
        }
        for (int n : nums1) xor ^= n;
        for (int n : nums2) xor ^= n;
        return xor;
    }
}
