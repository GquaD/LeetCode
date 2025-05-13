package LeetCode.easy;

public class Problem3545 {
    //https://leetcode.com/problems/minimum-deletions-for-at-most-k-distinct-characters
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/minimum-deletions-for-at-most-k-distinct-characters/solutions/6740597/java-on-solution-by-tbekpro-x35p/
    //5min
    //Runtime
    //2
    //ms
    //Beats
    //97.59%
    //Analyze Complexity
    //Memory
    //42.30
    //MB
    //Beats
    //99.07%
//    public int minDeletion(String s, int k) {
//        int[] arr = new int[26];
//        for (int i = 0; i < s.length(); i++) arr[s.charAt(i) - 'a']++;
//        PriorityQueue<Integer> pq = new PriorityQueue();
//        for (int n: arr) if (n > 0) pq.offer(n);
//        int count = 0;
//        while (pq.size() > k) {
//            count += pq.poll();
//        }
//        return count;
//    }
}
