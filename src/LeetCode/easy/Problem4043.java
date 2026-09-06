package LeetCode.easy;

public class Problem4043 {

    //2min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Memory
    //43.92
    //MB
    //Beats
    //61.24%
    //https://leetcode.com/problems/count-rotations-with-exactly-k-equal-adjacent-pairs/solutions/8506276/java-100-fast-solution-by-tbekpro-lou4/
    public int countRotations(String s, int k) {
        int score = 0, count = 0, len = s.length();
        for (int i = 0; i < len - 1; i++) if (s.charAt(i) == s.charAt(i + 1)) score++;
        if (score == k) count++;


        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) score--;
            if (s.charAt((len + i - 2) % len) == s.charAt((len + i - 1) % len)) score++;
            if (score == k) count++;
        }

        return count;
    }

    //15min
    //Runtime
    //2
    //ms
    //Beats
    //64.84%
    //Memory
    //44.34
    //MB
    //Beats
    //30.44%
     public int countRotations1(String s, int k) {
         int score = 0, count = 0, len = s.length();
         for (int i = 0; i < s.length() - 1; i++) if (s.charAt(i) == s.charAt(i + 1)) score++;
         if (score == k) count++;
         s = s + s.substring(0, s.length() - 1);


         for (int i = 1; i < len; i++) {
             if (s.charAt(i) == s.charAt(i - 1)) score--;
             if (s.charAt(len + i - 2) == s.charAt(len + i - 1)) score++;
             if (score == k) count++;
         }

         return count;
     }
}
