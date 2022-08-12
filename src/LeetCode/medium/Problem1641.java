package LeetCode.medium;

public class Problem1641 {
    //https://leetcode.com/problems/count-sorted-vowel-strings/
    public static void main(String[] args) {
        System.out.println(countVowelStrings(1));
        System.out.println(countVowelStrings(2));
        System.out.println(countVowelStrings(3));
        System.out.println(countVowelStrings(4));
        System.out.println(countVowelStrings(5));
        System.out.println(countVowelStrings(33));
        System.out.println(countVowelStrings(50));
    }

    //in 30 mins top!!
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Count Sorted Vowel Strings.
    //Memory Usage: 39.2 MB, less than 90.81% of Java online submissions for Count Sorted Vowel Strings.
    static int countVowelStrings(int n) {
        if (n == 1) {
            return 5;
        }
        int count = 2;
        int[] arr = new int[]{1, 2, 3, 4, 5};
        while (count <= n) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
                arr[i] = sum;
            }
            count++;
        }
        return arr[arr.length - 1];
    }
}
