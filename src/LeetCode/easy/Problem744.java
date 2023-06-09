package LeetCode.easy;

import java.util.Arrays;

public class Problem744 {
    //https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-smallest-letter-greater-than-target/solutions/3616252/java-o-logn-solution/
    //5 min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //44.9 MB
    //Beats
    //8.23%
    static char nextGreatestLetter(char[] letters, char target) {
        int temp = 0;
        for (int i = target + 1; i <= 'z'; i++) {
            temp = Arrays.binarySearch(letters, (char)i);
            if (temp >= 0) return letters[temp];
        }
        return letters[0];
    }
}
