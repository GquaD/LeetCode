package LeetCode.medium;

import java.util.*;

public class Problem1557 {
    //https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
    public static void main(String[] args) {

    }

    //wrong
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        Set<Integer> allNums = new HashSet<>();
        for (int i = 0; i < edges.size(); i++) {
            int key = edges.get(i).get(0);
            int val = edges.get(i).get(1);
            allNums.add(key);
            allNums.add(val);
            if (map.containsKey(key)) {
                map.get(key).add(val);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(val);
                map.put(key, list);
            }
        }


            /*int keyTemp = 0;
            for (Integer key : map.keySet()) {
                keyTemp = key;
                visited.put(key, true);
                visitedSet.add(key);
                list.add(key);

                List<Integer> values = map.get(key);
                for (int i = 0; i < values.size(); i++) {
                    visited.put(values.get(i), true);
                    visitedSet.add(values.get(i));
                }
                break;
            }
            map.remove(keyTemp);*/
        Set<Integer> visitedSet = new HashSet<>();
        List<List<Integer>> variants = new ArrayList<>();
        //i - will be the index to skip
        for (Integer greaterKey: map.keySet()) {
            List<Integer> list = new ArrayList<>();
            for (Integer key : map.keySet()) {
                if (key.equals(greaterKey)) continue;
                if (!visitedSet.contains(key)) {
                    list.add(key);
                }
                visitedSet.add(key);
                List<Integer> values = map.get(key);
                for (int j = 0; j < values.size(); j++) {
                    visitedSet.add(values.get(j));
                }
            }
            if (allNums.size() == variants.size()) {
                variants.add(list);
            }
            visitedSet = new HashSet<>();
        }
        List<Integer> list = new ArrayList<>();
        int minSize = Integer.MAX_VALUE;
        for (int i = 0; i < variants.size(); i++) {
            if (minSize > variants.get(i).size()) {
                minSize = variants.get(i).size();
                list = variants.get(i);
            }
        }
        /*List<Integer> list = new ArrayList<>();
        Set<Integer> visitedSet = new HashSet<>();
        for (Integer key : map.keySet()) {
            if (!visitedSet.contains(key)) {
                list.add(key);
            }
            visitedSet.add(key);
            List<Integer> values = map.get(key);
            for (int i = 0; i < values.size(); i++) {
                visitedSet.add(values.get(i));
            }
        }*/

        return list;
    }

    static class TrieNode {
        int value;
        List<TrieNode> nodes;

        public TrieNode(int v) {
            value = v;
            nodes = new ArrayList<>();
        }
    }
}
