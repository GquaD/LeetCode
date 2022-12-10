package LeetCode.easy;

public class Problem2303 {
    //https://leetcode.com/problems/calculate-amount-paid-in-taxes/
    public static void main(String[] args) {
        System.out.println(calculateTax(new int[][]{
                {2,7},
                {3,17},
                {4,37},
                {7,6},
                {9,83},
                {16,67},
                {19,29},
        }, 18));
        System.out.println(calculateTax(new int[][]{
                {3,50},
                {7,10},
                {12,25}
        }, 10));
    }

    //https://leetcode.com/problems/calculate-amount-paid-in-taxes/solutions/2896039/java-2ms-solution/
    //Runtime
    //2 ms
    //Beats
    //24.85%
    //Memory
    //46.3 MB
    //Beats
    //15.38%
    static double calculateTax(int[][] brackets, int income) {
        double result = 0;
        for (int i = 0; i < brackets.length; i++) {
            int[] group = brackets[i];
            int prevUpper = 0;
            if (i > 0) {
                prevUpper = brackets[i - 1][0];
            }
            int upper = group[0], percent = group[1];
            int sumToTax = upper - prevUpper;
            if (income - sumToTax >= 0) {
                income -= sumToTax;
                result += ((sumToTax * percent) / 100.0);
            } else {
                result += ((income * percent) / 100.0);
                break;
            }
        }
        return result;
    }
}
