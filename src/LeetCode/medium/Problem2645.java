package LeetCode.medium;

public class Problem2645 {
    //https://leetcode.com/problems/minimum-additions-to-make-valid-string/
    public static void main(String[] args) {
        System.out.println(addMinimum("aaaaab"));
        System.out.println(addMinimum("b"));
        System.out.println(addMinimum("aaa"));
        System.out.println(addMinimum("abc"));
        System.out.println(addMinimum("acaababcbca"));
    }

    //https://leetcode.com/problems/minimum-additions-to-make-valid-string/solutions/3553375/java-2ms-solution/
    //Runtime
    //2 ms
    //Beats
    //97.92%
    //Memory
    //41.3 MB
    //Beats
    //100%
    static int addMinimum(String word) {
        if (word.length() == 1) return 2;
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char one = word.charAt(i);
            if (one == 'a') {
                if (i + 1 >= word.length()) {
                    count += 2;
                    continue;
                }
                char two = word.charAt(i + 1);
                if (two == 'b') {
                    if (i + 2 >= word.length()) {
                        count += 1;
                        i++;
                        continue;
                    }
                    char three = word.charAt(i + 2);
                    if (three == 'c') i += 2;
                    else {
                        i += 1;
                        count += 1;
                    }
                } else if (two == 'c') {
                    i += 1;
                    count += 1;
                } else count += 2;
            } else if (one == 'b') {
                if (i + 1 >= word.length()) {
                    count += 2;
                    continue;
                }
                char two = word.charAt(i + 1);
                if (two == 'c') {
                    i += 1;
                    count += 1;
                } else {
                    count += 2;
                }
            } else count += 2;
        }
        return count;
    }
}
