package LeetCode.medium;

public class Problem1804 {
    //https://leetcode.com/problems/implement-trie-ii-prefix-tree
    public static void main(String[] args) {

    }

    //nn
    //25min
    //Runtime
    //81
    //ms
    //Beats
    //29.22%
    //Analyze Complexity
    //Memory
    //59.79
    //MB
    //Beats
    //18.42%
    TrieNode head;

//    public Trie() {
//        head = new TrieNode();
//        head.count = -1;
//    }

    public void insert(String word) {
        TrieNode temp = head;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int idx = c - 'a';
            if (temp.arr[idx] == null) {
                temp.arr[idx] = new TrieNode();
            }
            temp.arr[idx].count++;
            temp = temp.arr[idx];
        }
        temp.countEnd++;
    }

    public int countWordsEqualTo(String word) {
        TrieNode temp = head;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int idx = c - 'a';
            if (temp.arr[idx] == null) {
                return 0;
            }
            temp = temp.arr[idx];
        }
        return temp.countEnd;
    }

    public int countWordsStartingWith(String prefix) {
        TrieNode temp = head;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int idx = c - 'a';
            if (temp.arr[idx] == null) {
                return 0;
            }
            temp = temp.arr[idx];
        }
        return temp.count;
    }

    public void erase(String word) {
        TrieNode temp = head;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int idx = c - 'a';
            if (temp.arr[idx] == null) {
                return ;
            }
            int cc = temp.arr[idx].count;
            if (cc > 0)  temp.arr[idx].count--;
            temp = temp.arr[idx];
        }
        temp.countEnd--;
    }

    class TrieNode {
        int count, countEnd;
        TrieNode[] arr;

        public TrieNode() {
            count = 0;
            countEnd = 0;
            arr = new TrieNode[26];
        }
    }
}
