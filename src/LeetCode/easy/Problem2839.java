package LeetCode.easy;

public class Problem2839 {
    //https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-i/
    public static void main(String[] args) {

    }

    //5-10min
    //https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-i/solutions/6678343/java-on-solution-for-any-length-by-tbekp-yj5i/
    //Runtime
    //1
    //ms
    //Beats
    //98.46%
    //Analyze Complexity
    //Memory
    //43.22
    //MB
    //Beats
    //8.11%
    public boolean canBeEqual(String s1, String s2) {
        int[] even = new int[26], odd = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            if (i % 2 == 0) {
                even[s1.charAt(i) - 'a']++;
            } else {
                odd[s1.charAt(i) - 'a']++;
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            if (i % 2 == 0) {
                even[s2.charAt(i) - 'a']--;
            } else {
                odd[s2.charAt(i) - 'a']--;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (even[i] != 0 || odd[i] != 0) return false;
        }
        return true;
    }
}
