package LeetCode.easy;

public class Problem1945 {
    //https://leetcode.com/problems/sum-of-digits-of-string-after-convert/
    public static void main(String[] args) {
        System.out.println(getLucky("iiii", 1));
        System.out.println(getLucky("zbax", 2));
    }

    //https://leetcode.com/problems/sum-of-digits-of-string-after-convert/solutions/3445639/java-1ms-solution/
    //5-10 min
    //Runtime
    //1 ms
    //Beats
    //96.5%
    //Memory
    //40.9 MB
    //Beats
    //77.26%
    static int getLucky(String s, int k) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) sum += sumOfDigits(s.charAt(i) - 'a' + 1);
        while (--k > 0) sum = sumOfDigits(sum);
        return sum;
    }

    private static int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
