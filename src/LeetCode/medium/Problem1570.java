package LeetCode.medium;

public class Problem1570 {
    //https://leetcode.com/problems/dot-product-of-two-sparse-vectors
    public static void main(String[] args) {

    }


}

//5min
//Runtime
//2
//ms
//Beats
//100.00%
//of users with Java
//Memory
//56.69
//MB
//Beats
//79.00%
//of users with Java
class SparseVector {
    public int[] arr;
    SparseVector(int[] nums) {
        arr = nums;
    }

    public int dotProduct(SparseVector vec) {
        int ar2[] = vec.arr, res = 0;
        for (int i = 0; i < ar2.length; i++) {
            if (ar2[i] > 0 && arr[i] > 0) res += arr[i] * ar2[i];
        }
        return res;
    }
}
