package LeetCode.medium;

public class Problem2232 {
    //20min
    //Runtime
    //4
    //ms
    //Beats
    //52.92%
    //Memory
    //43.20
    //MB
    //Beats
    //65.29%
    public String minimizeResult(String expression) {
        String[] split = expression.split("\\+");
        String a = split[0], b = split[1];
        long sum = Long.MAX_VALUE;
        int l = 0, r = b.length() - 1;
        for (int i = 0; i < a.length(); i++) {
            int left1 = 1, left2 = 1;
            String l1 = a.substring(0, i), l2 = a.substring(i, a.length());
            if (l1.length() != 0) left1 = Integer.parseInt(l1);
            if (l2.length() != 0) left2 = Integer.parseInt(l2);

            for (int j = 1; j <= b.length(); j++) {
                int right1 = 1, right2 = 1;
                String r1 = b.substring(0, j), r2 = b.substring(j, b.length());
                if (r1.length() != 0) right1 = Integer.parseInt(r1);
                if (r2.length() != 0) right2 = Integer.parseInt(r2);

                long tempSum = 1L * left1 * right2 * (left2 + right1);
                if (tempSum < sum) {
                    sum = tempSum;
                    l = i;
                    r = a.length() + 1 + j;
                }
            }
        }

        return expression.substring(0, l) + "(" + expression.substring(l, r) + ")" + expression.substring(r, expression.length());
    }
}
