package LeetCode.easy;

public class Problem2806 {
    //https://leetcode.com/problems/account-balance-after-rounded-purchase/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/account-balance-after-rounded-purchase/solutions/3882590/java-o-1-solution/
    //5min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //39 MB
    //Beats
    //93.7%
    static int accountBalanceAfterPurchase(int purchaseAmount) {
        if (purchaseAmount % 10 == 0) return 100 - purchaseAmount;
        int less = (purchaseAmount / 10) * 10, more = ((purchaseAmount / 10) + 1) * 10;
        int amount = Math.abs(less - purchaseAmount) < Math.abs(more - purchaseAmount) ? less : more;
        return 100 - amount;
    }
}
