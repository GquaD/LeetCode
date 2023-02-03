package LeetCode.easy;

public class Problem482 {
    //https://leetcode.com/problems/license-key-formatting/
    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("---", 3));
        System.out.println(licenseKeyFormatting("a0001afds-", 4));
        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(licenseKeyFormatting("2-5g-3-J", 2));
        System.out.println(licenseKeyFormatting("2-5g-3-J", 3));
    }

    //https://leetcode.com/problems/license-key-formatting/solutions/3134946/java-messy-solution/
    //20 min cause edge cases
    //Runtime
    //12 ms
    //Beats
    //72.11%
    //Memory
    //43.4 MB
    //Beats
    //36.82%
    static String licenseKeyFormatting(String s, int k) {
        while (s.length() > 0 && s.charAt(0) == '-') s = s.substring(1);
        while (s.length() > 0 && s.charAt(s.length() - 1) == '-') s = s.substring(0, s.length() - 1);
        String[] split = s.toUpperCase().split("-");
        int len = s.length() - (split.length - 1), lenFirst = len % k == 0 ? k : len % k;
        StringBuilder sb = new StringBuilder();
        for (String str : split) sb.append(str);
        String temp = sb.toString();
        if (temp.length() <= k) return temp;
        sb.setLength(0);
        sb.append(temp,0, lenFirst).append("-");
        int i = lenFirst;
        while (i < temp.length()) {
            sb.append(temp, i, i + k).append("-");
            i += k;
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
