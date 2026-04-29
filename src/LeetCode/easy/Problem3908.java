package LeetCode.easy;

public class Problem3908 {
    //1min

    //Runtime
    //1
    //ms
    //Beats
    //99.22%
    //Memory
    //42.58
    //MB
    //Beats
    //79.08%
    //https://leetcode.com/problems/valid-digit-number/solutions/8112896/java-solution-by-tbekpro-aeka/
    public boolean validDigit(int n, int x) {
        int times = 0;
        while (n > 9) {
            if (n % 10 == x) times++;
            n /= 10;
        }

        return times > 0 && n != x;
    }
}
