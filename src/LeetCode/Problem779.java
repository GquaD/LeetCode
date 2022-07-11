package LeetCode;

public class Problem779 {
    //https://leetcode.com/problems/k-th-symbol-in-grammar/
    //todo
    public static void main(String[] args) {
        System.out.println(kthGrammar(1,1));
        System.out.println(kthGrammar(2, 1));
        System.out.println(kthGrammar(2, 2));
        System.out.println(kthGrammar(30, 434991989));
    }


    //time exceeded
    public static int kthGrammar(int n, int k) {
        String result = "0";
        for (int i = 1; i <= n ; i++) {
            result = generate(result);
        }
        return Integer.parseInt(result.charAt(k - 1) + "");
        /*if (n == 1) return "0";
        if (n == 2) return "01";
        //if (n == 3) return 110;
        if (k == 1) return "0";
        if (k == 2) return "1";
        return */
    }

    private static String generate(String result) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == '0') {
                sb.append("01");
            } else {
                sb.append("10");
            }
        }
        return sb.toString();
    }
}
