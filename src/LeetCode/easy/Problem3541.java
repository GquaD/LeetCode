package LeetCode.easy;

public class Problem3541 {
    //https://leetcode.com/problems/find-most-frequent-vowel-and-consonant/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-most-frequent-vowel-and-consonant/solutions/6743607/java-on-solution-by-tbekpro-usdg/
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //42.35
    //MB
    //Beats
    //89.70%
    public int maxFreqSum(String s) {
        int maxv = 0, maxc = 0, arr[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            arr[c - 'a']++;
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                if (maxv < arr[c - 'a']) {
                    maxv = arr[c - 'a'];
                }
            } else if (maxc < arr[c - 'a']) {
                maxc = arr[c - 'a'];
            }
        }

        return maxc + maxv;
    }
}
