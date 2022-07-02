package LeetCode;

import java.util.regex.Pattern;

public class Problem392 {
    //https://leetcode.com/problems/is-subsequence/
    public static void main(String[] args) {
        System.out.println(isSubsequence("ace", "abcde"));
        System.out.println(isSubsequence("axc", "ahbgdc"));
        System.out.println(isSubsequence("ace", "abcde"));
        System.out.println(isSubsequence("b", "abc"));
        //System.out.println(isSubsequence("rjufvjafbxnbgriwgokdgqdqewn", "mjmqqjrmzkvhxlyruonekhhofpzzslupzojfuoztvzmmqvmlhgqxehojfowtrinbatjujaxekbcydldglkbxsqbbnrkhfdnpfbuaktupfftiljwpgglkjqunvithzlzpgikixqeuimmtbiskemplcvljqgvlzvnqxgedxqnznddkiujwhdefziydtquoudzxstpjjitmiimbjfgfjikkjycwgnpdxpeppsturjwkgnifinccvqzwlbmgpdaodzptyrjjkbqmgdrftfbwgimsmjpknuqtijrsnwvtytqqvookinzmkkkrkgwafohflvuedssukjgipgmypakhlckvizmqvycvbxhlljzejcaijqnfgobuhuiahtmxfzoplmmjfxtggwwxliplntkfuxjcnzcqsaagahbbneugiocexcfpszzomumfqpaiydssmihdoewahoswhlnpctjmkyufsvjlrflfiktndubnymenlmpyrhjxfdcq"));
        System.out.println("\n=============\n");
        System.out.println(isSubsequence2("ace", "abcde"));
        System.out.println(isSubsequence2("axc", "ahbgdc"));
        System.out.println(isSubsequence2("ace", "abcde"));
        System.out.println(isSubsequence2("b", "abc"));
        System.out.println(isSubsequence2("rjufvjafbxnbgriwgokdgqdqewn", "mjmqqjrmzkvhxlyruonekhhofpzzslupzojfuoztvzmmqvmlhgqxehojfowtrinbatjujaxekbcydldglkbxsqbbnrkhfdnpfbuaktupfftiljwpgglkjqunvithzlzpgikixqeuimmtbiskemplcvljqgvlzvnqxgedxqnznddkiujwhdefziydtquoudzxstpjjitmiimbjfgfjikkjycwgnpdxpeppsturjwkgnifinccvqzwlbmgpdaodzptyrjjkbqmgdrftfbwgimsmjpknuqtijrsnwvtytqqvookinzmkkkrkgwafohflvuedssukjgipgmypakhlckvizmqvycvbxhlljzejcaijqnfgobuhuiahtmxfzoplmmjfxtggwwxliplntkfuxjcnzcqsaagahbbneugiocexcfpszzomumfqpaiydssmihdoewahoswhlnpctjmkyufsvjlrflfiktndubnymenlmpyrhjxfdcq"));
        System.out.println(isSubsequence2("d", ""));

    }

    //s = "rjufvjafbxnbgriwgokdgqdqewn"
    //t = "mjmqqjrmzkvhxlyruonekhhofpzzslupzojfuoztvzmmqvmlhgqxehojfowtrinbatjujaxekbcydldglkbxsqbbnrkhfdnpfbuaktupfftiljwpgglkjqunvithzlzpgikixqeuimmtbiskemplcvljqgvlzvnqxgedxqnznddkiujwhdefziydtquoudzxstpjjitmiimbjfgfjikkjycwgnpdxpeppsturjwkgnifinccvqzwlbmgpdaodzptyrjjkbqmgdrftfbwgimsmjpknuqtijrsnwvtytqqvookinzmkkkrkgwafohflvuedssukjgipgmypakhlckvizmqvycvbxhlljzejcaijqnfgobuhuiahtmxfzoplmmjfxtggwwxliplntkfuxjcnzcqsaagahbbneugiocexcfpszzomumfqpaiydssmihdoewahoswhlnpctjmkyufsvjlrflfiktndubnymenlmpyrhjxfdcq"
    //fails on this
    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        } else if (t.length() == 0) {
            return false;
        }
        //'S.*x.*2.*0.*1.*6' example
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i) + ".*");
        }
        return Pattern.compile(sb.toString()).matcher(t).find();
    }

    //much faster than 1st solution
    public static boolean isSubsequence2(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int indexS = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(indexS) == t.charAt(i)) {
                indexS++;
                if (indexS == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}
