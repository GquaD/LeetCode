package LeetCode.easy;

public class Problem1455 {
    //https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
    public static void main(String[] args) {

    }

    //Runtime
    //2 ms
    //Beats
    //12.91%
    //Memory
    //42 MB
    //Beats
    //41.1%
    static int isPrefixOfWord(String sentence, String searchWord) {
        if (sentence.startsWith(searchWord)) return 1;
        int idx = sentence.indexOf(" " + searchWord);
        if (idx < 0) return -1;
        int count = 0;
        for (int i = 0; i <= idx; i++) {
            if (sentence.charAt(i) == ' ') count++;
        }
        return ++count;
    }

    //https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/solutions/2838225/java-3-line-solution/
    //Runtime
    //1 ms
    //Beats
    //51.47%
    //Memory
    //41.3 MB
    //Beats
    //77.45%
    static int isPrefixOfWord1(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) if (words[i].startsWith(searchWord)) return i + 1;
        return -1;
    }
}
