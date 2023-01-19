package LeetCode.hard;

public class Problem65 {
    //https://leetcode.com/problems/valid-number/
    public static void main(String[] args) {
        System.out.println(isNumber(".5"));
        System.out.println(isNumber("2"));
        System.out.println(isNumber("0089"));
        System.out.println(isNumber("-0.1"));
        System.out.println(isNumber("+3.14"));
        System.out.println(isNumber("4."));
        System.out.println(isNumber("-.9"));
        System.out.println(isNumber("2e10"));
        System.out.println(isNumber("-90E3"));
        System.out.println(isNumber("3e+7"));
        System.out.println(isNumber("+6e-1"));
        System.out.println(isNumber("53.5e93"));
        System.out.println(isNumber("-123.456e789"));
        System.out.println(isNumber("+.8"));
        System.out.println("\n Not valid next\n");
        System.out.println(isNumber("abc"));
        System.out.println(isNumber("1a"));
        System.out.println(isNumber("1e"));
        System.out.println(isNumber("e3"));
        System.out.println(isNumber("99e2.5"));
        System.out.println(isNumber("--6"));
        System.out.println(isNumber("-+3"));
        System.out.println(isNumber("95a54e53"));
        System.out.println(isNumber(".."));
        System.out.println(isNumber(".e1"));
        System.out.println(isNumber("4e+"));
        System.out.println(isNumber("+."));

    }

    //https://leetcode.com/problems/valid-number/solutions/3071699/java-ugly-3ms-solution/
    //40 min
    //Runtime
    //3 ms
    //Beats
    //64.62%
    //Memory
    //43.3 MB
    //Beats
    //36.76%
    static boolean isNumber(String s) {
        if (s.length() == 1) return Character.isDigit(s.charAt(0));
        s = s.toLowerCase();
        int countE = 0, countLetter = 0, countDot = 0, countSign = 0, countSymbol = 0, countDigit = 0;
        for (char c : s.toCharArray()) {
            if (c == 'e') countE++;
            else if (c == '.') countDot++;
            else if (Character.isLowerCase(c)) countLetter++;
            else if (c == '-' || c == '+') countSign++;
            else if (Character.isDigit(c)) countDigit++;
            else countSymbol++;
        }
        if (countE > 1 || countDot > 1 || countLetter > 0
                || countSign > 2 || countSymbol > 0 || countDigit < s.length() - 4) return false;

        String[] arr = s.split("e");
        boolean containsE = countE > 0;
        if (arr.length > 2) return false;
        if (arr.length == 2) {
            String two = arr[1];
            if (two.length() == 1 && !Character.isDigit(two.charAt(0))) return false;
            if (two.length() > 0) {
                if (!(two.charAt(0) == '+' || two.charAt(0) == '-' || Character.isDigit(two.charAt(0))))
                    return false;
                for (int i = 1; i < two.length(); i++) {
                    char c = two.charAt(i);
                    if (!Character.isDigit(c)) return false;
                }
            }
        }
        if ((arr.length == 1 || arr[0].length() == 0) && containsE) return false;
        String one = arr[0];
        if (one.length() > 0) {
            if (!(one.charAt(0) == '+' || one.charAt(0) == '-' || one.charAt(0) == '.' || Character.isDigit(one.charAt(0))))
                return false;
            String[] arrOne = one.split("\\.");
            if (arrOne.length > 2) return false;
            if (arrOne.length == 2) {
                String oneTwo = arrOne[1];
                for (int i = 0; i < oneTwo.length(); i++) {
                    char c = oneTwo.charAt(i);
                    if (!Character.isDigit(c)) return false;
                }
            }
            if (arrOne.length < 1) return false;
            String oneOne = arrOne[0];
            if (oneOne.length() == 1 && !Character.isDigit(oneOne.charAt(0)) && arrOne.length == 1) return false;
            for (int i = 1; i < oneOne.length(); i++) {
                char c = oneOne.charAt(i);
                if (!Character.isDigit(c)) return false;
            }
        }

        return true;
    }
}
