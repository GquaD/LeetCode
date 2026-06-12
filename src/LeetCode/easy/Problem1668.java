package LeetCode.easy;

public class Problem1668 {
    //15min

    //Runtime
    //1
    //ms
    //Beats
    //89.77%
    //Memory
    //43.40
    //MB
    //Beats
    //8.17%
    //https://leetcode.com/problems/maximum-repeating-substring/solutions/8329994/java-smartesst-solution-by-tbekpro-j4q2/
    public int maxRepeating(String sequence, String word) {
        StringBuilder sb = new StringBuilder();
        int len = word.length(), sum = len, k = 0;

        while (sum <= sequence.length()) {
            sb.append(word);
            if (sequence.contains(sb.toString())) k++;
            sum += len;
        }

        return k;
    }
}
