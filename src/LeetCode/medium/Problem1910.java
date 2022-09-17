package LeetCode.medium;

public class Problem1910 {
    //https://leetcode.com/problems/remove-all-occurrences-of-a-substring/
    public static void main(String[] args) {
        System.out.println(removeOccurrences("daabcbaabcbc", "abc"));
        System.out.println(removeOccurrences("axxxxyyyyb", "xy"));
    }

    //5-10 mins
    //Runtime: 9 ms, faster than 56.73% of Java online submissions for Remove All Occurrences of a Substring.
    //Memory Usage: 43.1 MB, less than 69.71% of Java online submissions for Remove All Occurrences of a Substring.
    static String removeOccurrences(String s, String p) {
        while (s.contains(p))
            s = s.replaceFirst(p, "");
        return s;
    }
}
