package LeetCode.medium;

public class Problem357 {
    //https://leetcode.com/problems/count-numbers-with-unique-digits/description/
    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(0));
        System.out.println(countNumbersWithUniqueDigits(1));
        System.out.println(countNumbersWithUniqueDigits(2));
        System.out.println(countNumbersWithUniqueDigits(3));
        System.out.println(countNumbersWithUniqueDigits(4));
        System.out.println(countNumbersWithUniqueDigits(5));
    }

    //https://leetcode.com/problems/count-numbers-with-unique-digits/solutions/2957098/java-100-faster-solution/
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //38.8 MB
    //Beats
    //96.63%
    //1 hour
    static int[] res;
    static int countNumbersWithUniqueDigits(int n) {
        if (res == null) initArray();
        return res[n];
    }

    private static void initArray() {
        res = new int[9];
        res[0] = 1;
        res[1] = 10;
        for (int i = 2; i < res.length; i++) {
            int mult = 9;
            for (int j = 9; j > 9 - i + 1; j--) {
                mult *= j;
            }
            res[i] = mult + res[i - 1];
        }
    }
}
