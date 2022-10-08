package LeetCode.easy;

public class Problem58 {
    //https://leetcode.com/problems/length-of-last-word/
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(lengthOfLastWord("luffy is still joyboy"));
    }

    //https://leetcode.com/problems/length-of-last-word/solutions/2675920/java-100-faster-in-just-few-lines/
    //less than 10 mins
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //42.3 MB
    //Beats
    //38.9%
    static int lengthOfLastWord(String s) {
        boolean wordStarted = false;
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != ' ') {
                wordStarted = true;
                count++;
            } else if (wordStarted) break;
        }
        return count;
    }
}
