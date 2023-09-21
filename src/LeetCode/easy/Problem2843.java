package LeetCode.easy;

public class Problem2843 {
    //https://leetcode.com/problems/count-symmetric-integers/
    public static void main(String[] args) {
        System.out.println(countSymmetricIntegers(1, 100));
        System.out.println(countSymmetricIntegers(1200, 1230));
    }


    //
    //5-10min
    //Runtime
    //30 ms
    //Beats
    //44.81%
    //Memory
    //42.8 MB
    //Beats
    //80.64%
    static int countSymmetricIntegers(int low, int high) {
        int left = 0, right = 0, count = 0;
        for (int i = low; i <= high; i++) {
            String s = Integer.toString(i);
            if (s.length() % 2 != 1) {
                for (int j = 0; j < s.length() / 2; j++) left += s.charAt(j) - '0';
                for (int j = s.length() / 2; j < s.length(); j++) right += s.charAt(j) - '0';
                if (left == right) count++;
            }
            left = right = 0;
        }
        return count;
    }

}
