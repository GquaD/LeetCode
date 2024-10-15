package LeetCode.easy;

public class Problem2190 {
    //https://leetcode.com/problems/most-frequent-number-following-key-in-an-array
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/most-frequent-number-following-key-in-an-array/solutions/5915683/java-hashmap-solution/
    //2min
    //Runtime
    //3
    //ms
    //Beats
    //62.03%
    //Analyze Complexity
    //Memory
    //44.02
    //MB
    //Beats
    //75.47%
//    public int mostFrequent(int[] nums, int key) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length - 1; i++) {
//            if (nums[i] == key) {
//                map.put(nums[i + 1], map.getOrDefault(nums[i + 1], 0) + 1);
//            }
//        }
//        int maxFreq = 0, max = 0;
//        for (int k : map.keySet()) {
//            int freq = map.get(k);
//            if (freq > maxFreq) {
//                maxFreq = freq;
//                max = k;
//            }
//        }
//        return max;
//    }
}
