package LeetCode.easy;

public class Problem860 {
    //https://leetcode.com/problems/lemonade-change/
    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[]{5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5}));
    }

    //https://leetcode.com/problems/lemonade-change/solutions/3793528/java-straightforward-solution/
    //15 min
    //Runtime
    //Details
    //2ms
    //Beats 81.66%of users with Java
    //Memory
    //Details
    //56.72mb
    //Beats 63.74%of users with Java
    static int[] coins;

    static boolean lemonadeChange(int[] bills) {
        refreshCoins();
        for (int n : bills) {
            switch (n) {
                case 20: {
                    if (coins[1] > 0 && coins[0] > 0) {
                        coins[2]++;
                        coins[1]--;
                        coins[0]--;
                    } else if (coins[0] > 2) {
                        coins[2]++;
                        coins[0] -= 3;
                    } else return false;
                    break;
                }
                case 10: {
                    if (coins[0] < 1) {
                        return false;
                    } else {
                        coins[1]++;
                        coins[0]--;
                        break;
                    }
                }
                default: {
                    coins[0]++;
                }
            }
        }
        return true;
    }

    private static void refreshCoins() {
        if (coins == null) {
            coins = new int[3];
        } else {
            coins[0] = 0;
            coins[1] = 0;
            coins[2] = 0;
        }
    }
}
