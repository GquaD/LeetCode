package LeetCode.medium;

public class Problem978 {
    //https://leetcode.com/problems/longest-turbulent-subarray/
    public static void main(String[] args) {
        System.out.println(maxTurbulenceSize(new int[]{0,8,45,88,48,68,28,55,17,24}));
        System.out.println(maxTurbulenceSize(new int[]{9,4,2,10,7,8,8,1,9}));
        System.out.println(maxTurbulenceSize(new int[]{4,8,12,16}));
        System.out.println(maxTurbulenceSize(new int[]{4}));
        System.out.println(maxTurbulenceSize(new int[]{9,4,4,10,7,8,8,1,9}));
        System.out.println(maxTurbulenceSize(new int[]{4,4}));
        System.out.println(maxTurbulenceSize(new int[]{4,5}));
    }

    static int maxTurbulenceSize(int[] arr) {
        if (arr.length == 1) return 1;
        if (arr.length == 2) return arr[0] == arr[1] ? 1 : 2;
        int maxCount = 0, count = 1;
        boolean prevIsMore = arr[0] > arr[1];
        for (int i = 1; i < arr.length; i++) {
            int a = arr[i-1], b = arr[i];
            boolean currIsMore = a > b;
            if (prevIsMore != currIsMore) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = a == b ? 1 : 2;
            }
            prevIsMore = currIsMore;
        }
        return Math.max(maxCount, count);
    }

    //https://leetcode.com/problems/longest-turbulent-subarray/solutions/3819930/java-99-faster-keep-previous-condition-in-an-integer-variable/
    //20-25 min
    //Runtime
    //4 ms
    //Beats
    //98.96%
    //Memory
    //47.2 MB
    //Beats
    //52.47%


    //0 is no condition before
    //1 is more
    //2 is less
    //3 is equal
    static int maxTurbulenceSize1(int[] arr) {
        if (arr.length == 1) return 1;
        if (arr.length == 2) return arr[0] == arr[1] ? 1 : 2;
        int maxCount = 0, prevCondition = 0, count = 1;
        for (int i = 1; i < arr.length; i++) {
            int a = arr[i-1], b = arr[i];
            if (prevCondition != 3) {
                int currCond = a > b ? 1 : a < b ? 2 : 3;
                if (currCond != 3) {
                    if (prevCondition != currCond) {
                        count++;
                    } else {
                        maxCount = Math.max(maxCount, count);
                        count = 2;
                    }
                } else {
                    maxCount = Math.max(maxCount, count);
                    count = 1;
                }
                prevCondition = currCond;
            } else {
                int currCond = a > b ? 1 : a < b ? 2 : 3;
                if (currCond != 3) count = 2;
                prevCondition = currCond;
            }
        }
        return Math.max(maxCount, count);
    }
}
