package LeetCode.medium;

public class Problem1506 {
    //https://leetcode.com/problems/find-root-of-n-ary-tree
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-root-of-n-ary-tree/solutions/4692412/java-o-n-hashmap/
    //5-10min
    //Runtime
    //25
    //ms
    //Beats
    //11.30%
    //of users with Java
    //Memory
    //49.92
    //MB
    //Beats
    //66.52%
    //of users with Java
/*    static Node findRoot(List<Node> list) {
        Map<Node, Integer> map = new HashMap<>();
        for (Node node : list) {
            map.put(node, map.getOrDefault(node, 0) + 1);
            if (node.children != null) {
                for (Node c : node.children) {
                    map.put(c, map.getOrDefault(c, 0) + 1);
                }
            }
        }
        for (Node node : map.keySet()) {
            if (map.get(node) == 1) return node;
        }
        return null;
    }*/
}
