package LeetCode.medium;

public class Problem1456 {
    //https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/solutions/3486806/java-o-n-solution/
    //5 min
    //Runtime
    //16 ms
    //Beats
    //63.3%
    //Memory
    //43.2 MB
    //Beats
    //54.76%
    static int maxVowels(String s, int k) {
        int count = 0, max = 0;
        for (int i = 0; i < Math.min(s.length(), k); i++) if (isVowel(s.charAt(i))) count++;
        if (max < count) max = count;
        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i - k))) count--;
            if (isVowel(s.charAt(i))) count++;
            if (max < count) max = count;
        }
        return max;
    }

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
