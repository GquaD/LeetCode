package LeetCode.medium;

public class Problem443 {
    //https://leetcode.com/problems/string-compression/
    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
    }

    //20-30 min
    //Runtime
    //1 ms
    //Beats
    //98.42%
    //Memory
    //42.3 MB
    //Beats
    //29.22%
    static int compress(char[] chars) {
        if (chars.length == 1) return 1;
        StringBuilder sb = new StringBuilder();
        int start = 0;
        char temp = chars[0];
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (temp != c) {
                sb.append(temp).append(i - start == 1 ? "" : i - start);
                start = i;
                temp = c;
            }
        }

        sb.append(temp).append(chars.length - start == 1 ? "" : chars.length - start);
        char[] chars1 = sb.toString().toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            chars[i] = chars1[i];
        }
        return sb.length();
    }
}
