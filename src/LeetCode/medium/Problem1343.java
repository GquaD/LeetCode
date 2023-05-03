package LeetCode.medium;

public class Problem1343 {
    //https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/solutions/3480228/java-o-n-solution/
    //Runtime
    //3 ms
    //Beats
    //86.72%
    //Memory
    //54.2 MB
    //Beats
    //11.13%
    static int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0, res = 0;
        for (int i = 0; i < k; i++) sum += arr[i];
        if (sum / k >= threshold) res++;
        for (int i = 0; i < arr.length; i++) {
            sum -= arr[i];
            if (i + k < arr.length) {
                sum += arr[i + k];
                if (sum / k >= threshold) res++;
            }
        }
        return res;
    }

    //10 min
    //Runtime
    //3 ms
    //Beats
    //86.72%
    //Memory
    //55.2 MB
    //Beats
    //5.41%
    static int numOfSubarrays1(int[] arr, int k, int threshold) {
        int[] arrAvg = new int[arr.length - k + 1];
        int sum = 0;
        for (int i = 0; i < k; i++) sum += arr[i];
        arrAvg[0] = sum / k;
        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            sum -= arr[i];
            if (i + k < arr.length) {
                sum += arr[i + k];
                arrAvg[count++] = sum / k;
            }
        }
        count = 0;
        for (int n : arrAvg) if (n >= threshold) count++;
        return count;
    }
}
