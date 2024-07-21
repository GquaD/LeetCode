package LeetCode.medium;

public class Problem3228 {
    //https://leetcode.com/problems/maximum-number-of-operations-to-move-ones-to-the-end/


    //https://leetcode.com/problems/maximum-number-of-operations-to-move-ones-to-the-end/solutions/5511533/java-o-n-100-faster-one-run-solution/
    //10min
    //Runtime
    //7
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //45.18
    //MB
    //Beats
    //66.67%
    public int maxOperations(String s) {
        int num1 = 0, sum = 0;
        boolean zeroCounted = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                num1++;
                zeroCounted = false;
            } else if (!zeroCounted) {
                sum += num1;
                zeroCounted = true;
            }
        }
        return sum;
    }
}
