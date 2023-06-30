package LeetCode.easy;

public class Problem2744 {
    //https://leetcode.com/problems/find-maximum-number-of-string-pairs/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-maximum-number-of-string-pairs/solutions/3700643/java-100-faster-solution/
    //2min
    //Runtime
    //1 ms
    //Beats
    //100%
    //Memory
    //41.5 MB
    //Beats
    //81.79%
    static int maximumNumberOfStringPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].charAt(0) == words[j].charAt(1) && words[i].charAt(1) == words[j].charAt(0)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
