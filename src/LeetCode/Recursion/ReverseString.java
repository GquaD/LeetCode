package LeetCode.Recursion;

import java.util.Arrays;

public class ReverseString {
    //task
    //Write a function that reverses a string. The input string is given as an array of characters s.
    //You must do this by modifying the input array in-place with O(1) extra memory.
    public static void main(String[] args) {
        String word = "Hello";
        char[] my = word.toCharArray();
        System.out.print("\n" + word + " reversed: ");
        reverseString(my);


    }

    public static void reverseString(char[] s) {
        char[] result = new char[s.length];

        recursive(s.length - 1, s);
        /*recursiveArray(s.length - 1, s, result);
        System.out.println("\nReversed array: ");
        s = result;
        System.out.println(Arrays.toString(s));
        */

        //best solution
        System.out.println("\nReversed array #2: ");
        recursiveArray1(s.length - 1, s);
        System.out.println(Arrays.toString(s));
    }

    static void recursive(int index, char[] s) {
        if (index < 0) return;
        System.out.print(s[index]);
        recursive(index - 1, s);
    }

    static void recursiveArray(int index, char[] s, char[] result) {
        if (index < 0) {
            return;
        }
        result[result.length - index - 1] = s[index];
        //System.out.print(s[index]);
        recursiveArray(index - 1, s, result);
    }

    static void recursiveArray1(int index, char[] s) {
        if (index < s.length / 2) {
            return;
        }

        char temp = s[index];
        s[index] = s[s.length - index - 1];
        s[s.length - index - 1] = temp;

        recursiveArray1(index - 1, s);
    }


}
