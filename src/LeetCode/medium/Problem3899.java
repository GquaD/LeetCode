package LeetCode.medium;

public class Problem3899 {
    //10min

    //Runtime
    //2
    //ms
    //Beats
    //99.06%
    //Memory
    //49.28
    //MB
    //Beats
    //63.75%
    //https://leetcode.com/problems/angles-of-a-triangle/solutions/8345142/my-math-solution-by-tbekpro-85yl/
    public double[] internalAngles(int[] sides) {
        int a = sides[0], b = sides[1], c = sides[2];
        if (!(a + b > c && a + c > b && b + c > a)) return new double[]{};

        int max = Math.max(a, Math.max(b, c)), min = Math.min(a, Math.min(b, c)), mid = a + b + c - max - min;

        //cosine formula
        double cc = (min * min + mid * mid - max * max) / (2.0 * min * mid);
        double aa = (mid * mid + max * max - min * min) / (2.0 * mid * max);

        cc = Math.toDegrees(Math.acos(cc));
        aa = Math.toDegrees(Math.acos(aa));

        return new double[]{aa, 180 - cc - aa, cc};
    }
}
