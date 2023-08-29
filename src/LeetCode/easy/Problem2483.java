package LeetCode.easy;

public class Problem2483 {
    //https://leetcode.com/problems/minimum-penalty-for-a-shop/
    public static void main(String[] args) {
        System.out.println(bestClosingTime("YYNY"));
        System.out.println(bestClosingTime("NNNN"));
        System.out.println(bestClosingTime("YYYY"));
    }

    //https://leetcode.com/problems/minimum-penalty-for-a-shop/solutions/3976449/java-o-n-solution/
    //10 min
    //Runtime
    //13 ms
    //Beats
    //62.29%
    //Memory
    //43.7 MB
    //Beats
    //99.66%
    static int bestClosingTime(String c) {
        int countY = 0;
        for (int i = 0; i < c.length(); i++) if (c.charAt(i) == 'Y') countY++;
        int minPenalty = countY, idx = 0, penalty = minPenalty;
        for (int i = 0; i < c.length(); i++) {
            if (c.charAt(i) == 'N') penalty++;
            else penalty--;
            if (minPenalty > penalty) {
                minPenalty = penalty;
                idx = i + 1;
            }
        }
        return idx;
    }
}
