package LeetCode.easy;

public class Problem1897 {
    //https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/solutions/3158239/java-o-n-k-solution/
    //5min
    //Runtime
    //2 ms
    //Beats
    //99.43%
    //Memory
    //42.1 MB
    //Beats
    //60.80%
    static boolean makeEqual(String[] words) {
        int[] alph = new int[26];
        for (String word : words) for (char c : word.toCharArray()) alph[c - 'a']++;
        for (int n : alph) if (n % words.length != 0) return false;
        return true;
    }
}
