package LeetCode.easy;

public class Problem1446 {
    //https://leetcode.com/problems/consecutive-characters/
    public static void main(String[] args) {
        System.out.println(maxPower("leetcode"));
        System.out.println(maxPower("abbcccddddeeeeedcba"));
    }

    //https://leetcode.com/problems/consecutive-characters/solutions/2896058/java-100-faster-o-n/
    //Runtime
    //1 ms
    //Beats
    //100%
    //Memory
    //41.1 MB
    //Beats
    //86.77%
    static int maxPower(String s) {
        int max = 1, count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                if (++count > max) {
                    max = count;
                }
                count = 0;
            }
        }
        if (++count > max) {
            max = count;
        }
        return max;
    }
}
