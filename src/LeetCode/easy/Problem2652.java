package LeetCode.easy;

public class Problem2652 {
    //https://leetcode.com/problems/sum-multiples/
    public static void main(String[] args) {
        System.out.println(sumOfMultiples(4));
        System.out.println(sumOfMultiples(7));
        System.out.println(sumOfMultiples(10));
        System.out.println(sumOfMultiples(9));
    }

    //10 min
    //https://leetcode.com/problems/sum-multiples/solutions/3452966/java-100-faster-solution/
    //Runtime
    //1 ms
    //Beats
    //100%
    //Memory
    //39.9 MB
    //Beats
    //58.78%
    static int[] res;
    static int sumOfMultiples(int n) {
        int prev = 0;
        if (res == null) {
            boolean[] mult = new boolean[1001];
            for (int i = 0; i < mult.length; i++) if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) mult[i] = true;
            res = new int[mult.length];
            for (int i = 1; i < mult.length; i++) {
                if (mult[i]) res[i] += prev + i;
                if (res[i] > 0) prev = res[i];
            }
        }
        if (res[n] == 0) while (n > 0 && res[n] == 0) n--;
        return res[n];
    }
}
