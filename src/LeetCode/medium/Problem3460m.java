package LeetCode.medium;

public class Problem3460m {
    //https://leetcode.com/problems/longest-common-prefix-after-at-most-one-removal/description/
    public static void main(String[] args) {

    }


    //https://leetcode.com/problems/longest-common-prefix-after-at-most-one-removal/solutions/6437646/java-on-solution-by-tbekpro-o491/
    //5-10min
    //Runtime
    //8
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //45.90
    //MB
    //Beats
    //100.00%
    public int longestCommonPrefix(String s, String t) {
        int count = 0, idxs = 0, idxt = 0, removal = 0;
        while (idxs < s.length() && idxt < t.length()) {
            if (s.charAt(idxs) == t.charAt(idxt)) {
                count++;
            } else if (removal == 0) {
                removal++;
                idxt--;
            } else {
                break;
            }
            idxs++;
            idxt++;
        }

        return count;
    }
}


