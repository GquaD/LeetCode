package LeetCode.medium;


public class Problem165 {
    //https://leetcode.com/problems/compare-version-numbers/
    public static void main(String[] args) {
        System.out.println(compareVersion("1", "1.1"));//1
        System.out.println(compareVersion("1.0.1", "1"));//1
        System.out.println(compareVersion("1.01", "1.001"));
        System.out.println(compareVersion("1.0.0", "1.0"));
        System.out.println(compareVersion("0.1", "1.1"));
    }

    //https://leetcode.com/problems/compare-version-numbers/solutions/3170635/java-straightforward-solution/
    //30-40 min
    //Runtime
    //1 ms
    //Beats
    //83.50%
    //Memory
    //40 MB
    //Beats
    //89.84%
    static int compareVersion(String version1, String version2) {
        String[] a = version1.split("\\."), b = version2.split("\\.");
        boolean changed = false;
        if (a.length < b.length) {
            String[] temp = a;
            a = b;
            b = temp;
            changed = true;
        }
        for (int i = 0; i < a.length; i++) {
            String one = removeLeadingZeros(a[i]), two = i >= b.length ? "0" : removeLeadingZeros(b[i]);
            if (!one.equals(two)) {
                if (one.length() > two.length()) return changed ? -1 : 1;
                else if (one.length() < two.length()) return changed? 1 : -1;
                else {
                    for (int j = 0; j < one.length(); j++) {
                        if (one.charAt(j) > two.charAt(j)) return changed ? -1 : 1;
                        else if (one.charAt(j) < two.charAt(j)) return changed ? 1 : -1;
                    }
                }
            }
        }
        return 0;
    }

    private static String removeLeadingZeros(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') return s.substring(i);
        }
        return "0";
    }
}
