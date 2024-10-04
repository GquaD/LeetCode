package LeetCode.medium;

public class Problem1634 {
    //https://leetcode.com/problems/add-two-polynomials-represented-as-linked-lists
    public static void main(String[] args) {

    }


    //https://leetcode.com/problems/add-two-polynomials-represented-as-linked-lists/solutions/5868557/java-using-treemap/
    //15min
    //Runtime
    //17
    //ms
    //Beats
    //15.06%
    //Analyze Complexity
    //Memory
    //52.16
    //MB
    //Beats
    //92.78%
    /*public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        Map<Integer, PolyNode> map = new TreeMap<>((a, b) -> b - a);
        PolyNode t1 = poly1, t2 = poly2;
        while (t1 != null) {
            map.put(t1.power, t1);
            t1 = t1.next;
        }
        while (t2 != null) {
            PolyNode cur = map.get(t2.power);
            if (cur == null) {
                map.put(t2.power, t2);
            } else {
                cur.coefficient += t2.coefficient;
            }
            t2 = t2.next;
        }
        PolyNode head = null, prev = null;
        for (int key : map.keySet()) {
            PolyNode cur = map.get(key);
            if (cur.coefficient == 0) continue;
            if (head == null) {
                head = cur;
                prev = cur;
                continue;
            }
            prev.next = cur;
            prev = cur;
        }
        if (prev != null) prev.next = null;
        return head;
    }*/
}
