package LeetCode.medium;

import java.util.HashSet;
import java.util.Set;

public class Problem208 {
    //https://leetcode.com/problems/implement-trie-prefix-tree/description/
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
    }

    //https://leetcode.com/problems/implement-trie-prefix-tree/solutions/3258698/java-solution/
    //30 min
    //Runtime
    //40 ms
    //Beats
    //52.69%
    //Memory
    //51.5 MB
    //Beats
    //69.38%
    static class Trie {
        TrieNode head;
        Set<String> set;
        public Trie() {
            head = new TrieNode();
            set = new HashSet<>();
        }

        public void insert(String word) {
            TrieNode temp = head;
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                if (temp.children[c] == null) {
                    temp.children[c] = new TrieNode();
                }
                temp = temp.children[c];
            }
            set.add(word);
        }

        public boolean search(String word) {
            return set.contains(word);
        }

        public boolean startsWith(String prefix) {
            TrieNode temp = head;
            for (int i = 0; i < prefix.length(); i++) {
                if (temp.children[prefix.charAt(i) - 'a'] == null) return false;
                else temp = temp.children[prefix.charAt(i) - 'a'];
            }
            return true;
        }
    }

    static class TrieNode {
        TrieNode[] children;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }
}
