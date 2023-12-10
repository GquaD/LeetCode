package LeetCode.medium;

public class Problem2957 {
    //https://leetcode.com/problems/remove-adjacent-almost-equal-characters/
    public static void main(String[] args) {
        System.out.println(removeAlmostEqualCharacters("acb"));
        System.out.println(removeAlmostEqualCharacters("aaaaa"));
        System.out.println(removeAlmostEqualCharacters("abddez"));
        System.out.println(removeAlmostEqualCharacters("zyxyxyz"));
        System.out.println(removeAlmostEqualCharacters("a"));
        System.out.println(removeAlmostEqualCharacters("aa"));
        System.out.println(removeAlmostEqualCharacters("ab"));
        System.out.println(removeAlmostEqualCharacters("ac"));
    }

    //https://leetcode.com/problems/remove-adjacent-almost-equal-characters/solutions/4386371/java-o-n-100-faster-solution/
    //15-20min
    //Runtime
    //1 ms
    //Beats
    //100%
    //Memory
    //41.2 MB
    //Beats
    //100%
    static int removeAlmostEqualCharacters(String word) {
        if (word.length() == 1) return 0;
        int count = 0, switcher = 0;
        for (int i = 0; i < word.length() - 1; i++) {
            if (switcher == 0) {
                if (word.charAt(i) == word.charAt(i + 1) || Math.abs((word.charAt(i) - 'a') - (word.charAt(i + 1) - 'a')) <= 1) {
                    count++;
                    switcher = 1;
                }
            } else {
                switcher = 0;
            }
        }
        return count;
        /*if (word.length() == 1) return 0;
        if (word.length() == 2) return  Math.abs((word.charAt(0) - 'a') - (word.charAt(1) - 'a')) <= 1 ? 1 : 0;
        int count = 0;
        for (int i = 1; i < word.length(); i += 2) {
            char a = word.charAt(i - 1), b = word.charAt(i), c = word.charAt(i + 1);
            if ()
        }
        return count;*/
    }

    //Wrong Answer
    //395 / 779 testcases passed
    static int removeAlmostEqualCharacters1(String word) {
        if (word.length() == 1) return 0;
        int count = 0;
        for (int i = 0; i < word.length() - 1; i += 2)
            if (word.charAt(i) == word.charAt(i + 1) || Math.abs((word.charAt(i) - 'a') - (word.charAt(i + 1) - 'a')) <= 1)
                count++;
        return count;
    }
}
