package LeetCode.medium;

public class Problem3167 {
    //https://leetcode.com/problems/better-compression-of-string/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/better-compression-of-string/solutions/5230562/java-o-n-100-faster-solution/
    //10-15min
    //Runtime
    //22
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //45.14
    //MB
    //Beats
    //100.00%
    //of users with Java
    public String betterCompression(String com) {
        int[] arr = new int[26];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < com.length(); i++) {
            char c = com.charAt(i);
            if (Character.isLetter(c)) {
                char d = com.charAt(i + 1);
                while (Character.isDigit(d)) {
                    sb.append(d);
                    if (++i >= com.length() - 1)
                        break;
                    d = com.charAt(i + 1);
                }
                arr[c - 'a'] += Integer.parseInt(sb.toString());
                sb.setLength(0);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                sb.append((char) ('a' + i));
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
}
