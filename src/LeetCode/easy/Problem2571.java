package LeetCode.easy;

public class Problem2571 {
    //https://leetcode.com/problems/minimum-operations-to-reduce-an-integer-to-0/
    public static void main(String[] args) {
        System.out.println(minOperations(1));
        System.out.println(minOperations(2));
        System.out.println(minOperations(3));
        System.out.println(minOperations(4));
        System.out.println(minOperations(5));
        System.out.println(minOperations(6));
        System.out.println(minOperations(7));
        System.out.println(minOperations(8));
        System.out.println(minOperations(39));
        System.out.println(minOperations(54));
    }

    //https://leetcode.com/problems/minimum-operations-to-reduce-an-integer-to-0/solutions/3310741/java-0ms-o-k-logn-100-faster-solution/
    //30 min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //39.1 MB
    //Beats
    //67.70%
    static int minOperations(int n) {
        int closestPowOf2 = findClosestPowOf2(n), count = 1;
        while (Math.abs(closestPowOf2 - n) != 0) {
            n = Math.abs(closestPowOf2 - n);
            closestPowOf2 = findClosestPowOf2(n);
            count++;
        }
        return count;
    }

    private static int findClosestPowOf2(int n) {
        int pow = 0, temp = n;

        while (temp > 1) {
            temp /= 2;
            pow++;
        }

        int min = (int)Math.pow(2, pow), max = (int)Math.pow(2, pow + 1);

        return Math.abs(min - n) < Math.abs(max - n) ? min : max;
    }
}
