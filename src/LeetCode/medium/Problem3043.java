package LeetCode.medium;

public class Problem3043 {
    //https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix
    public static void main(String[] args) {

    }


    //https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/solutions/5827437/java-trie-97-faster/
    //25min
    //Runtime
    //30
    //ms
    //Beats
    //96.80%
    //Analyze Complexity
    //Memory
    //57.06
    //MB
    //Beats
    //16.40%
    private int longestCommonPrefix(int[] arr1, int[] arr2) {
        TrieNode[] trie = new TrieNode[10];
        for (int n : arr2) {
            String s = String.valueOf(n);
            TrieNode[] t = trie;
            for (int i = 0; i < s.length(); i++) {
                int v = s.charAt(i) - '0';
                if (t[v] == null) {
                    t[v] = new TrieNode(v);
                    t = t[v].children;
                } else {
                    t = t[v].children;
                }
            }
        }
        int maxPref = 0;
        for (int n : arr1) {
            String s = String.valueOf(n);
            TrieNode[] t = trie;
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                int v = s.charAt(i) - '0';
                if (t[v] == null) {
                    break;
                } else {
                    count++;
                    t = t[v].children;
                }
            }
            maxPref = Math.max(count, maxPref);
        }
        return maxPref;
    }

    class TrieNode {
        int val;
        TrieNode[] children;

        public TrieNode (int v) {
            val = v;
            children = new TrieNode[10];
        }
    }
}
