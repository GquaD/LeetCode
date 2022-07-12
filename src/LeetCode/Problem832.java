package LeetCode;

import java.util.Arrays;

public class Problem832 {
    //https://leetcode.com/problems/flipping-an-image/
    public static void main(String[] args) {

    }

    //Runtime: 1 ms, faster than 78.28% of Java online submissions for Flipping an Image.
    //Memory Usage: 44.9 MB, less than 39.34% of Java online submissions for Flipping an Image.
    static int[][] flipAndInvertImage1(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            flipH1(image[i]);
        }
        return image;
    }

    static int[] flipH1(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i] == 1 ? 0 : 1;
            arr[arr.length - 1 - i] = temp == 1 ? 0 : 1;
        }
        if (arr.length % 2 == 1) {
            arr[arr.length / 2] = arr[arr.length / 2] == 1 ? 0 : 1;
        }
        return arr;
    }

    static int[] invert1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
        }
        return arr;
    }

    //Runtime: 1 ms, faster than 78.28% of Java online submissions for Flipping an Image.
    //Memory Usage: 45.2 MB, less than 14.56% of Java online submissions for Flipping an Image.
    static int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            flipH(image[i]);
            invert(image[i]);
        }
        return image;
    }

    static int[] flipH(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        return arr;
    }

    static int[] invert(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
        }
        return arr;
    }
}
