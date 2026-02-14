package LeetCode.easy;

public class Problem3838 {
    //5min
    //Runtime
    //2
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //46.59
    //MB
    //Beats
    //100.00%

    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        for (String s: words) {
            sb.append(findChar(calcWeight(s, weights)));
        }

        return sb.toString();
    }

    private int calcWeight(String s, int[] weights) {
        int w = 0;
        for (int i = 0; i < s.length(); i++) {
            w += weights[s.charAt(i) - 'a'];
        }
        return w;
    }

    private char findChar(int weight) {
        weight %= 26;
        return (char)('z' - weight);
    }
}
