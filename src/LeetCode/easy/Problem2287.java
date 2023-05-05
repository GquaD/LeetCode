package LeetCode.easy;

public class Problem2287 {
    //https://leetcode.com/problems/rearrange-characters-to-make-target-string/description/
    public static void main(String[] args) {
        System.out.println(rearrangeCharacters("ilovecodingonleetcode", "code"));
    }

    //https://leetcode.com/problems/rearrange-characters-to-make-target-string/solutions/3486832/java-100-faster-6-lines-solution/
    //5 min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //40.5 MB
    //Beats
    //82.67%
    static int rearrangeCharacters(String s, String target) {
        int[] alphS = new int[26], alphT = new int[26];
        for (int i = 0; i < s.length(); i++) alphS[s.charAt(i) - 'a']++;
        for (int i = 0; i < target.length(); i++) alphT[target.charAt(i) - 'a']++;
        int min = 100;
        for (int i = 0; i < 26; i++) if (alphT[i] > 0 && min > alphS[i] / alphT[i]) min = alphS[i] / alphT[i];
        return min;
    }
}
