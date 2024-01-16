package LeetCode.medium;

public class Problem1358 {
    //https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("aaacb"));
        System.out.println(numberOfSubstrings("cabcb"));
    }

    //nnnn
    //Runtime
    //14
    //ms
    //Beats
    //55.11%
    //of users with Java
    //Memory
    //44.58
    //MB
    //Beats
    //29.73%
    //of users with Java
    static int numberOfSubstrings(String s) {
        int[] arr = new int[]{0,0,0};
        int res = 0, i = 0;
        for (int j = 0; j < s.length(); j++) {
            arr[s.charAt(j) - 'a']++;
            while (arr[0] > 0 && arr[1] > 0 && arr[2] > 0) {
                arr[s.charAt(i++) - 'a']--;
            }
            res += i;
        }
        return res;
    }
}
