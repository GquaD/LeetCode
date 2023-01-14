package LeetCode.medium;

import java.util.PriorityQueue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Problem1061 {
    //https://leetcode.com/problems/lexicographically-smallest-equivalent-string/description/
    public static void main(String[] args) {
        System.out.println(smallestEquivalentString("bcfeaabddgcdaefcbfadggfagfgfedeefbebdbeefbecggcgge", "feegaacabcfadggfcaabcbadbbecbfdcabgeaegfcagdfggdgg", "mytnpodxbwxcxcplapgrqjzkfrkizffkbquwqbkxmpqjmxykvb"));
        System.out.println(smallestEquivalentString("parker", "morris", "parser"));
        System.out.println(smallestEquivalentString("hello", "world", "hold"));
        System.out.println(smallestEquivalentString("leetcode", "programs", "sourcecode"));
    }

    //https://leetcode.com/problems/lexicographically-smallest-equivalent-string/solutions/3048657/java-alphabetical-array-of-treesets/
    //45 - 60 min
    //Runtime
    //18 ms
    //Beats
    //11.93%
    //Memory
    //42.5 MB
    //Beats
    //52.27%
    static String smallestEquivalentString3(String s1, String s2, String baseStr) {
        Set<Character>[] arr = new Set[26];
        for (int i = 0; i < s1.length(); i++) {
            char a = s1.charAt(i), b = s2.charAt(i);
            if (arr[a - 'a'] == null && arr[b - 'a'] == null) {
                Set<Character> set = new TreeSet<>();
                set.add(a);
                set.add(b);
                arr[a - 'a'] = set;
                arr[b - 'a'] = set;
            } else if (arr[a - 'a'] == null && arr[b - 'a'] != null) {
                Set<Character> set = arr[b - 'a'];
                set.add(a);
                arr[a - 'a'] = set;
            } else if (arr[a - 'a'] != null && arr[b - 'a'] == null) {
                Set<Character> set = arr[a - 'a'];
                set.add(b);
                arr[b - 'a'] = set;
            } else {
                arr[a - 'a'].add(b);
                arr[b - 'a'].add(a);
            }
        }

        for (int i = 0; i < arr.length - 1; i++) {
            Set<Character> one = arr[i];
            if (one != null) {
                for (int j = i + 1; j < arr.length; j++) {
                    Set<Character> two = arr[j];
                    for (char c : one) {
                        if (two != null && two.contains(c)) {
                            one.addAll(two);
                            arr[j] = one;
                            break;
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            if (arr[c - 'a'] == null) sb.append(c);
            else {
                for (char curr: arr[c - 'a']) {
                    sb.append(curr);
                    break;
                }
            }
        }
        return sb.toString();
    }

    static String smallestEquivalentString2(String s1, String s2, String baseStr) {
        char[] arr = new char[26];
        for (int i = 0; i < s1.length(); i++) {
            char a = s1.charAt(i), b = s2.charAt(i);
            if (arr[a - 'a'] < 'a' && arr[b - 'a'] < 'a') {
                arr[a - 'a'] = arr[b - 'a'] = a <= b ? a : b;
            } else if (arr[a - 'a'] >= 'a' && arr[b - 'a'] < 'a') {
                arr[b - 'a'] = arr[a - 'a'] = arr[a - 'a'] <= b ? arr[a - 'a'] : b;
            } else if (arr[a - 'a'] < 'a' && arr[b - 'a'] >= 'a') {
                arr[a - 'a'] = arr[b - 'a'] = arr[b - 'a'] <= b ? arr[b - 'a'] : b;
            } else {
                arr[a - 'a'] = arr[b - 'a'] = (char) Math.min(arr[a - 'a'], arr[b - 'a']);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            if (arr[c - 'a'] < 'a') sb.append(c);
            else sb.append(arr[c - 'a']);
        }
        return sb.toString();
    }

    static String smallestEquivalentString(String s1, String s2, String baseStr) {
        PriorityQueue<Character>[] arr = new PriorityQueue[26];
        for (int i = 0; i < s1.length(); i++) {
            char a = s1.charAt(i), b = s2.charAt(i);
            if (arr[a - 'a'] == null && arr[b - 'a'] == null) {
                PriorityQueue<Character> queue = new PriorityQueue<>();
                queue.offer(a);
                queue.offer(b);
                arr[a - 'a'] = queue;
                arr[b - 'a'] = queue;
            } else if (arr[a - 'a'] == null && arr[b - 'a'] != null) {
                PriorityQueue<Character> queue = arr[b - 'a'];
                queue.add(a);
                arr[a - 'a'] = queue;
            } else if (arr[a - 'a'] != null && arr[b - 'a'] == null) {
                PriorityQueue<Character> queue = arr[a - 'a'];
                queue.add(b);
                arr[b - 'a'] = queue;
            } else {
                arr[a - 'a'].offer(b);
                arr[b - 'a'].offer(a);
            }
        }

        for (int i = 0; i < arr.length - 1; i++) {
            PriorityQueue<Character> one = arr[i];
            if (one != null) {
                for (int j = i + 1; j < arr.length; j++) {
                    PriorityQueue<Character> two = arr[j];
                    for (char c : one) {
                        if (two != null && two.contains(c)) {
                            addAll(two, one);
                            arr[j] = two;
                            break;
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            if (arr[c - 'a'] == null) sb.append(c);
            else sb.append(arr[c - 'a'].peek());
        }
        return sb.toString();
    }

    private static void addAll(PriorityQueue<Character> one, PriorityQueue<Character> two) {
        for (char c : two) one.offer(c);
    }
}
