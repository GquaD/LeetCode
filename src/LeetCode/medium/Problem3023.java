package LeetCode.medium;

public class Problem3023 {
    //https://leetcode.com/problems/find-pattern-in-infinite-stream-i
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-pattern-in-infinite-stream-i/solutions/6339747/java-solution-by-tbekpro-jufr/
    //1hour
    //Runtime
    //26
    //ms
    //Beats
    //50.00%
    //Analyze Complexity
    //Memory
    //63.07
    //MB
    //Beats
    //12.50%
//    public int findPattern(InfiniteStream s, int[] pattern) {
//        List<Integer> list = new ArrayList<>();
//        while (true) {
//            list.add(s.next());
//            if (list.size() >= pattern.length) {
//                boolean hasMismatch = false;
//                for (int i = 0; i < pattern.length; i++) {
//                    if (list.get(list.size() - i - 1) != pattern[pattern.length - i - 1]) {
//                        hasMismatch = true;
//                        break;
//                    }
//                }
//                if (!hasMismatch) return list.size() - pattern.length;
//            }
//        }
//    }
}
