package LeetCode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem839 {
    //https://leetcode.com/problems/similar-string-groups/
    public static void main(String[] args) {
        System.out.println(numSimilarGroups(new String[]{"tars", "rats", "arts", "star"}));
        System.out.println(numSimilarGroups(new String[]{"kccomwcgcs", "socgcmcwkc", "sgckwcmcoc", "coswcmcgkc", "cowkccmsgc", "cosgmccwkc", "sgmkwcccoc", "coswmccgkc", "kowcccmsgc", "kgcomwcccs"}));
    }

    //https://leetcode.com/problems/similar-string-groups/solutions/3462661/java-solution-using-hashsets/
    //50-60 min
    //Runtime
    //229 ms
    //Beats
    //8.40%
    //Memory
    //43 MB
    //Beats
    //5.73%
    static int numSimilarGroups(String[] strs) {
        Set<String> set = new HashSet<>(), setUsed = new HashSet<>();
        for (String s : strs) set.add(s);
        List<Set<String>> list = new ArrayList<>();
        for (String s : strs) {
            if (setUsed.contains(s)) continue;
            Set<String> setTemp = new HashSet<>();
            setTemp.add(s);
            setUsed.add(s);
            set.remove(s);
            boolean hasSimilar;
            do {
                Set<String> setCopy = new HashSet<>(set);
                hasSimilar = false;
                for (String t : set) {
                    if (hasSimilar(t, setTemp)) {
                        setTemp.add(t);
                        setUsed.add(t);
                        setCopy.remove(t);
                        hasSimilar = true;
                    }
                }
                set = setCopy;
            } while (hasSimilar && set.size() > 0);
            list.add(setTemp);
        }
        return list.size();
    }

    static int numSimilarGroups1(String[] strs) {
        List<Set<String>> list = new ArrayList<>();
        list.add(new HashSet<>());
        list.get(0).add(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];
            boolean hasSimilar = false;
            for (Set<String> set : list) {
                if (set.contains(s)) {
                    hasSimilar = true;
                    break;
                }
                if (hasSimilar(s, set)) {
                    set.add(s);
                    hasSimilar = true;
                    break;
                }
            }
            if (!hasSimilar) {
                Set<String> set = new HashSet<>();
                set.add(s);
                list.add(set);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            Set<String> set = list.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (j == i) continue;
                Set<String> set1 = list.get(j);

            }
        }

        return list.size();
    }

    private static boolean hasSimilar(String s, Set<String> set) {
        for (String t : set) {
            int count = 0;
            for (int i = 0; i < t.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) count++;
            }
            if (count == 2) return true;
        }
        return false;
    }
}
