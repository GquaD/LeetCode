package LeetCode;

public class Problem14LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"ab", "a"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","fright"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];
        String min = findMin(strs), prefix = "";
        outerloop:
        for (int i = 1; i < min.length(); i++) {
            String tempPrefix = min.substring(0, i);
            for (int j = 0; j < strs.length; j++) {
                String tempString = strs[j];
                if (!tempString.startsWith(tempPrefix)) {
                    prefix = min.substring(0, i - 1);
                    break outerloop;
                }
            }
        }
        return prefix;

    }

    public static String findMax(String[] strings) {
        String first = strings[0];
        for (int i = 1; i < strings.length; i++) {
            if (first.length() < strings[i].length()) {
                first = strings[i];
            }
        }
        return first;
    }

    public static String findMin(String[] strings) {
        String first = strings[0];
        for (int i = 1; i < strings.length; i++) {
            if (first.length() > strings[i].length()) {
                first = strings[i];
            }
        }
        return first;
    }
}
