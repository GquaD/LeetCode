package LeetCode.easy;

public class Problem2399 {
    //https://leetcode.com/problems/check-distances-between-same-letters/

    public static void main(String[] args) {
        System.out.println(checkDistances("abaccb", new int[]{1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
        System.out.println(checkDistances("aa", new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
    }

    //https://leetcode.com/problems/check-distances-between-same-letters/discuss/2618147/Java-Solution-in-2-ms-or-No-HashMap-or-O(N)
    //40 mins
    //Runtime: 2 ms, faster than 76.00% of Java online submissions for Check Distances Between Same Letters.
    //Memory Usage: 43.9 MB, less than 17.11% of Java online submissions for Check Distances Between Same Letters.
    static boolean checkDistances(String s, int[] distance) {
        boolean[] booleans = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = i + distance[c - 'a'] + 1;
            if (idx < s.length() && !booleans[c - 'a'] && s.charAt(idx) != c || idx > s.length() - 1 && !booleans[c - 'a']) {
                return false;
            } else {
                booleans[c - 'a'] = true;
            }
        }
        return true;
    }
}
