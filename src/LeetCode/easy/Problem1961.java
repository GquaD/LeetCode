package LeetCode.easy;

public class Problem1961 {
    //5min

    //Runtime
    //1
    //ms
    //Beats
    //83.12%
    //Memory
    //44.47
    //MB
    //Beats
    //13.48%
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder sb = new StringBuilder();
        for (String word: words) {
            sb.append(word);
            if (sb.toString().equals(s)) return true;
        }
        return false;
    }
}
