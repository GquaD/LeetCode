package LeetCode.easy;

import java.util.Random;

public class Problem374 {
    //https://leetcode.com/problems/guess-number-higher-or-lower/description/

    public static void main(String[] args) {
        number = 1702766719;
        System.out.println(guessNumber(2126753390));
    }


    //40 mins
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //40.6 MB
    //Beats
    //60.91%
    static int guessNumber(int n) {
        if (guess(n) == 0) return n;
        if (guess(1) == 0) return 1;
        int right = n - 1, left = 2;
        n /= 2;
        while (guess(n) != 0) {
            int g = guess(n);
            if (g > 0) {
                left = n;
                n = right - (right - n) / 2;
            } else {
                right = n;
                n = left + (n - left) / 2;
            }
        }
        return n;
    }

    private int findPeakOfMountain(int[] arr, int index, int prevIdx) {
        if (index == 0 || index == arr.length - 1) {
            return 0;
        }
        int diff = Math.abs(index - prevIdx);
        int halfDiff = diff / 2 > 0 ? diff / 2 : 1;
        if (arr[index - 1] < arr[index] && arr[index] > arr[index + 1]) {
            return index;
        } else if (arr[index - 1] > arr[index] && arr[index] > arr[index + 1]) {
            return findPeakOfMountain(arr, index - halfDiff, index);
        } else {
            return findPeakOfMountain(arr, index + halfDiff, index);
        }
    }

    static int guessNumber1(int n) {
        if (guess(n) == 0) return n;
        if (guess(1) == 0) return 1;
        int right = n - 1, left = 2;
        n /= 2;
        while (guess(n) != 0) {
            int g = guess(n);
            if (g > 0) {
                left = n;
                if (n + right > 0) {
                    n = (right + n) / 2;
                } else {
                    n = Integer.MAX_VALUE / 2;
                }
            } else if (g < 0) {
                right = n;
                if (n + left > 0) {
                    n = (n + left) / 2;
                } else {
                    n = Integer.MAX_VALUE / 2;
                }
            }
            if (guess(left) == 0) return left;
            if (guess(right) == 0) return right;
        }
        return n;
    }

    static int number;
    static int guess(int n) {
        if (number > n) return 1;
        else if (number < n) return -1;
        else return 0;
    }
}
