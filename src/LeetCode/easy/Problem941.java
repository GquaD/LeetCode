package LeetCode.easy;

public class Problem941 {
    //https://leetcode.com/problems/valid-mountain-array/
    public static void main(String[] args) {
        System.out.println(validMountainArray(new int[]{1,2,3,4}));
        System.out.println(validMountainArray(new int[]{4, 3, 2, 1}));
        System.out.println(validMountainArray(new int[]{3, 5, 5}));
    }

    //https://leetcode.com/problems/valid-mountain-array/solutions/3200392/java-100-faster-solution/
    //10 min
    //Runtime
    //1 ms
    //Beats
    //100%
    //Memory
    //43.5 MB
    //Beats
    //31.4%
    static boolean validMountainArray(int[] arr) {
        if (arr.length < 3) return false;
        int idx = -1;
        for (int i = 1; i < arr.length; i++) {
            int prev = arr[i - 1], curr = arr[i];
            if (curr == prev) return false;
            if (prev > curr) {
                idx = i - 1;
                break;
            }
        }
        if (idx == -1 || idx == 0) return false;
        for (int i = idx + 1; i < arr.length; i++) {
            int prev = arr[i - 1], curr = arr[i];
            if (curr >= prev) return false;
        }
        return idx != -1;
    }
}
