package LeetCode.easy;

public class Problem3042 {
    //https://leetcode.com/problems/count-prefix-and-suffix-pairs-i
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/solutions/6247199/java-straightforward-solution-by-tbekpro-lw8k/
    //5-10min
    //Runtime
    //3
    //ms
    //Beats
    //40.04%
    //Analyze Complexity
    //Memory
    //42.44
    //MB
    //Beats
    //51.15%
    public int countPrefixSuffixPairs(String[] words) {
        int res = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean isPrefixAndSuffix(String a, String b) {
        if (a.length() > b.length()) {
            return false;
        } else if (a.length() == b.length()) {
            if (a.equals(b)) {
                return true;
            } else {
                return false;
            }
        } else {
            boolean isPrefix = isPrefix(a, b), isSuffix = isSuffix(a, b);
            if (isPrefix && isSuffix) {
                return true;
            } else {
                return false;
            }
        }
    }

    private boolean isPrefix(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                return false;
        }
        return true;
    }

    private boolean isSuffix(String a, String b) {
        int start = b.length() - a.length();
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(start + i))
                return false;
        }
        return true;
    }
}
