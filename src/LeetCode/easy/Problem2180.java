package LeetCode.easy;

public class Problem2180 {
    //https://leetcode.com/problems/count-integers-with-even-digit-sum/
    public static void main(String[] args) {
        System.out.println(countEven(4));
        System.out.println(countEven(30));
        System.out.println(countEven(40));
    }

    //https://leetcode.com/problems/count-integers-with-even-digit-sum/solutions/2805376/java-100-faster-solution/
    //15 mins
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //40.9 MB
    //Beats
    //47.8%
    static int[] results = new int[1000];
    static int countEven(int num) {
        if (results[1] == 0) {
            fillResults();
        }
        return results[num - 1];
    }

    private static void fillResults() {
        int count = 0;
        for (int i = 1; i <= 1000; i++) {
            int num = i, sum = 0;
            while (num > 9) {
                sum += num % 10;
                num /= 10;
            }
            if (num > 0) sum += num;
            if (sum == 0) sum = i;
            if (sum % 2 == 0) {
                count++;
            }
            results[i - 1] = count;
        }
    }
}
