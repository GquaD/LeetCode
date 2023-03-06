package LeetCode.easy;

public class Problem1539 {
    //https://leetcode.com/problems/kth-missing-positive-number/description/
    public static void main(String[] args) {
        System.out.println(findKthPositive(new int[]{2,3,4,7,11}, 5));
    }

    //https://leetcode.com/problems/kth-missing-positive-number/solutions/3262861/java-100-faster-solution/
    //20 min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //41.6 MB
    //Beats
    //80.35%
    static int findKthPositive(int[] arr, int k) {
        int count = 0;
        if (arr[0] != 1) {
            int temp = 1;
            while (arr[0] != temp) {
                temp++;
                count++;
                if (count == k) {
                    return temp;
                }
            }
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != 1) {
                int temp = arr[i - 1];
                while (arr[i] - 1 != temp) {
                    temp++;
                    count++;
                    if (count == k) {
                        return temp;
                    }
                }
            }
        }
        int temp = arr[arr.length - 1];
        for (int i = count; i < k; i++) {
            temp++;
            count++;
        }
        return temp;
    }
}
