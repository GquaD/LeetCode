package LeetCode.medium;

public class Problem3941 {
    //10min

    //Runtime
    //4
    //ms
    //Beats
    //93.41%
    //Memory
    //46.82
    //MB
    //Beats
    //96.55%
    //https://leetcode.com/problems/password-strength/solutions/8300972/java-simple-solution-with-array-by-tbekp-w4kg/
    public int passwordStrength(String password) {
        boolean[] arr = new boolean[150];
        int score = 0;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (!arr[c]) {
                score += calculatePoints(c);
                arr[c] = true;
            }
        }

        return score;
    }

    private int calculatePoints(char c) {
        if (c >= 'a' && c <= 'z') return 1;
        else if (c >= 'A' && c <= 'Z') return 2;
        else if (c >= '0' && c <= '9') return 3;
        return 5;
    }
}
