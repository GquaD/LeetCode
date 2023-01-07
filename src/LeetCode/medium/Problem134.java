package LeetCode.medium;

public class Problem134 {
    //https://leetcode.com/problems/gas-station/description/
    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{7,1,0,11,4}, new int[]{5,9,1,2,5}));
        System.out.println(canCompleteCircuit(new int[]{3,1,1}, new int[]{1,2,2}));
        System.out.println(canCompleteCircuit(new int[]{5,1,2,3,4}, new int[]{4,4,1,5,1}));
        System.out.println(canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        System.out.println(canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
        System.out.println(canCompleteCircuit(new int[]{5, 8, 2, 8}, new int[]{6, 5, 6, 6}));
    }

    //https://leetcode.com/problems/gas-station/solutions/3012210/java-o-n-solution/
    //1-2 hours
    //Runtime
    //2 ms
    //Beats
    //89.77%
    //Memory
    //62.9 MB
    //Beats
    //61.39%
    static int canCompleteCircuit(int[] gas, int[] cost) {
        int idx = 0, sumG = 0, sumC = 0, sum = 0;
        for (int i = 0; i < gas.length; i++) {
            sumG += gas[i];
            sumC += cost[i];
            sum += gas[i] - cost[i];
            if (sum < 0) {
                idx = i + 1;
                sum = 0;
            }
        }
        if (sumG < sumC) return -1;
        return idx;
    }

    static int canCompleteCircuit1(int[] gas, int[] cost) {
        int sumG = 0, sumC = 0, idx = cost.length, prev = gas[0];
        for (int i = 0; i < gas.length - 1; i++) {
            sumG += gas[i];
            sumC += cost[i];
            cost[i] = gas[i + 1] - cost[i] + prev;
            prev = cost[i];
        }
        sumG += gas[gas.length - 1];
        sumC += cost[cost.length - 1];
        cost[cost.length - 1] = gas[gas.length - 1] + gas[0] - cost[cost.length - 1] + prev;
        if (sumG < sumC) return -1;

        for (int i = cost.length - 1; i >= 0; i--) {
            if (cost[i] < 0) break;
            idx--;
        }
        return idx;
        //I need to just have another array where I will store gas[i] - cost[i]
        //the answer will be the index starting from which all next
        //values will be >= 0.
    }
}
