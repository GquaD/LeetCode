package LeetCode.easy;

public class Problem1952 {
    //https://leetcode.com/problems/three-divisors
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/three-divisors/solutions/6155905/java-if-primes-square-by-tbekpro-8jex/
    //3min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //40.44
    //MB
    //Beats
    //51.32%
    public boolean isThree(int n) {
        int count = 0;
        int sqrt = (int) Math.sqrt(n);
        if (sqrt * sqrt != n) return false;
        for (int i = 1; i < sqrt; i++) {
            if (n % i == 0) count++;
            if (count > 1) return false;
        }
        return count == 1;
    }
}
