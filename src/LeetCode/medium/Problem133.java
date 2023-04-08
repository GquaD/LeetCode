package LeetCode.medium;

import java.util.*;

public class Problem133 {
    //https://leetcode.com/problems/clone-graph/
    public static void main(String[] args) {
        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);
        GraphNode n3 = new GraphNode(3);
        GraphNode n4 = new GraphNode(4);
        List<GraphNode> ns1 = new ArrayList<>();
        ns1.add(n2);
        ns1.add(n4);
        n1.neighbors = ns1;
        List<GraphNode> ns2 = new ArrayList<>();
        ns2.add(n1);
        ns2.add(n3);
        n2.neighbors = ns2;
        List<GraphNode> ns3 = new ArrayList<>();
        ns3.add(n2);
        ns3.add(n4);
        n3.neighbors = ns3;
        List<GraphNode> ns4 = new ArrayList<>();
        ns4.add(n1);
        ns4.add(n3);
        n4.neighbors = ns4;
        GraphNode g = cloneGraph(n1);
        System.out.println(g.val);
    }

    //https://leetcode.com/problems/clone-graph/solutions/3392396/java-bfs-array-solution/
    //20-25 min
    //Runtime
    //27 ms
    //Beats
    //23.16%
    //Memory
    //42.7 MB
    //Beats
    //49.92%
    static GraphNode cloneGraph(GraphNode node) {
        if (node == null) return null;
        GraphNode origHead = node, copyHead = new GraphNode(node.val), curr = copyHead;
        boolean[] visited = new boolean[101];
        GraphNode[] nodesCopy = new GraphNode[101];
        nodesCopy[copyHead.val] = copyHead;
        Queue<GraphNode> queue = new LinkedList<>();
        queue.offer(origHead);
        while (!queue.isEmpty()) {
            GraphNode temp = queue.poll();
            if (visited[temp.val]) continue;
            curr = nodesCopy[temp.val];
            visited[temp.val] = true;
            List<GraphNode> listNeighbors = new ArrayList<>();
            for (GraphNode n : temp.neighbors) {
                queue.offer(n);
                GraphNode newCopy = nodesCopy[n.val] == null ? new GraphNode(n.val) : nodesCopy[n.val];
                listNeighbors.add(newCopy);
                nodesCopy[newCopy.val] = newCopy;
            }
            curr.neighbors = listNeighbors;

        }
        return copyHead;
    }

/*    static GraphNode cloneGraph2(GraphNode node) {
        if (node == null) return null;
        Node origHead = node, copyHead = new Node(node.val), curr = copyHead;
        boolean[] visited = new boolean[101];
        Node[] nodesCopy = new Node[101];
        nodesCopy[copyHead.val] = copyHead;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(origHead);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (visited[temp.val]) continue;
            curr = nodesCopy[temp.val];
            visited[temp.val] = true;
            List<Node> listNeighbors = new ArrayList<>();
            for (Node n : temp.neighbors) {
                queue.offer(n);
                Node newCopy = nodesCopy[n.val] == null ? new Node(n.val) : nodesCopy[n.val];
                listNeighbors.add(newCopy);
                nodesCopy[newCopy.val] = newCopy;
            }
            curr.neighbors = listNeighbors;

        }
        return copyHead;
    }*/

    //says I didn't copy however I did - strange
    static GraphNode cloneGraph1(GraphNode node) {
        if (node == null) return null;
        GraphNode origHead = node, copyHead = new GraphNode(node.val), curr = copyHead;
        traverseGraphDFS(node, curr, new HashMap<>(), new HashSet<>());
        return copyHead;
    }

    private static void traverseGraphDFS(GraphNode node, GraphNode curr, Map<Integer, List<GraphNode>> map, Set<Integer> visited) {
        if (node == null) return;

        if (map.containsKey(node.val)) {
            curr.neighbors = map.get(curr.val);
        }
        if (map.containsKey(node.val)) return;

        List<GraphNode> nsCopy = new ArrayList<>();
        if (!map.containsKey(node.val)) {
            map.put(node.val, nsCopy);
        }
        visited.add(node.val);
        for (int i = 0; i < node.neighbors.size(); i++) {
            GraphNode temp = node.neighbors.get(i);
            GraphNode newNode = new GraphNode(temp.val);
            traverseGraphDFS(temp, newNode, map, visited);
            map.get(node.val).add(newNode);
        }
        visited.remove(node.val);
        if (map.containsKey(node.val)) {
            curr.neighbors = map.get(curr.val);
        }
    }
}
