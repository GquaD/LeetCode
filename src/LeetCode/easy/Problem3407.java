package LeetCode.easy;

public class Problem3407 {
    //https://leetcode.com/problems/substring-matching-pattern
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/substring-matching-pattern/solutions/6722883/java-solution-by-tbekpro-dcb9/
    //15min
    //Runtime
    //2
    //ms
    //Beats
    //48.53%
    //Analyze Complexity
    //Memory
    //43.05
    //MB
    //Beats
    //48.72%
    public boolean hasMatch(String s, String p) {
        String[] arr = p.split("\\*");
        if (arr.length == 0) return true;
        if (arr[0].length() > 0) {
            if (arr.length > 1) {
                int idx = s.indexOf(arr[0]);
                if (idx < 0) return false;
                return idx < s.indexOf(arr[1], idx + arr[0].length());
            } else {
                return s.contains(arr[0]);
            }
        }
        return s.contains(arr[1]);
    }
}
