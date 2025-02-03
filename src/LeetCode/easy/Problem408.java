package LeetCode.easy;

public class Problem408 {
    //https://leetcode.com/problems/valid-word-abbreviation
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/valid-word-abbreviation/solutions/6367528/java-on-solution-by-tbekpro-ucmq/
    //20min
    //Runtime
    //1
    //ms
    //Beats
    //96.93%
    //Analyze Complexity
    //Memory
    //42.06
    //MB
    //Beats
    //29.00%
    public boolean validWordAbbreviation(String word, String abbr) {
        StringBuilder builder = new StringBuilder();
        int num = 0;
        for (int i = 0; i < abbr.length(); i++) {
            while (i < abbr.length() && Character.isDigit(abbr.charAt(i))) {
                num = num * 10 + (abbr.charAt(i++) - '0');
                if (num == 0) return false;
            }
            if (num > 0) {
                for (int k = 0; k < num && k < 20; k++) {
                    builder.append("_");
                }
                num = 0;
                i--;
            } else {
                builder.append(abbr.charAt(i));
            }
        }

        String temp = builder.toString();
        if (temp.length() != word.length()) return false;
        for (int i = 0; i < word.length(); i++) {
            if (temp.charAt(i) == '_') continue;
            if (word.charAt(i) != temp.charAt(i)) return false;
        }
        return true;
    }
}
