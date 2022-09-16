package LeetCode.easy;

import java.util.*;

public class Problem1370 {
    //https://leetcode.com/problems/increasing-decreasing-string/
    //!
    public static void main(String[] args) {
        System.out.println(sortString("aaaabbbbcccc"));
        System.out.println(sortString("rat"));
        System.out.println(sortString("leetcode"));
    }

    //Runtime: 5 ms, faster than 69.66% of Java online submissions for Increasing Decreasing String.
    //Memory Usage: 44.1 MB, less than 39.14% of Java online submissions for Increasing Decreasing String.
    static String sortString(String s) {
        int[] chars = new int[26];

        for(char c:s.toCharArray()){
            chars[c-'a']++;
        }
        StringBuilder output = new StringBuilder();

        while(output.length()<s.length()){
            for(int i=0;i<26;i++){
                if(chars[i] != 0){
                    output.append((char)(i+'a'));
                    chars[i]--;
                }
            }
            for(int i=25;i>=0;i--){
                if(chars[i] != 0){
                    output.append((char)(i+'a'));
                    chars[i]--;
                }
            }
        }

        return output.toString();
    }
    static String sortString3(String s) {
        //char - frequency
        Map<Character, Integer> map = new HashMap<>();
        TreeSet<Character> set = new TreeSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 0);
            }
            set.add(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        List<Character> list = new ArrayList<>(set);
        for (int i = 0; i < set.size(); i++) {
            sb.append(list.get(i));
        }
        boolean isForward = false;
        while (sb.toString().length() < s.length()) {
            if (isForward) {
                for (int i = 0; i < set.size(); i++) {
                    if (sb.toString().length() == s.length()) {
                        break;
                    }
                    sb.append(list.get(i));
                }
                isForward = !isForward;
                continue;
            }
            if (!isForward) {
                for (int i = set.size() - 1; i >= 0; i--) {
                    if (sb.toString().length() == s.length()) {
                        break;
                    }
                    sb.append(list.get(i));
                }
                isForward = !isForward;
                continue;
            }
        }
        return sb.toString();
    }

    static String sortString2(String s) {
        char min = s.charAt(0), max = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (min > s.charAt(i)) {
                min = s.charAt(i);
            }
            if (max < s.charAt(i)) {
                max = s.charAt(i);
            }
        }

        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }

        boolean isForward = true;
        char temp = list.get(0);
        StringBuilder sb = new StringBuilder();
        while (list.size() > 0) {
            /*if (list.get(0) == max) {
                isForward = false;
            }
            if (list.get(0) == min) {
                isForward = true;
            }*/
            if (isForward) {
                for (int i = 0; i < list.size(); i++) {
                    if (temp < list.get(i)) {
                        temp = list.get(i);
                        sb.append(temp);
                        list.remove(i);
                        if (temp == max ) {
                            isForward = false;
                            break;
                        }
                    }
                }
            }
            if (!isForward) {
                for (int i = 0; i < list.size(); i++) {
                    if (temp > list.get(i)) {
                        temp = list.get(i);
                        sb.append(temp);
                        list.remove(i);
                        if (temp == min ) {
                            isForward = true;
                            break;
                        }
                    }
                }
            }
        }
        return sb.toString();
    }

    static String sortString1(String s) {
        StringBuilder sb = new StringBuilder();

        while (s.length() > 0) {
            char c = s.charAt(0);
            for (int i = 1; i < s.length(); i++) {
                if (c > s.charAt(i)) {
                    c = s.charAt(i);
                }
            }
            sb.append(c);
            s = s.substring(1);
        }
        return "";
    }
}
