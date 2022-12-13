package LeetCode.easy;

public class Problem1550 {
    //https://leetcode.com/problems/three-consecutive-odds/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/three-consecutive-odds/solutions/2906254/java-o-n-1-ms-solution/
    //5-10min
    //Runtime
    //1 ms
    //Beats
    //46.47%
    //Memory
    //43.4 MB
    //Beats
    //6.36%
    static boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++) {
            boolean isOdd1 = arr[i] % 2 == 1;
            boolean isOdd2 = arr[i + 1] % 2 == 1;
            boolean isOdd3 = arr[i + 2] % 2 == 1;
            if (isOdd1 && isOdd2 && isOdd3) return true;
        }
        return false;
    }
}
