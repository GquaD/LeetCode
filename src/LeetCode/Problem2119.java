package LeetCode;

public class Problem2119 {
    //https://leetcode.com/problems/a-number-after-a-double-reversal/
    public static void main(String[] args) {
        System.out.println(isSameAfterReversals(526));
        System.out.println(isSameAfterReversals(1800));
        System.out.println(isSameAfterReversals(0));
        System.out.println("//////////////");
        System.out.println(isSameAfterReversals2(526));
        System.out.println(isSameAfterReversals2(1800));
        System.out.println(isSameAfterReversals2(0));
    }

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for A Number After a Double Reversal.
    //Memory Usage: 40.8 MB, less than 52.03% of Java online submissions for A Number After a Double Reversal.
    static boolean isSameAfterReversals(int num) {
        if (num == 0) return true;
        return  (num / 10) * 10 != num;
    }

    //Runtime: 1 ms, faster than 32.69% of Java online submissions for A Number After a Double Reversal.
    //Memory Usage: 41 MB, less than 44.61% of Java online submissions for A Number After a Double Reversal.
    static boolean isSameAfterReversals2(int num) {
        if (num == 0) return true;
        String s = num + "";
        return s.charAt(s.length() - 1) != '0';
    }

    //Runtime: 2 ms, faster than 9.19% of Java online submissions for A Number After a Double Reversal.
    //Memory Usage: 41.9 MB, less than 6.80% of Java online submissions for A Number After a Double Reversal.
    static boolean isSameAfterReversals1(int num) {
        String rev1 = revert(num + "");
        int rev1Int = Integer.parseInt(rev1);
        String rev2 = revert(rev1Int + "");
        int rev2Int = Integer.parseInt(rev2);
        return num == rev2Int;
    }

    static String revert(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
