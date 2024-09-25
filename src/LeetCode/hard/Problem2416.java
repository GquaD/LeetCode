package LeetCode.hard;

public class Problem2416 {
    //https://leetcode.com/problems/sum-of-prefix-scores-of-strings
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/sum-of-prefix-scores-of-strings/solutions/5831643/java-using-trie/
    //5-10min
    //reused yesterday's medium task's code
    //Runtime
    //328
    //ms
    //Beats
    //38.71%
    //Analyze Complexity
    //Memory
    //204.58
    //MB
    //Beats
    //49.68%
    public int[] sumPrefixScores(String[] words) {
        TrieNode[] trie = new TrieNode[26];
        for (String s : words) {
            TrieNode[] t = trie;
            for (int i = 0; i < s.length(); i++) {
                int v = s.charAt(i) - 'a';
                if (t[v] == null) {
                    t[v] = new TrieNode();
                    t = t[v].children;
                } else {
                    t[v].val++;
                    t = t[v].children;
                }
            }
        }
        int c = 0, arr[] = new int[words.length];
        for (String s : words) {
            TrieNode[] t = trie;
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                int v = s.charAt(i) - 'a';
                if (t[v] == null) {
                    break;
                } else {
                    count += t[v].val;
                    t = t[v].children;
                }
            }
            arr[c++] = count;
        }
        return arr;
    }

    class TrieNode {
        int val;
        TrieNode[] children;

        public TrieNode () {
            val = 1;
            children = new TrieNode[26];
        }
    }
}
