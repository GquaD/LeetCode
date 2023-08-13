package LeetCode.medium;

public class Problem2745 {
    //https://leetcode.com/problems/construct-the-longest-new-string/
    public static void main(String[] args) {
        System.out.println(longestString(2, 5, 1));
        System.out.println(longestString(3, 2, 2));
    }

    //AB AA BB
    //if AA > BB
    //AB all come first and then AA BB AA BB


    //https://leetcode.com/problems/construct-the-longest-new-string/solutions/3901369/java-o-1-1-line-math-solution/
    //5-10min
    //Runtime
    //1 ms
    //Beats
    //100%
    //Memory
    //40 MB
    //Beats
    //85.36%
    static int longestString(int x, int y, int z) {
        return x != y ? (Math.min(x, y) * 2 + 1 + z) * 2 : 2 * (x + y + z);
    }
}
