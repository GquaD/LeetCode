package LeetCode.medium;

public class Problem852 {
    //https://leetcode.com/problems/peak-index-in-a-mountain-array/

    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[]{18,29,38,59,98,100,99,98,90}));
        System.out.println(peakIndexInMountainArray(new int[]{0,1,0}));
        System.out.println(peakIndexInMountainArray(new int[]{0,2,1,0}));
        System.out.println(peakIndexInMountainArray(new int[]{0,10,5,2}));
        System.out.println(peakIndexInMountainArray(new int[]{0,6,10,5,2}));
        System.out.println(peakIndexInMountainArray(new int[]{0,6,7,8,10,5,2}));
        System.out.println(peakIndexInMountainArray(new int[]{12,13,19,41,55,69,70,71,96,72}));
    }

    //https://leetcode.com/problems/peak-index-in-a-mountain-array/discuss/2601639/Java-100-faster-solution-or-binary-search-or-explained
    //less than 1 hour
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Peak Index in a Mountain Array.
    //Memory Usage: 75 MB, less than 6.57% of Java online submissions for Peak Index in a Mountain Array.
    static int peakIndexInMountainArray(int[] arr) {
        return findPeakOfMountain(arr, arr.length / 2, arr.length - 1);
    }

    private static int findPeakOfMountain(int[] arr, int index, int prevIdx) {
        if (index == 0 || index == arr.length - 1) {
            return 0;
        }
        int diff = Math.abs(index - prevIdx);
        int halfDiff = diff / 2 > 0 ? diff / 2 : 1;
        if (arr[index - 1] < arr[index] && arr[index] > arr[index + 1]) {
            return index;
        } else if (arr[index - 1] > arr[index] && arr[index] > arr[index + 1]) {
            return findPeakOfMountain(arr, index - halfDiff, index);
        } else {
            return findPeakOfMountain(arr, index + halfDiff, index);
        }
    }
}
