package LeetCode.easy;

public class Problem2490 {
    //https://leetcode.com/problems/circular-sentence/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/circular-sentence/solutions/2882545/java-2ms-solution/
    //5-10mins
    //Runtime
    //2 ms
    //Beats
    //84.39%
    //Memory
    //43.2 MB
    //Beats
    //16.20%
    static boolean isCircularSentence(String s) {
        String[] arr = s.split(" ");
        int first = s.charAt(0), last = s.charAt(s.length() - 1);
        if (first != last) return false;
        for (int i = 0; i < arr.length - 1; i++) {
            String word1 = arr[i], word2 = arr[i + 1];
            if (word1.charAt(word1.length() - 1) != word2.charAt(0)) return false;
        }
        return true;
    }
}
