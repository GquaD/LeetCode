package LeetCode.easy;

public class Problem1598 {
    //https://leetcode.com/problems/crawler-log-folder/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/crawler-log-folder/solutions/2838141/java-easy-peasy-lemon-squeezy-solution/
    //Runtime
    //2 ms
    //Beats
    //77.95%
    //Memory
    //43.4 MB
    //Beats
    //7.68%
    static int minOperations(String[] logs) {
        int count = 0;
        for (String move : logs) {
            switch (move) {
                case "../": {
                    if (count > 0)
                        count--;
                    break;
                }
                case "./": {
                    break;
                }
                default: {
                    count++;
                }
            }
        }
        return count;
    }
}
