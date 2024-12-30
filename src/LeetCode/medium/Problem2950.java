package LeetCode.medium;

public class Problem2950 {
    //https://leetcode.com/problems/number-of-divisible-substrings/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/number-of-divisible-substrings/solutions/6206037/my-prefix-sum-solution-by-tbekpro-urrg/
    //15min
    //Runtime
    //58
    //ms
    //Beats
    //75.86%
    //Analyze Complexity
    //Memory
    //42.70
    //MB
    //Beats
    //85.34%
    public int countDivisibleSubstrings(String word) {
        int n = word.length(), res = 1;
        int[] arr = new int[n];
        arr[0] = getNum(word.charAt(0));
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] + getNum(word.charAt(i));
            if (arr[i] % (i + 1) == 0)
                res++;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((arr[j] - arr[i]) % (j - i) == 0)
                    res++;
            }
        }

        return res;
    }

    private int getNum(char c) {
        if (c <= 'b')
            return 1;
        if (c <= 'e')
            return 2;
        if (c <= 'h')
            return 3;
        if (c <= 'k')
            return 4;
        if (c <= 'n')
            return 5;
        if (c <= 'q')
            return 6;
        if (c <= 't')
            return 7;
        if (c <= 'w')
            return 8;
        return 9;
    }
}
