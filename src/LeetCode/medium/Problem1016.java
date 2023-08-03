package LeetCode.medium;

public class Problem1016 {
    //https://leetcode.com/problems/binary-string-with-substrings-representing-1-to-n/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/binary-string-with-substrings-representing-1-to-n/solutions/3858397/java-100-faster-2-lines/
    //3-5 min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //40.5 MB
    //Beats
    //61.70%
    static boolean queryString(String s, int n) {
        for (int i = n; i >= 1 ; i--) if (!s.contains(Integer.toBinaryString(n--))) return false;
        return true;
    }
}
