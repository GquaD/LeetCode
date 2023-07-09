package LeetCode.easy;

public class Problem2716 {
    //https://leetcode.com/problems/minimize-string-length/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimize-string-length/solutions/3742282/java-100-faster-alphabet-array-3-lines/
    //1 min
    //Runtime
    //5 ms
    //Beats
    //100%
    //Memory
    //43.7 MB
    //Beats
    //90.74%
    static int minimizedStringLength(String s) {
        int alph[] = new int[26], count = 0;
        for (int i = 0; i < s.length(); i++) if (alph[s.charAt(i) - 'a']++ == 0) count++;
        return count;
    }

    //
    //2 min
    //Runtime
    //5 ms
    //Beats
    //100%
    //Memory
    //43.7 MB
    //Beats
    //90.74%
    static int minimizedStringLength1(String s) {
        int alph[] = new int[26], count = 0;
        for (int i = 0; i < s.length(); i++) alph[s.charAt(i) - 'a']++;
        for (int i = 0; i < alph.length; i++) if (alph[i] > 0) count++;
        return count;
    }
}
