package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem1286 {
    //https://leetcode.com/problems/iterator-for-combination/
    public static void main(String[] args) {
        CombinationIterator itr = new CombinationIterator("gkosu", 3);
        System.out.println(itr.next());    // return "ab"
        System.out.println(itr.hasNext()); // return True
        System.out.println(itr.next());    // return "ac"
        System.out.println(itr.hasNext()); // return True
        System.out.println(itr.next());    // return "bc"
        System.out.println(itr.hasNext()); // return False
        System.out.println(itr.next());    // return "ab"
        System.out.println(itr.hasNext()); // return True
        System.out.println(itr.next());    // return "ac"
        System.out.println(itr.hasNext()); // return True
        System.out.println(itr.next());    // return "bc"
        System.out.println(itr.hasNext()); // return False
    }


    //Runtime: 51 ms, faster than 5.71% of Java online submissions for Iterator for Combination.
    //Memory Usage: 48.6 MB, less than 25.43% of Java online submissions for Iterator for Combination.
    static class CombinationIterator {
        int count;
        String string;
        int len;
        List<String> list;

        public CombinationIterator(String characters, int combinationLength) {
            count = 0;
            string = characters;
            len = combinationLength;
            list = new ArrayList<>();
            generateCombinations(new StringBuilder(), 0);
        }

        private void generateCombinations(StringBuilder sb, int indexStartOfWord) {
            if (sb.length() >= len) {
                if (list.contains(sb.toString())) {
                    return;
                }
                list.add(sb.toString());
                return;
            }

            for (int i = indexStartOfWord; i < string.length(); i++) {
                sb.append(string.charAt(i));
                generateCombinations(sb, i + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        public String next() {
            return list.get(count++);
        }

        public boolean hasNext() {
            return count < list.size();
        }
    }


    static class CombinationIterator1 {
        int idxStart;
        int idxEndFirst;
        int idxEndLast;
        int length;
        String string;

        public CombinationIterator1(String characters, int combinationLength) {
            string = characters;
            length = combinationLength;
            idxStart = 0;
            idxEndFirst = combinationLength - 2;
            idxEndLast = combinationLength - 1;
        }

        public String next() {
            if (length == 1) {
                return string.charAt(idxStart++) + "";
            }
            String res = string.substring(idxStart, idxEndFirst + 1) + string.charAt(idxEndLast);
            if (idxEndLast + 1 == string.length()) {
                idxStart++;
                idxEndFirst = idxStart + length - 2;
                idxEndLast = idxEndFirst + 1;
            } else {
                idxEndLast++;
            }
            return res;
        }

        public boolean hasNext() {
            if (length == 1) {
                if (idxStart == string.length()) {
                    return false;
                }
                return true;
            }
            if ((idxEndLast == string.length() - 1) && idxEndFirst < idxEndLast) {
                return true;
            }
            if (idxEndLast < string.length()) {
                return true;
            }

            return false;
        }
    }
}
