package LeetCode.medium;

import java.util.Arrays;

public class Problem2241 {
    //https://leetcode.com/problems/design-an-atm-machine/
    public static void main(String[] args) {
        /*ATM atm = new ATM();
        atm.deposit(new int[]{0,0,1,2,1});
        System.out.println(Arrays.toString(atm.withdraw(600)));
        atm.deposit(new int[]{0,1,0,1,1});
        System.out.println(Arrays.toString(atm.withdraw(600)));
        System.out.println(Arrays.toString(atm.withdraw(550)));*/
        ATM atm = new ATM();
        int n = 400_000_000;
        atm.deposit(new int[]{n, n, n, n, n});
        System.out.println(Arrays.toString(atm.withdraw(1_000_000_000)));
        /*atm.deposit(new int[]{0,1,0,1,1});
        System.out.println(Arrays.toString(atm.withdraw(600)));
        System.out.println(Arrays.toString(atm.withdraw(550)));*/
    }
}
//nnnn
//Runtime
//143 ms
//Beats
//77.59%
//Memory
//55.4 MB
//Beats
//6.3%
class ATM {

    private int[] nom;
    private long[] counts;

    public ATM() {
        nom = new int[]{20, 50, 100, 200, 500};
        counts = new long[5];
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < banknotesCount.length; i++) counts[i] += banknotesCount[i];
    }

    public int[] withdraw(int amount) {
        int[] toSubstract = new int[5];
        long currentAmount = amount;
        for (int i = 4; i >= 0 ; i--) {
            if (currentAmount > nom[i] * counts[i]) toSubstract[i] = (int) counts[i];
            else toSubstract[i] = (int) currentAmount / nom[i];
            currentAmount += (long) -nom[i] * toSubstract[i];
            if (currentAmount == 0) break;
        }

        if (currentAmount > 0) return new int[]{-1};
        for (int i = 0; i < 5; i++) counts[i] -= toSubstract[i];
        return toSubstract;
    }
}
