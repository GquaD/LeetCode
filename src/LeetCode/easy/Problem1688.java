package LeetCode.easy;

public class Problem1688 {
    //https://leetcode.com/problems/count-of-matches-in-tournament/
    public static void main(String[] args) {
        System.out.println(numberOfMatches(7));
        System.out.println(numberOfMatches(14));
    }

    //Runtime: 1 ms, faster than 51.75% of Java online submissions for Count of Matches in Tournament.
    //Memory Usage: 42.1 MB, less than 5.16% of Java online submissions for Count of Matches in Tournament.
    static int numberOfMatches(int n) {
        int countMatches = 0;
        while (n > 1) {
            if (n % 2 == 1) {
                n /= 2;
                countMatches += n;
                n++;
            } else {
                n /= 2;
                countMatches += n;
            }
        }
        return countMatches;
    }
}
