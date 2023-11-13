package LeetCode.medium;

public class Problem1404 {
    //https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/
    public static void main(String[] args) {

    }

    //nnnn
    //5min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //40.3 MB
    //Beats
    //54.32%
    //division by two is the same as the right shift by one bit (character).
    static int numSteps(String s) {
        int res = 0, carry = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            ++res;
            if (s.charAt(i) - '0' + carry == 1) {
                carry = 1;
                ++res;
            }
        }
        return res + carry;
    }


    //num's length can be 500
    static int numSteps1(String s) {
        int n = Integer.parseInt(s, 2), count = 0;
        while (n > 1) {
            if (n % 2 == 0) n /= 2;
            else n++;
            count++;
        }
        return count;
    }
}
