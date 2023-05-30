package LeetCode.medium;

public class Problem676 {
    //https://leetcode.com/problems/implement-magic-dictionary/
    public static void main(String[] args) {
        MagicDictionary dictionary = new MagicDictionary();
        dictionary.buildDict(new String[]{"hello", "leetcode"});
        System.out.println(dictionary.search("hello"));
        System.out.println(dictionary.search("hhllo"));
        System.out.println(dictionary.search("hell"));
        System.out.println(dictionary.search("leetcoded"));
    }

}
//10 min
//https://leetcode.com/problems/implement-magic-dictionary/solutions/3580361/java-straightforward-solution/
//Runtime
//35 ms
//Beats
//81.74%
//Memory
//44.4 MB
//Beats
//68.95%
class MagicDictionary {
    private String[] dictionary;

    public MagicDictionary() {

    }

    public void buildDict(String[] dictionary) {
        this.dictionary = dictionary;
    }

    public boolean search(String searchWord) {
        for (String word : dictionary) if (isMagical(searchWord, word)) return true;
        return false;
    }

    private boolean isMagical(String searchWord, String word) {
        if (searchWord.length() != word.length()) return false;
        int count = 0;
        for (int i = 0; i < word.length(); i++) if (word.charAt(i) != searchWord.charAt(i)) count++;
        return count == 1;
    }

    /*private boolean isMagical(int[] arr1, int[] arr2) {
        int diff = 0, sum1 = 0, sum2 = 0;
        for (int i = 0; i < arr1.length; i++) {
            diff += Math.abs(arr1[i] - arr2[i]);
            sum1 += arr1[i];
            sum2 += arr2[i];
        }
        return diff == 2 && sum1 == sum2;
    }*/
}
