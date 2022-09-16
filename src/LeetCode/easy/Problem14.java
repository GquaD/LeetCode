package LeetCode.easy;

public class Problem14 {
    //https://leetcode.com/problems/longest-common-prefix/
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(longestCommonPrefix(new String[]{"a"}));
        System.out.println(longestCommonPrefix(new String[]{""}));
        System.out.println(longestCommonPrefix(new String[]{"",""}));
        //System.out.println(longestCommonPrefix(new String[]{"flower","flower","flower","flower"}));
        System.out.println("////////////////////////////////////////");
        System.out.println(longestCommonPrefix1(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix1(new String[]{"dog", "racecar", "car"}));
        System.out.println(longestCommonPrefix1(new String[]{"a"}));
        System.out.println(longestCommonPrefix1(new String[]{""}));
        System.out.println(longestCommonPrefix1(new String[]{"",""}));
        System.out.println(longestCommonPrefix1(new String[]{"flower","flower","flower","flower"}));

    }
    //Runtime: 12 ms, faster than 18.73% of Java online submissions for Longest Common Prefix.
    //Memory Usage: 41.6 MB, less than 77.77% of Java online submissions for Longest Common Prefix.
    private static String longestCommonPrefix1(String[] strs) {
        int min = strs[0].length();
        String common = strs[0];
        for (int i = 0; i < strs.length; i++) {
            if (min > strs[i].length()) {
                min = strs[i].length();
                common = strs[i];
            }
        }

        for (int i = 0; i < min; i++) {
            if (common.length() == 0) {
                return common;
            }
            for (int j = 0; j < strs.length; j++) {
                if (!strs[j].startsWith(common)) {
                    common = common.substring(0, common.length() - 1);
                    break;
                }

            }
        }
        return common;
    }

    //not working
    private static String longestCommonPrefix(String[] strs) {
        if (strs[0].length() == 0) {
            return "";
        }
        if (strs[0].length() == 1) {
            return strs[0];
        }
        String prefix = "";
        int indexStr = 0, indexPrefix = 0;
        while (true) {
            if (indexStr == strs.length) {
                indexPrefix++;
                indexStr = 0;
                continue;
            }
            if (indexStr == 0 && indexPrefix < strs[0].length()) {
                prefix += strs[0].charAt(indexPrefix);
            }
            if (indexStr < strs.length && !strs[indexStr].startsWith(prefix)) {
                return prefix.substring(0, prefix.length() - 1);
            }
            indexStr++;
        }
    }
}
