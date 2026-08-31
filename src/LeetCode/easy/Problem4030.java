package LeetCode.easy;

public class Problem4030 {
    //2min

    //Runtime
    //11
    //ms
    //Beats
    //38.69%
    //Memory
    //46.62
    //MB
    //Beats
    //29.34%

    public boolean isPalindromic(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            sb.append(binary(s.charAt(i)));
        }

        return isPalindrome(sb.toString());
    }

    private String binary(char c) {
        return String.format("%8s", Integer.toBinaryString((int)c)).replace(' ', '0');
    }

    private boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i))
                return false;
        }

        return true;
    }
}
