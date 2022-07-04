package LeetCode;

public class Problem2220 {
    //https://leetcode.com/problems/minimum-bit-flips-to-convert-number/
    public static void main(String[] args) {
        System.out.println(minBitFlips(10, 7));
        System.out.println(minBitFlips(3, 4));
        System.out.println(minBitFlips(10, 82));
    }

    //Runtime: 2 ms, faster than 16.18% of Java online submissions for Minimum Bit Flips to Convert Number.
    //Memory Usage: 41.2 MB, less than 43.67% of Java online submissions for Minimum Bit Flips to Convert Number.
    public static int minBitFlips(int start, int goal) {
        int count = 0;
        String s = Integer.toBinaryString(start);
        String g = Integer.toBinaryString(goal);
        String longer = s.length() >= g.length() ? s : g;
        g = s.length() >= g.length() ? g : s;
        for (int i = 0; i < g.length(); i++) {
            if (g.charAt(g.length() - 1 - i) != longer.charAt(longer.length() - 1 - i)) {
                count++;
            }
        }
        int difference = longer.length() - g.length();
        for (int i = 0; i < difference; i++) {
            if (longer.charAt(longer.length() - 1 - g.length() - i) != '0') {
                count++;
            }
        }

        return count;
    }

    public int minBitFlips1(int start, int goal) {
        int xor =start ^ goal;
        int count=0;
        while(xor>0){
            count++;
            xor=xor & (xor-1);
        }
        return count;

    }
}
