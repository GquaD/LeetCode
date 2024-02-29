package LeetCode.medium;

public class Problem3064 {
    //https://leetcode.com/problems/guess-the-number-using-bitwise-questions-i
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/guess-the-number-using-bitwise-questions-i/solutions/4799973/java-o-logn-solution/
    //10min
    //Runtime
    //4
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //41.21
    //MB
    //Beats
    //100.00%
    //of users with Java
    /*static int findNumber() {
        int n = 1;
        StringBuilder sb = new StringBuilder();
        for (int pow = 1; pow <= 30; pow++) {
            if (commonSetBits(n) == 1) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            n *= 2;
        }
        return Integer.parseInt(sb.reverse().toString(),2);
    }*/
}
