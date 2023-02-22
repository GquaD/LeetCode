package LeetCode.medium;

import java.util.PriorityQueue;

public class Problem1011 {
    //https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[]{10,50,100,100,50,100,100,100}, 5));
        System.out.println(shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5));
        System.out.println(shipWithinDays(new int[]{3,2,2,4,1,4}, 3));
        System.out.println(shipWithinDays(new int[]{1,2,3,1,1}, 4));
    }

    //https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/solutions/3218671/java-binary-search-o-n-nlogn-solution/
    //40min
    //NlogN
    //Runtime
    //10 ms
    //Beats
    //62.60%
    //Memory
    //45.3 MB
    //Beats
    //99.2%
    static int shipWithinDays(int[] weights, int days) {
        int sum = 0, max = 0;
        for (int n : weights) {
            sum += n;
            if (max < n) max = n;
        }
        int left = max, right = sum;
        if (canShip(max, weights, days)) return max;
        int cap = sum;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (canShip(mid, weights, days)) {
                if (cap > mid) cap = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return cap;
    }

    //Runtime
    //11 ms
    //Beats
    //46.12%
    //Memory
    //55.2 MB
    //Beats
    //5.90%
    static int shipWithinDays1(int[] weights, int days) {
        int sum = 0, max = 0;
        for (int n : weights) {
            sum += n;
            if (max < n) max = n;
        }
        //if (max <= days) return (int) Math.ceil(sum * 1.0 / days);
        int left = max, right = sum;
        if (canShip(max, weights, days)) return max;
        PriorityQueue<Integer> caps = new PriorityQueue<>();
        caps.offer(sum);
        while (left <= right) {
            int mid = (right + left) / 2;
            if (canShip(mid, weights, days)) {
                caps.offer(mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return caps.poll();
    }

    private static boolean canShip(int capacity, int[] weights, int days) {
        int sum = weights[0], countDays = 0;
        for (int i = 1; i < weights.length; i++) {
            if (sum + weights[i] > capacity) {
                countDays++;
                sum = weights[i];
            } else {
                sum += weights[i];
            }
        }
        if (sum > 0) countDays++;
        return countDays <= days;
    }
}
