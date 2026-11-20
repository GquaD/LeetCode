package LeetCode.easy;

public class Problem1175 {
    //15min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Memory
    //41.39
    //MB
    //Beats
    //94.51%
    private static int[] arr = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};

    public int numPrimeArrangements(int n) {
        if (n < 2) return 1;
        long result = 1;

        int primes = 0;

        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            if (n < a) {
                break;
            }
            primes = i + 1;
        }

        for (int i = 1; i <= primes; i++) {
            result *= i;
            result %= 1000_000_007;
        }

        for (int i = 1; i <= n - primes; i++) {
            result *= i;
            result %= 1000_000_007;
        }

        return (int) result;
    }
}
