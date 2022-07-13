package LeetCode;

public class Problem1309 {
    //https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
    public static void main(String[] args) {
        System.out.println(freqAlphabets("10#11#12"));
        System.out.println(freqAlphabets("1326#"));
    }

    //Runtime: 3 ms, faster than 46.53% of Java online submissions for Decrypt String from Alphabet to Integer Mapping.
    //Memory Usage: 43.5 MB, less than 7.61% of Java online submissions for Decrypt String from Alphabet to Integer Mapping.
    static String freqAlphabets(String s) {
        int temp = 0;
        StringBuilder sb = new StringBuilder();
        while(temp != -1) {
            int indexOfHash = s.indexOf("#");
            String subString = s.substring(0, indexOfHash + 1);
            s = s.substring(indexOfHash + 1);
            temp = indexOfHash;
            if (subString.length() == 3) {
                sb.append(getChar(subString));
            } else {
                if (subString.contains("#")) {
                    int indexForHash = subString.length() - 3;
                    for (int i = 0; i < subString.length() - 3; i++) {
                        sb.append(convertSingle(subString.charAt(i)));
                    }
                    sb.append(getChar(subString.substring(indexForHash)));
                } else {
                    for (int i = 0; i < s.length(); i++) {
                        sb.append(convertSingle(s.charAt(i)));
                    }
                }
            }
        }
        return sb.toString();
    }

    private static char convertSingle(char c) {
        return (char) (c + 97 - 49);
    }

    private static char getChar(String s) {
        s = s.substring(0, s.length() - 1);
        int num = Integer.parseInt(s);
        return (char) (num + 96);
    }
}
