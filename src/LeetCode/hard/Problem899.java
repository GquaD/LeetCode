package LeetCode.hard;

public class Problem899 {
    //https://leetcode.com/problems/orderly-queue/
    public static void main(String[] args) {

    }

    //todo
    //todo
    static String orderlyQueue(String s, int k) {
        if (k == 1) {
            char c = 'z'; //smallest char
            for (int i = 0; i < s.length(); i++) {
                if (c > s.charAt(i)) c = s.charAt(i);
            }
            int max = 0;
            if (s.charAt(s.length() - 1) == c && s.charAt(0) == c) {
                int count = 0;
                while (s.charAt(count) == c) count++;
                int idx = s.length() - 1;
                while (s.charAt(idx--) == c) count++;
                if (count > max) max = count;
                for (int i = 1; i < s.length(); i++) {
//                    if (s.charAt(i) == )
                }
            }
        }
        return "";
    }
}
