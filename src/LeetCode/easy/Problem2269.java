package LeetCode.easy;

public class Problem2269 {
    //https://leetcode.com/problems/find-the-k-beauty-of-a-number/
    public static void main(String[] args) {

    }

    //5min
    //Runtime
    //1
    //ms
    //Beats
    //43.31%
    //Analyze Complexity
    //Memory
    //40.51
    //MB
    //Beats
    //28.23%
    public int divisorSubstrings(int num, int k) {
        String s = String.valueOf(num);
        StringBuilder sb = new StringBuilder();
        int res = 0;
        for (int i = 0; i <= s.length() - k; i++) {
            for (int j = i; j < i + k; j++) {
                sb.append(s.charAt(j));
            }
            Integer n = Integer.parseInt(sb.toString());
            sb.setLength(0);
            if (n != 0 && num % n == 0) res++;
        }
        return res;
    }
}
