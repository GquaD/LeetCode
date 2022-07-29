package LeetCode;

public class Problem2255 {
    public static void main(String[] args) {
        System.out.println(countPrefixes(new String[]{"a", "b", "c", "ab", "bc", "abc" }, "abc"));
        System.out.println(countPrefixes(new String[]{"feh","w","w","lwd","c","s","vk","zwlv","n","w","sw","qrd","w","w","mqe","w","w","w","gb","w","qy","xs","br","w","rypg","wh","g","w","w","fh","w","w","sccy"}, "w"));
    }

    //https://leetcode.com/problems/count-prefixes-of-a-given-string/

    //Runtime: 1 ms, faster than 93.72% of Java online submissions for Count Prefixes of a Given String.
    //Memory Usage: 44.2 MB, less than 35.47% of Java online submissions for Count Prefixes of a Given String.
    static int countPrefixes1(String[] words, String s) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (s.startsWith(words[i])) {
                count++;
            }
        }
        return count;
    }

    //Runtime: 2 ms, faster than 42.46% of Java online submissions for Count Prefixes of a Given String.
    //Memory Usage: 44 MB, less than 51.91% of Java online submissions for Count Prefixes of a Given String.
    static int countPrefixes(String[] words, String s) {
        int count = 0;
        boolean isBeginning = true;
        for (int i = 0; i < words.length; i++) {
            isBeginning = true;

            if (words[i].length() > s.length()) {
                continue;
            }

            for (int j = 0; j < words[i].length(); j++) {
                if (words[i].charAt(j) != s.charAt(j)) {
                    isBeginning = false;
                    break;
                }
            }
            if (isBeginning) count++;
        }
        return count;
    }
}
