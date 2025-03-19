package LeetCode.easy;

public class Problem3491 {
    //https://leetcode.com/problems/phone-number-prefix/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/phone-number-prefix/solutions/6551321/java-2ms-solution-by-tbekpro-ka16/
    //2min
    //Runtime
    //2
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //42.54
    //MB
    //Beats
    //100.00%
    public boolean phonePrefix(String[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            String a = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                String b = numbers[j];
                if (a.startsWith(b) || b.startsWith(a)) return false;
            }
        }
        return true;
    }
}
