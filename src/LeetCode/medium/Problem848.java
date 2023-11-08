package LeetCode.medium;

public class Problem848 {
    //https://leetcode.com/problems/shifting-letters/
    public static void main(String[] args) {
        System.out.println(shiftingLetters("abc", new int[]{3,5,9}));
        System.out.println(shiftingLetters("aaa", new int[]{1,2,3}));
    }

    //https://leetcode.com/problems/shifting-letters/solutions/4264690/java-o-n-solution/
    //5-10min
    //Runtime
    //8 ms
    //Beats
    //68.79%
    //Memory
    //59.1 MB
    //Beats
    //13.55%
    static String shiftingLetters(String s, int[] shifts) {
        long sum = 0;
        for (int n : shifts) sum += n;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = (char) ((s.charAt(i) - 'a' + sum) % 26 + 'a');
            sb.append(c);
            sum -= shifts[i];
        }
        return sb.toString();
    }
}
