package LeetCode.easy;

public class Problem2027 {
    //3min
    //Runtime
    //2
    //ms
    //Beats
    //5.70%
    //Memory
    //42.44
    //MB
    //Beats
    //69.80%
    public int minimumMoves(String s) {
        int count1 = 0, count2 = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'X') {
                count1++;
                i += 2;
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == 'X') {
                count2++;
                i -= 2;
            }
        }

        return Math.min(count1, count2);
    }
}
