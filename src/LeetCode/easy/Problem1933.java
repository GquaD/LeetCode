package LeetCode.easy;

public class Problem1933 {
    //https://leetcode.com/problems/check-if-string-is-decomposable-into-value-equal-substrings
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/check-if-string-is-decomposable-into-value-equal-substrings/solutions/6328172/java-on-solution-by-tbekpro-f16o/
    //5min
    //Runtime
    //1
    //ms
    //Beats
    //83.93%
    //Analyze Complexity
    //Memory
    //41.72
    //MB
    //Beats
    //53.57%
    public boolean isDecomposable(String s) {
        int count = 1;
        char prev = s.charAt(0);
        boolean twoUsed = false;
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (count % 3 == 0) {
                prev = cur;
                count = 1;
                continue;
            }
            if (prev == cur) {
                count++;
                prev = cur;
            } else {
                if (count % 2 == 0) {
                    if (twoUsed) return false;
                    else {
                        twoUsed = true;
                        count = 1;
                        prev = cur;
                    }
                } else return false;
            }
        }
        if (!twoUsed && count == 2) {
            return true;
        }
        return count > 1 && twoUsed;
    }
}
