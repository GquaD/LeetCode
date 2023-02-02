package LeetCode.easy;

public class Problem953 {
    //https://leetcode.com/problems/verifying-an-alien-dictionary/description/
    public static void main(String[] args) {
        System.out.println(isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    }

    //https://leetcode.com/problems/verifying-an-alien-dictionary/solutions/3130047/java-100-faster-solution/
    //10 min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //40.8 MB
    //Beats
    //85.41%
    static boolean isAlienSorted(String[] words, String order) {
        int[] pos = new int[order.length()];
        for (int i = 0; i < order.length(); i++)
            pos[order.charAt(i) - 'a'] = i;
        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1], curr = words[i];
            int len = Math.min(prev.length(), curr.length());
            int countEqual = 0;
            for (int j = 0; j < len; j++) {
                char p = prev.charAt(j), c = curr.charAt(j);
                if (pos[p - 'a'] > pos[c - 'a']) return false;
                else if (pos[p - 'a'] == pos[c - 'a']) countEqual++;
                else break;
            }
            if (countEqual == len && prev.length() > curr.length()) return false;
        }
        return true;
    }
}
