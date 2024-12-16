package LeetCode.medium;

public class Problem1999 {
    //https://leetcode.com/problems/smallest-greater-multiple-made-of-two-digits
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/smallest-greater-multiple-made-of-two-digits/solutions/6152483/java-recursive-solution-by-tbekpro-tcxc/
    //20min
    //Runtime
    //22
    //ms
    //Beats
    //14.29%
    //Analyze Complexity
    //Memory
    //44.44
    //MB
    //Beats
    //9.62%
    public int findInteger(int k, int a, int b) {
        StringBuilder sb = new StringBuilder();
        int[] res = new int[] { -1 };
        goRec(sb, k, a, b, res);
        return res[0];
    }

    private void goRec(StringBuilder sb, int k, int a, int b, int[] res) {
        if (sb.length() > 10) {
            return;
        }

        sb.append(a);
        if (!(sb.length() == 10 && sb.charAt(0) > '1')) {
            Long t = Long.parseLong(sb.toString());
            if (t <= Integer.MAX_VALUE && t > k && t % k == 0) {
                if (res[0] == -1)
                    res[0] = (int) t.longValue();
                else
                    res[0] = Math.min(res[0], (int) t.longValue());
            }
            goRec(sb, k, a, b, res);
        }

        sb.setLength(sb.length() - 1);
        sb.append(b);
        if (!(sb.length() == 10 && sb.charAt(0) > '1')) {
            Long t = Long.parseLong(sb.toString());
            if (t <= Integer.MAX_VALUE && t > k && t % k == 0) {
                if (res[0] == -1)
                    res[0] = (int) t.longValue();
                else
                    res[0] = Math.min(res[0], (int) t.longValue());
            }
            goRec(sb, k, a, b, res);
        }

        sb.setLength(sb.length() - 1);
    }
}
