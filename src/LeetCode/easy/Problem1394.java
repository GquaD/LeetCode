package LeetCode.easy;

public class Problem1394 {
    //https://leetcode.com/problems/find-lucky-integer-in-an-array/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-lucky-integer-in-an-array/solutions/2887806/java-from-94-to-100-faster-solution/
    //Runtime
    //1 ms
    //Beats
    //100%
    //Memory
    //42 MB
    //Beats
    //86.43%
    static int[] count = new int[501];
    static int findLucky(int[] arr) {
        for (int n : arr) {
            count[n]++;
        }
        int max = -1;
        for (int i = 1; i < count.length; i++) {
            if (count[i] == i) max = i;
        }
        clearArray();
        return max;
    }

    private static void clearArray() {
        for (int i = 0; i < count.length; i++) {
            count[i] = 0;
        }
    }


    //5 min
    //Runtime
    //2 ms
    //Beats
    //94.2%
    //Memory
    //44.5 MB
    //Beats
    //8.66%
    //static int[] count = new int[501];
    static int findLucky1(int[] arr) {
        int[] count = new int[501];
        for (int n : arr) {
            count[n]++;
        }
        int max = -1;
        for (int i = 1; i < count.length; i++) {
            if (count[i] == i) max = i;
        }
        return max;
    }
}
