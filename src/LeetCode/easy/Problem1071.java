package LeetCode.easy;

public class Problem1071 {
    //https://leetcode.com/problems/greatest-common-divisor-of-strings/description/
    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABABABAB", "ABAB"));
        System.out.println(gcdOfStrings("AAAA", "A"));
        System.out.println(gcdOfStrings("AB", "BA"));
        System.out.println(gcdOfStrings("ABABAB", "ABAB"));
    }

    //https://leetcode.com/problems/greatest-common-divisor-of-strings/solutions/3125539/java-string-manipulation/
    //15 min
    //Runtime
    //12 ms
    //Beats
    //15.16%
    //Memory
    //42.8 MB
    //Beats
    //26.57%
    static String gcdOfStrings(String str1, String str2) {
        String min = str1.length() > str2.length() ? str2 : str1;
        String max = str1.length() > str2.length() ? str1 : str2;
        for (int i = min.length(); i > 0; i--) {
            String temp = min.substring(0, i);
            if (isDivisor(temp, max) && isDivisor(temp, min)) return temp;
        }
        return "";
    }

    static String gcdOfStrings1(String str1, String str2) {
        int len = Math.min(str1.length(), str2.length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                sb.append(str1.charAt(i));
                if (!(isDivisor(sb.toString(), str1) && isDivisor(sb.toString(), str2))) {
                    sb.setLength(sb.length() - 1);
                    break;
                }
            }
        }
        return sb.toString();
    }

    private static boolean isDivisor(String div, String str1) {
        if (div.isEmpty()) return false;
        for (int i = 0; i < str1.length(); i+= div.length())
            if (!str1.substring(i, Math.min(i + div.length(), str1.length())).equals(div)) return false;
        return true;
    }
}
