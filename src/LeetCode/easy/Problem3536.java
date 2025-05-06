package LeetCode.easy;

public class Problem3536 {
    //https://leetcode.com/problems/maximum-product-of-two-digits
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/maximum-product-of-two-digits/solutions/6719979/java-olog10n-solution-by-tbekpro-k8od/
    //5min
    //Runtime
    //1
    //ms
    //Beats
    //95.82%
    //Analyze Complexity
    //Memory
    //40.79
    //MB
    //Beats
    //98.90%
    public int maxProduct(int n) {
        int max = 0, max1 = 0;
        while (n > 0) {
            int rem = n % 10;
            if (max < rem) {
                max1 = max;
                max = rem;
            } else if (max1 < rem) {
                max1 = rem;
            }
            n /= 10;
        }
        return max * max1;
    }
}
