package LeetCode.medium;

public class Problem3163 {
    //https://leetcode.com/problems/string-compression-iii/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/string-compression-iii/solutions/5235297/java-o-n-solution/
    //5min
    //Runtime
    //18
    //ms
    //Beats
    //69.63%
    //of users with Java
    //Memory
    //45.58
    //MB
    //Beats
    //82.03%
    //of users with Java
    public String compressedString(String word) {
        int count = 1;
        char t = word.charAt(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < word.length(); i++) {
            char c = word.charAt(i);
            if (t == c) {
                count++;
                if (count == 10) {
                    sb.append(9);
                    sb.append(c);
                    count = 1;
                }
            } else {
                sb.append(count);
                sb.append(t);
                count = 1;
                t = c;
            }
        }

        sb.append(count);
        sb.append(t);

        return sb.toString();
    }
}
