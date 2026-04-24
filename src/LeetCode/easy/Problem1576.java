package LeetCode.easy;

public class Problem1576 {
    //10min

    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Memory
    //44.10
    //MB
    //Beats
    //23.10%
    //https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/solutions/8094637/java-100-fast-solution-by-tbekpro-27jv/
    private static char[] alph = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
            'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

    public String modifyString(String s) {
        StringBuilder sb = new StringBuilder();

        char k = s.charAt(0);
        if (k == '?') {
            k = s.length() == 1 ? chooseLetter(' ', ' ') : chooseLetter(' ', s.charAt(1));
        }
        sb.append(k);

        for (int i = 1; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            if (c == '?')
                c = chooseLetter(sb.charAt(sb.length() - 1), s.charAt(i + 1));
            sb.append(c);
        }

        if (s.length() > 1) {
            k = s.charAt(s.length() - 1);
            if (k == '?')
                k = chooseLetter(' ', sb.charAt(sb.length() - 1));
            sb.append(k);
        }

        return sb.toString();
    }

    private char chooseLetter(char a, char b) {
        for (int i = 0; i < 26; i++) {
            if (a != alph[i] && b != alph[i]) {
                return alph[i];
            }
        }
        return 'z';
    }
}
