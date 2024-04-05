package LeetCode.medium;

public class Problem161 {
    //https://leetcode.com/problems/one-edit-distance/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/one-edit-distance/solutions/4977871/java-100-faster-solution/
    //20min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //41.79
    //MB
    //Beats
    //79.75%
    //of users with Java
    static boolean isOneEditDistance(String s, String t) {
        int count = 0;
        if (s.length() == t.length() - 1) {
            int j = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i), d = t.charAt(j++);
                if (c != d) {
                    if (count == 1) return false;
                    count++;
                    i--;
                }
            }
            return count <= 1;
        } else if (s.length() == t.length() + 1) {
            int j = 0;
            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i), d = s.charAt(j++);
                if (c != d) {
                    if (count == 1) return false;
                    count++;
                    i--;
                }
            }
            return count <= 1;
        } else if (s.length() == t.length()) {
            if (s.length() == 0) return false;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    if (count == 1) return false;
                    count++;
                }
            }
            return count == 1;
        } else return false;
    }
}
