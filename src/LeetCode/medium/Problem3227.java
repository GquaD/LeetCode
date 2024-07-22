package LeetCode.medium;

public class Problem3227 {
    //https://leetcode.com/problems/vowels-game-in-a-string/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/vowels-game-in-a-string/solutions/5516554/java-o-n-solution/
    //5min
    //Runtime
    //7
    //ms
    //Beats
    //66.67%
    //Analyze Complexity
    //Memory
    //45.40
    //MB
    //Beats
    //66.67%
    public boolean doesAliceWin(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count != 0;
    }
}
