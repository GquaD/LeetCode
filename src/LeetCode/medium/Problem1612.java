package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem1612 {
    //https://leetcode.com/problems/check-if-two-expression-trees-are-equivalent
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/check-if-two-expression-trees-are-equivalent/solutions/5864177/java-hashmap-dfs-solution/
    //5min
    //Runtime
    //10
    //ms
    //Beats
    //37.50%
    //Analyze Complexity
    //Memory
    //45.57
    //MB
    //Beats
    //82.50%
    public boolean checkEquivalence(Node root1, Node root2) {
        Map<Character, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();

        goDFS(root1, map1);
        goDFS(root2, map2);

        for (char c: map1.keySet()) {
            if (map1.get(c) != map2.get(c)) return false;
            map2.remove(c);
        }
        return map2.isEmpty();
    }

    private void goDFS(Node node, Map<Character, Integer> map) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        }
        goDFS(node.left, map);
        goDFS(node.right, map);
    }

    
      class Node {
          char val;
          Node left;
          Node right;
          Node() {this.val = ' ';}
          Node(char val) { this.val = val; }
          Node(char val, Node left, Node right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
}
