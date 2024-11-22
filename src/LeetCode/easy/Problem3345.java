package LeetCode.easy;

public class Problem3345 {
    //https://leetcode.com/problems/smallest-divisible-digit-product-i/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/smallest-divisible-digit-product-i/solutions/6071830/java-super-simple-solution/
    //1min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //40.51
    //MB
    //Beats
    //95.02%
    public int smallestNumber(int n, int t) {
        while (n <= 100) {
            if (digitsProduct(n++) % t == 0)
                return n - 1;
        }
        return n;
    }

    private int digitsProduct(int n) {
        int prod = 1;
        while (n > 0) {
            prod *= n % 10;
            n /= 10;
        }
        return prod;
    }
}
