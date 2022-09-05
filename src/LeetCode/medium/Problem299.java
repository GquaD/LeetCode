package LeetCode.medium;

public class Problem299 {
    //https://leetcode.com/problems/bulls-and-cows/
    public static void main(String[] args) {
        System.out.println(getHint("1807", "7810"));
        System.out.println(getHint("1123", "0111"));
        System.out.println(getHint("4271", "1234"));
    }

    //Runtime: 5 ms, faster than 93.06% of Java online submissions for Bulls and Cows.
    //Memory Usage: 43.1 MB, less than 41.68% of Java online submissions for Bulls and Cows.
    static String getHint(String secret, String guess) {
        int[] alphabetS = new int[10];
        int[] alphabetG = new int[10];
        int bulls = 0, cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i), g = guess.charAt(i);
            if (s == g) {
                bulls++;
                continue;
            } else {
                alphabetS[s - '0']++;
                alphabetG[g - '0']++;
            }
        }
        for (int i = 0; i < alphabetS.length; i++) {
            cows += Math.min(alphabetS[i], alphabetG[i]);
        }
        return bulls + "A" + cows + "B";
    }
}
