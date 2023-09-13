package LeetCode.hard;

import java.util.Arrays;

public class Problem135 {
    //https://leetcode.com/problems/candy/
    public static void main(String[] args) {
        System.out.println(candy(new int[]{1, 2, 3, 5, 4, 3, 2, 1, 4, 3, 2, 1}));
        System.out.println(candy(new int[]{1, 2, 87, 87, 87, 2, 1}));
        System.out.println(candy(new int[]{1, 0, 2}));
        System.out.println(candy(new int[]{1, 3, 2, 2, 1}));
        System.out.println(candy(new int[]{1, 2, 2}));
    }

    //we have 3 cases:
    //1.prev has equal rating
    //2.prev less than curr
    //3.prev is greater than curr
    //for cases 1 and 2 we just sum rating based on prev = r[i] == r[i - 1] ? 1 : prev + 1;
    //for the third case arithmetic progression sum is used
    //nnnn
    //Runtime
    //2 ms
    //Beats
    //99.93%
    //Memory
    //43.8 MB
    //Beats
    //44.79%
    static int candy(int[] r) {
        int sum = 1, prev = 1, count = 0;
        for (int i = 1; i < r.length; i++) {
            if (r[i] >= r[i - 1]) {
                if (count > 0) {
                    sum += count * (count + 1) / 2;
                    if (count >= prev) sum += count - prev + 1;
                    count = 0;
                    prev = 1;
                }
                prev = r[i] == r[i - 1] ? 1 : prev + 1;
                sum += prev;
            } else {
                count++;
            }
        }
        if (count > 0) {
            sum += count * (count + 1) / 2;
            if (count >= prev) sum += count - prev + 1;
        }
        return sum;
    }

    static int candy1(int[] r) {
        if (r.length == 1) return 1;
        if (r.length == 2) {
            return r[0] == r[1] ? 2 : 3;
        }
        int[] arr = new int[r.length];
        Arrays.fill(arr, 1);
        int half = arr.length / 2;
        for (int i = 1; i <= half; i++) {
            if (r[i - 1] > r[i] && !(arr[i - 1] > arr[i])) {
                arr[i - 1] = arr[i] + 1;
            } else if (r[i - 1] < r[i] && !(arr[i - 1] < arr[i])) {
                arr[i] = arr[i - 1] + 1;
            }
        }

        for (int i = arr.length - 1; i >= half; i--) {
            if (r[i - 1] > r[i] && !(arr[i - 1] > arr[i])) {
                arr[i - 1] = arr[i] + 1;
            } else if (r[i - 1] < r[i] && !(arr[i - 1] < arr[i])) {
                arr[i] = arr[i - 1] + 1;
            }
        }

        return Arrays.stream(arr).sum();
    }
}
