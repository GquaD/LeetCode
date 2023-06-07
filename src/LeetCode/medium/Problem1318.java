package LeetCode.medium;

public class Problem1318 {
    //https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/description/
    public static void main(String[] args) {
        System.out.println(minFlips(2,6,5));
        System.out.println(minFlips(4,2,7));
        System.out.println(minFlips(1,2,3));
        System.out.println(minFlips(2,6,15));
        System.out.println(minFlips(1,12,13));
    }

    //https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/solutions/3609805/java-100-faster-string-manipulation/
    //20-25 min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //39.6 MB
    //Beats
    //45.75%
    static int minFlips(int a, int b, int c) {
        String as = Integer.toBinaryString(a), bs = Integer.toBinaryString(b), cs = Integer.toBinaryString(c);
        int maxLen = Math.max(as.length(), Math.max(bs.length(), cs.length())), count = 0;
        as = addZeros(as, maxLen);
        bs = addZeros(bs, maxLen);
        cs = addZeros(cs, maxLen);
        for (int i = maxLen - 1; i >= 0; i--) {
            int al = as.charAt(i) - '0', bl = bs.charAt(i) - '0', cl = cs.charAt(i) - '0';
            if (cl == 0) {
                if (al == 1) count++;
                if (bl == 1) count++;
            } else {
                if (al == 0 && bl == 0) count++;
            }
        }
        return count;
    }

    static String addZeros(String s, int maxLen) {
        StringBuilder sb = new StringBuilder();
        if (s.length() < maxLen) {
            int l = maxLen - s.length();
            for (int i = 0; i < l; i++) sb.append('0');
            sb.append(s);
            s = sb.toString();
        }
        return sb.length() > 0 ? sb.toString() : s;
    }
}

