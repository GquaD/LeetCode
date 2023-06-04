package LeetCode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem179 {
    //https://leetcode.com/problems/largest-number/
    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{30,301,34,5,9}));
        System.out.println(largestNumber(new int[]{432,43243}));
        System.out.println(largestNumber(new int[]{3,30,34,5,9}));
        System.out.println(largestNumber(new int[]{30,3,34,5,9}));
        System.out.println(largestNumber(new int[]{10, 2}));
    }

    //https://leetcode.com/problems/largest-number/solutions/3598443/java-o-nlogn-solution/
    //20 min
    //Runtime
    //7 ms
    //Beats
    //25.77%
    //Memory
    //43.6 MB
    //Beats
    //6.88%
    static String largestNumber(int[] nums) {
        PriorityQueue<String> pq = new PriorityQueue<>((s, t) -> (t + s).compareTo(s + t));
        for (int s : nums) pq.offer(Integer.toString(s));
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) sb.append(pq.poll());
        int zero = 0;
        String s = sb.toString();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') zero++;
            else break;
        }
        s = s.substring(zero);
        return s.length() > 0 ? s : "0";
    }

    private static int compareTwoStrings(String s, String t) {
        /*if (s.length() != t.length() && s.charAt(0) != t.charAt(0)) {
            int diff = Math.abs(s.length() - t.length());
            StringBuilder sb = new StringBuilder();
            sb.append(s.length() > t.length() ? t : s);
            for (int i = 0; i < diff; i++) sb.append((char)('9' + 1));
            s = sb.toString();
        }
        return t.compareTo(s);*/
        return (t + s).compareTo(s + t);
    }

    static String largestNumber1(int[] nums) {
        if (nums.length == 1) return nums[0] + "";
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) arr[i] = nums[i] + "";
        Arrays.sort(arr, new MyComparator());
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) sb.append(arr[i]);
        return sb.toString();
    }

    static class MyComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            String s1 = (String) o1, s2 = (String) o2;
            if (s1.length() > s2.length()) {
                char temp = s2.charAt(0);
                while (s1.length() > 0) {
                    char cMax = s1.charAt(0);
                    char cMin = s2.length() > 0 ? s2.charAt(0) : temp;
                    if (cMax == cMin) {
                        s1 = s1.substring(1);
                        if (s2.length() > 0) s2 = s2.substring(1);
                    } else if (cMax > cMin) {
                        return 1;
                    } else return -1;
                }
            } else {
                char temp = s1.charAt(0);
                while (s2.length() > 0) {
                    char cMax = s2.charAt(0);
                    char cMin = s1.length() > 0 ? s1.charAt(0) : temp;
                    if (cMax == cMin) {
                        s2 = s2.substring(1);
                        if (s1.length() > 0) s1 = s1.substring(1);
                    } else if (cMax > cMin) {
                        return -1;
                    } else return 1;
                }
            }
            return 0;
        }

    }
}
