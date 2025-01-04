package LeetCode.easy;

public class Problem246 {
    //https://leetcode.com/problems/strobogrammatic-number/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/strobogrammatic-number/solutions/6230196/java-100-faster-solution-by-tbekpro-mieh/
    //3min
    //Runtime
    //0
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //41.54
    //MB
    //Beats
    //24.39%
    public boolean isStrobogrammatic(String num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            if (c == '0' || c == '8' || c == '1') sb.append(c);
            else if (c == '6') sb.append('9');
            else if (c == '9') sb.append('6');
        }
        return sb.reverse().toString().equals(num);
    }
}
