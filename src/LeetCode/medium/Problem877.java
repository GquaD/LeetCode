package LeetCode.medium;

public class Problem877 {
    //https://leetcode.com/problems/stone-game/
    public static void main(String[] args) {
        System.out.println(stoneGame(new int[]{5,3,4,5}));
        System.out.println(stoneGame(new int[]{3,7,2,3}));
        System.out.println(stoneGame(new int[]{3,7,2,3}));
        System.out.println(stoneGame(new int[]{1,2,3,4,5,6}));
        System.out.println(stoneGame(new int[]{1,2,3,7,1,1}));
    }

    //https://leetcode.com/problems/stone-game/discuss/2580469/Java-100-fasteror-in-just-1-line-or-O(1)-solution!!!
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Stone Game.
    //Memory Usage: 41.3 MB, less than 88.90% of Java online submissions for Stone Game.
    static boolean stoneGame(int[] piles) {
        return true;
    }
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Stone Game.
    //Memory Usage: 41.5 MB, less than 86.64% of Java online submissions for Stone Game.
    static boolean stoneGame2(int[] piles) {
        int half = piles.length / 2, countA = 0, countB = 0;;
        for (int i = half - 1; i >= 0; i--) {
            int l = piles[i], r = piles[piles.length - i - 1];
            countA += Math.max(l, r);
            countB += Math.min(l, r);
        }
        return countA > countB;
    }

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Stone Game.
    //Memory Usage: 41.8 MB, less than 69.95% of Java online submissions for Stone Game.
    static boolean stoneGame1(int[] piles) {
        int half = piles.length / 2;
        int countA = 0, countB = 0;
        for (int i = half - 1; i >= 0; i--) {
            if (piles[i] >= piles[piles.length - i - 1]) {
                countA+=piles[i];
                countB+=piles[piles.length - i - 1];
            } else {
                countB+=piles[i];
                countA+=piles[piles.length - i - 1];
            }
        }
        return countA > countB;
    }
}
