package LeetCode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem211 {
    //https://leetcode.com/problems/design-add-and-search-words-data-structure/
    public static void main(String[] args) {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("bad");
        dictionary.addWord("dad");
        dictionary.addWord("mad");
        dictionary.search("pad");
        dictionary.search("bad");
        dictionary.search(".ad");
        dictionary.search("b..");
    }


/*    static class WordDictionary {
        TrieNode head;
        public WordDictionary() {
            head = new TrieNode('0');
        }

        public void addWord(String word) {
            TrieNode temp = head;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!temp.children.contains(c)) {
                    temp.children.add(new TrieNode(c));
                }
                temp = temp.children.get(temp.children.indexOf(c));
            }
        }

        public boolean search(String word) {
            TrieNode temp = head;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (c == '.') {
                    for (int j = 0; j < temp.children.size(); j++) {

                    }
                }
            }
        }

    }*/

    static class TrieNode {
        char letter;
        List<TrieNode> children;

        public TrieNode(char letter) {
            this.letter = letter;
            children = new ArrayList<>();
        }

    }

    //
    //20 min
    //Runtime
    //1453 ms
    //Beats
    //18.26%
    //Memory
    //50.6 MB
    //Beats
    //99.77%
    static class WordDictionary {
        HashSet<String> set;
        public WordDictionary() {
            set = new HashSet<>();
        }

        public void addWord(String word) {
            set.add(word);
        }

        public boolean search(String word) {
            if (!word.contains(".")) {
                return set.contains(word);
            } else {
                for (String s : set) {
                    if (s.length() == word.length()) {
                        boolean matches = true;
                        for (int i = 0; i < word.length(); i++) {
                            if (word.charAt(i) != '.') {
                                if (s.charAt(i) != word.charAt(i)) {
                                    matches = false;
                                    break;
                                }
                            }
                        }
                        if (matches) return true;
                    }
                }
                return false;
            }
        }
    }
}
