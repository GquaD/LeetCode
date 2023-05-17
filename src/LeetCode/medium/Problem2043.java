package LeetCode.medium;

public class Problem2043 {
    //https://leetcode.com/problems/simple-bank-system/
    public static void main(String[] args) {

    }
}

//https://leetcode.com/problems/simple-bank-system/solutions/3536041/java-straightforward-solution/
//10 min
//Runtime
//135 ms
//Beats
//52.15%
//Memory
//83.1 MB
//Beats
//44.50%
class Bank {
    long[] bank;
    public Bank(long[] balance) {
        bank = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (!isAccountValid(account1) || !isAccountValid(account2) || !isValidTransaction(account1, money)) {
            return false;
        } else {
            bank[account1 - 1] -= money;
            bank[account2 - 1] += money;
            return true;
        }
    }

    public boolean deposit(int account, long money) {
        if (!isAccountValid(account)) {
            return false;
        } else {
            bank[account - 1] += money;
            return true;
        }
    }

    public boolean withdraw(int account, long money) {
        if (!isAccountValid(account) || !isValidTransaction(account, money)) {
            return false;
        } else {
            bank[account - 1] -= money;
            return true;
        }
    }

    private boolean isAccountValid(int n) {
        return n >= 1 && n <= bank.length;
    }

    private boolean isValidTransaction(int account1, long money) {
        return money <= bank[account1 - 1];
    }
}
