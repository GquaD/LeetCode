package LeetCode;

public class Problem1974 {
    //https://leetcode.com/problems/minimum-time-to-type-word-using-special-typewriter/
    public static void main(String[] args) {
        System.out.println(minTimeToType("pdy")); //31
        System.out.println(minTimeToType("abc"));
        System.out.println(minTimeToType("bza"));
        System.out.println(minTimeToType("zjpc"));
    }

    //Runtime: 1 ms, faster than 86.94% of Java online submissions for Minimum Time to Type Word Using Special Typewriter.
    //Memory Usage: 42 MB, less than 58.78% of Java online submissions for Minimum Time to Type Word Using Special Typewriter.
    static int minTimeToType(String word) {
        int count = 0;
        int pos = 1; //position on 'a'
        boolean isClockwise = true;
        for (int i = 0; i < word.length(); i++) {
            int curr = numFromAtoZFrom1To26(word.charAt(i));
            if (Math.abs(curr - pos) <= 13) {
                count += Math.abs(curr - pos) + 1;
            } else {
                isClockwise = pos - curr > 0;
                if (!isClockwise) {
                    count += pos - numFromAtoZFrom1To26('a') + 1;
                    count += numFromAtoZFrom1To26('z') - curr + 1;
                } else {
                    count += numFromAtoZFrom1To26('z') - pos + 1;
                    count += curr - numFromAtoZFrom1To26('a') + 1;
                }
            }
            pos = curr;
        }
        return count;
    }

    private static int numFromAtoZFrom1To26(char c) {
        return c - 96;
    }
}
