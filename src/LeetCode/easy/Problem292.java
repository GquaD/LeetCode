package LeetCode.easy;

public class Problem292 {
    //https://leetcode.com/problems/nim-game/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/nim-game/solutions/2819920/java-explained-o-1-100-faster-1-line/
    //2 mins
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //41.5 MB
    //Beats
    //6.29%
    static boolean canWinNim(int n) {
        return n % 4 != 0;
    }
    //Explanation
    //1 win, 2 win, 3 win, 4 lose
    //5 win because I can take 1 and there 4 stones left, which is loosing condition
    //6 win, since I can take 2
    //7 win, since I can take 3
    //8 lose, since I can't make it left 4 stones, since my max move is removing only 3 stones.
    //The rest is induction
}
