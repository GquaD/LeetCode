package LeetCode.medium;

public class Problem3121 {
    //https://leetcode.com/problems/count-the-number-of-special-characters-ii/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/count-the-number-of-special-characters-ii/solutions/5058676/java-o-n-solution/
    //30min
    //Runtime
    //25
    //ms
    //Beats
    //33.33%
    //of users with Java
    //Memory
    //45.90
    //MB
    //Beats
    //66.67%
    //of users with Java
    static int numberOfSpecialChars(String word) {
        Special[] arr = new Special[26];
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (Character.isLowerCase(c)) {
                if (arr[c - 'a'] == null) {
                    arr[c - 'a'] = new Special();
                }
                arr[c - 'a'].low = true;
                if (arr[c - 'a'].uppercaseOccured) {
                    arr[c - 'a'].valid = -100000;
                }
            } else {
                if (arr[c - 'A'] == null) {
                    arr[c - 'A'] = new Special();
                }
                arr[c - 'A'].uppercaseOccured = true;
                if (arr[c - 'A'].low && arr[c - 'A'].valid != -100000) {
                    arr[c - 'A'].valid++;
                }

            }
        }
        int count = 0;
        for (Special s : arr) {
            if (s != null && s.valid > 0) count++;
        }
        return count;
    }
}

class Special {
    boolean low;
    boolean uppercaseOccured;
    int valid;
}
