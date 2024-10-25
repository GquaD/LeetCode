package LeetCode.medium;

import java.util.*;

public class Problem1233 {
    //https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/
    public static void main(String[] args) {
//        LeetCodeUtils.printList(removeSubfolders(new String[]{"/a","/a/b","/c/d","/c/d/e","/c/f"}));
//        LeetCodeUtils.printList(removeSubfolders(new String[]{"/a","/a/b/c","/a/b/d"}));
//        LeetCodeUtils.printList(removeSubfolders(new String[]{"/a/b/c","/a/b/ca","/a/b/d"}));
    }

    //https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/solutions/5966271/java-using-trie/
    //35min
    //Runtime
    //63
    //ms
    //Beats
    //36.53%
    //Analyze Complexity
    //Memory
    //65.64
    //MB
    //Beats
    //21.63%
    public List<String> removeSubfolders(String[] folder) {
        TrieNode head = new TrieNode("");
        for (String f : folder) {
            String[] split = f.split("/");
            TrieNode temp = head;
            for (int i = 1; i < split.length; i++) {
                String key = split[i];
                TrieNode cur = temp.map.get(key);
                if (cur == null) {
                    cur = new TrieNode(key);
                    temp.map.put(key, cur);
                }
                cur.count++;
                temp = cur;
            }
            temp.countEnd++;
        }

        List<String> list = new ArrayList<>();
        goDFS(head, new StringBuilder(), list);
        return list;
    }

    private void goDFS(TrieNode node, StringBuilder sb, List<String> list) {
        if (node == null) {
            return;
        }
        if (node.s.length() > 0) {
            sb.append("/").append(node.s);
        }
        if (node.count > 0 && node.countEnd == 1) {
            list.add(sb.toString());
            if (node.s.length() > 0) {
                sb.setLength(sb.length() - node.s.length() - 1);
            }
            return;
        }
        for (String key: node.map.keySet()) {
            goDFS(node.map.get(key), sb, list);
        }
        if (node.s.length() > 0) {
            sb.setLength(sb.length() - node.s.length() - 1);
        }
    }


    class TrieNode {
        String s;
        Map<String, TrieNode> map = new HashMap<>();
        int count = 0, countEnd = 0;

        public TrieNode(String a) {
            s = a;
        }
    }
}
