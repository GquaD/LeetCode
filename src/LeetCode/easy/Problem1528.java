package LeetCode.easy;

import java.util.Arrays;

/**
 * Created by Behzod on 28, March, 2021
 */
public class Problem1528 {
    public static void main(String[] args) {
        int[] one = {4,5,6,7,0,2,1,3};
        int[] two = {0,1,2};
        int[] three = {3,1,4,2,0};
        int[] four = {4,0,2,6,7,3,1,5};
        int[] five = {1,0,2};
        System.out.println(restoreString("codeleet", one));
        System.out.println(restoreString("abc", two));
        System.out.println(restoreString("aiohn", three));
        System.out.println(restoreString("aaiougrt", four));
        System.out.println(restoreString("art", five));
    }

    public static String restoreString(String s, int[] indices) {
        char[] arr = new char[s.length()];
        for (int i = 0; i < indices.length; i++) {
            arr[indices[i]] = s.charAt(i);
        }
        return String.valueOf(arr);
    }
}
