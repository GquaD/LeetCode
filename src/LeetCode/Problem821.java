package LeetCode;

import java.util.Arrays;

public class Problem821 {
    //https://leetcode.com/problems/shortest-distance-to-a-character/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestToChar("loveleetcode", 'e')));
        System.out.println(Arrays.toString(shortestToChar("aaab", 'b')));
        System.out.println(Arrays.toString(shortestToChar("baaa", 'b')));
    }

    //Runtime: 3 ms, faster than 45.97% of Java online submissions for Shortest Distance to a Character.
    //Memory Usage: 43.5 MB, less than 28.48% of Java online submissions for Shortest Distance to a Character.
    static int[] shortestToChar(String s, char c) {
        int[] forward = shortestToCharForward(s, c);
        s = revert(s);
        int[] backward = shortestToCharForward(s, c);
        backward = revertArray(backward);
        //int[] backward = shortestToCharBackward(s, c);
        for (int i = 0; i < forward.length; i++) {
            forward[i] = Math.min(forward[i], backward[i]);
        }
        return forward;
    }

    private static int[] revertArray(int[] backward) {
        for (int i = 0; i < backward.length / 2; i++) {
            int temp = backward[i];
            backward[i] = backward[backward.length - 1 - i];
            backward[backward.length - 1 - i] = temp;
        }
        return backward;
    }

    static int[] shortestToCharForward(String s, char c) {
        int[] arr = new int[s.length()];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            arr[i] = Math.abs(s.indexOf(c, index) - i);
            if (arr[i] == 0) {
                index = i + 1;
            }
        }
        return arr;
    }

    static String revert(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
