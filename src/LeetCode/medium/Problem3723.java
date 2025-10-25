package LeetCode.medium;

public class Problem3723 {
    //https://leetcode.com/problems/maximize-sum-of-squares-of-digits/solutions/7300706/java-fastest-solution-by-tbekpro-y8va/
    //Runtime
    //2401
    //ms
    //Beats
    //-%
    //Analyze Complexity
    //Memory
    //88.84
    //MB
    //Beats
    //-%

    public String maxSumOfSquares(int num, int sum) {
        if (sum > num * 9) return "";
        String[] arr = new String[]{""};
        StringBuilder sb = new StringBuilder();
        long[] maxScore = new long[1];

        calcMax(sb, num, sum, arr, 0L, maxScore);
        return arr[0];
    }

    private void calcMax(StringBuilder sb, int num, int sum, String[] arr, long score, long[] maxScore) {
        if (maxScore[0] > 0) return;
        if (sum > num * 9 || sum < 0)
            return;

        if (sum == 0 && num == 0) {
            if (score > maxScore[0]) {
                arr[0] = sb.toString();
                maxScore[0] = score;
            }
            return;
        }

        for (int i = 9; i >= 0; i--) {
            sb.append(i);
            calcMax(sb, num - 1, sum - i, arr, score + (i * i), maxScore);
            sb.setLength(sb.length() - 1);
        }
    }

}
