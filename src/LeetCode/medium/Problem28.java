package LeetCode.medium;

public class Problem28 {
    //https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("asadbutsad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));
    }

    //https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/solutions/2701316/java-100-faster-in-just-1-line/
    //1 min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //40.3 MB
    //Beats
    //89.68%
    static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
