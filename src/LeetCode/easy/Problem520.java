package LeetCode.easy;

public class Problem520 {
    //https://leetcode.com/problems/detect-capital/description/
    public static void main(String[] args) {
        System.out.println(detectCapitalUse("FlaG"));
    }

    //https://leetcode.com/problems/detect-capital/solutions/2983647/java-my-100-faster-solution-o-n/
    //20 min
    //Runtime
    //1 ms
    //Beats
    //100%
    //Memory
    //40.7 MB
    //Beats
    //82.57%
    static boolean detectCapitalUse(String word) {
        if (word.length() == 1) return true;
        boolean firstCap = Character.isUpperCase(word.charAt(0));
        boolean hasCap = false, hasLow = false;
        for (int i = 1; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isUpperCase(c)) hasCap = true;
            if (Character.isLowerCase(c)) hasLow = true;
            if (hasCap && hasLow) return false;
        }
        return firstCap && hasLow && hasCap || !firstCap && hasCap ? false : true;
    }
}
