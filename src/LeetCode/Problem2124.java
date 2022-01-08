package LeetCode;

public class Problem2124 {
    public static void main(String[] args) {
        System.out.println(checkString("aaabbb"));
        System.out.println(checkString("abab"));
        System.out.println(checkString("bbb"));
        System.out.println(checkString("a"));
        System.out.println(checkString("aaa"));
    }

    public static boolean checkString(String s) {
        int firstBIndex = findIndexOfFirstB(s), lastAIndex = findLastAIndex(s);
        if (firstBIndex == -1 || lastAIndex == -1) {
            return true;
        }
        return firstBIndex > lastAIndex;
    }

    public static int findIndexOfFirstB(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b' || s.charAt(i) == 'B') {
                return i;
            }
        }
        return -1;
    }

    public static int findLastAIndex(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'A') {
                return i;
            }
        }
        return -1;
    }

}
