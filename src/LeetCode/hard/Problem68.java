package LeetCode.hard;

import LeetCode.LeetCodeUtils;

import java.util.ArrayList;
import java.util.List;

public class Problem68 {
    //https://leetcode.com/problems/text-justification/
    public static void main(String[] args) {
        LeetCodeUtils.printList(fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
    }

    //https://leetcode.com/problems/text-justification/solutions/3954364/java-o-n-100-faster-solution/
    //25 min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //41.1 MB
    //Beats
    //38.88%
    static List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> list = new ArrayList<>();
        int idx = 0, len = 0;
        list.add(new ArrayList<>());
        for (int i = 0; i < words.length; i++) {
            if (len + words[i].length() <= maxWidth) {
                len += words[i].length() + 1;
                list.get(idx).add(words[i]);
            } else {
                list.add(new ArrayList<>());
                list.get(++idx).add(words[i]);
                len = words[i].length() + 1;
            }
        }
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size() - 1; i++) {
            List<String> listCurr = list.get(i);
            int wordsLen = 0;
            for (int j = 0; j < listCurr.size(); j++) wordsLen += listCurr.get(j).length();
            int spaces = maxWidth - wordsLen, div = spaces / (Math.max(1, listCurr.size() - 1));
            int rem = spaces % (Math.max(1, listCurr.size() - 1));

            for (int j = 0; j < listCurr.size() - 1; j++) {
                sb.append(listCurr.get(j));
                generateAndAddSpaces(sb, div + (rem > 0 ? 1 : 0));
                rem--;
            }
            sb.append(listCurr.get(listCurr.size() - 1));
            if (sb.length() < maxWidth) generateAndAddSpaces(sb, maxWidth - sb.length());
            res.add(sb.toString());
            sb.setLength(0);
        }
        List<String> listLast = list.get(list.size() - 1);
        for (int i = 0; i < listLast.size() - 1; i++) {
            sb.append(listLast.get(i)).append(" ");
        }
        sb.append(listLast.get(listLast.size() - 1));
        if (sb.length() < maxWidth) generateAndAddSpaces(sb, maxWidth - sb.length());
        res.add(sb.toString());
        return res;
    }

    private static void generateAndAddSpaces(StringBuilder sb, int n) {
        for (int i = 0; i < n; i++) sb.append(" ");
    }
}
