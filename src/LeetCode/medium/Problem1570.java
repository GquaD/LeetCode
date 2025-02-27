package LeetCode.medium;

public class Problem1570 {
    //https://leetcode.com/problems/dot-product-of-two-sparse-vectors
    public static void main(String[] args) {

    }


}

//5min
//Runtime
//8
//ms
//Beats
//79.58%
//Analyze Complexity
//Memory
//59.00
//MB
//Beats
//13.66%
//class SparseVector {
//    Map<Integer, Integer> map;
//    SparseVector(int[] nums) {
//        map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != 0) map.put(i, nums[i]);
//        }
//    }
//
//    public int dotProduct(SparseVector vec) {
//        int result = 0;
//        for (Integer idx: map.keySet()) {
//            if (vec.map.containsKey(idx)) {
//                result += map.get(idx) * vec.map.get(idx);
//            }
//        }
//        return result;
//    }
//}

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
