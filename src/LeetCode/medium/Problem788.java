package LeetCode.medium;

public class Problem788 {
    //https://leetcode.com/problems/rotated-digits/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/rotated-digits/solutions/6279175/java-onlogn-solution-by-tbekpro-ohsr/
    //10-15min
    //Runtime
    //5
    //ms
    //Beats
    //47.01%
    //Analyze Complexity
    //Memory
    //42.14
    //MB
    //Beats
    //36.10%
    int[] arr;
    int k;
    public int rotatedDigits(int n) {
        if (arr == null) {
            arr = new int[10_001];
        }
        if (arr[n] != 0) return arr[n];

        for (int i = k + 1; i <= n; i++) {
            if (isGood(i)) {
                arr[i] = arr[i - 1] + 1;
            } else {
                arr[i] = arr[i - 1];
            }
        }

        k = Math.max(n, k);
        //isGood will have isValid
        return arr[n];
    }

    private boolean isGood(int n) {
        boolean isDiff = false;
        while (n > 0) {
            int rem = n % 10;
            if (rem == 3 || rem == 4 || rem == 7) {
                return false;
            } else if (rem == 2 || rem == 5 || rem == 6 || rem == 9) {
                isDiff = true;
            }
            n /= 10;
        }
        return isDiff;
    }
}
