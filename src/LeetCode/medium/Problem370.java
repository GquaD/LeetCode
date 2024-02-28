package LeetCode.medium;

public class Problem370 {
    //https://leetcode.com/problems/range-addition/
    public static void main(String[] args) {

    }

    //nnn
    //Runtime
    //2
    //ms
    //Beats
    //100.00%
    //of users with Java
    //Memory
    //50.11
    //MB
    //Beats
    //32.51%
    //of users with Java
    static int[] getModifiedArray(int len, int[][] updates) {
        int[] arr = new int[len];
        for (int[] u: updates) {
            arr[u[0]] += u[2];
            if (u[1] < len - 1) arr[u[1] + 1] -= u[2];
        }

        for (int i = 1; i < len; i++) arr[i] += arr[i - 1];
        return arr;
    }

    //2min
    //Runtime
    //557
    //ms
    //Beats
    //7.82%
    //of users with Java
    //Memory
    //49.46
    //MB
    //Beats
    //88.48%
    //of users with Java
    static int[] getModifiedArray1(int len, int[][] updates) {
        int[] arr = new int[len];
        for (int[] u: updates) for (int i = u[0]; i <= u[1]; i++) arr[i] += u[2];
        return arr;
    }
}
