package LeetCode.medium;

public class Problem2844 {
    //https://leetcode.com/problems/minimum-operations-to-make-a-special-number/
    public static void main(String[] args) {
        System.out.println(minimumOperations("2245047"));
        System.out.println(minimumOperations("2908305"));
        System.out.println(minimumOperations("10"));
        System.out.println(minimumOperations("1"));
        System.out.println(minimumOperations("0"));
    }

    //https://leetcode.com/problems/minimum-operations-to-make-a-special-number/solutions/4018281/java-100-faster/
    //35-40min
    //Runtime
    //1 ms
    //Beats
    //99.78%
    //Memory
    //40.7 MB
    //Beats
    //98.43%
    static int minimumOperations(String num) {
        if (num.length() == 1) return num.equals("0") ? 0 : 1;
        int firstIdx = -1, secondIdx = num.lastIndexOf('0');
        for (int i = num.length() - 1; i >= 0; i--) {
            if (i < secondIdx && (num.charAt(i) == '5' || num.charAt(i) == '0')) {
                firstIdx = i;
                break;
            }
        }
        int firstIdx1 = -1, secondIdx1 = num.lastIndexOf('5');
        for (int i = num.length() - 1; i >= 0; i--) {
            if (i < secondIdx1 && (num.charAt(i) == '2' || num.charAt(i) == '7')) {
                firstIdx1 = i;
                break;
            }
        }

        int toRemove = -1, toRemove1 = -1;
        if (firstIdx != -1 && secondIdx != -1) toRemove = num.length() - firstIdx - 2;
        if (firstIdx1 != -1 && secondIdx1 != -1) toRemove1 = num.length() - firstIdx1 - 2;
        if (toRemove >= 0 || toRemove1 >= 0) {
            if (toRemove >= 0 && toRemove1 >= 0) return Math.min(toRemove, toRemove1);
            else return Math.max(toRemove, toRemove1);
        } else {
            return secondIdx >= 0 ? num.length() - 1 : num.length();
        }
    }
}
