package LeetCode.easy;

import java.util.HashSet;
import java.util.Set;

public class Problem929 {
    //https://leetcode.com/problems/unique-email-addresses/
    public static void main(String[] args) {
        System.out.println(numUniqueEmails(new String[]{"a@leetcode.com","b@leetcode.com","c@leetcode.com"}));
    }

    //https://leetcode.com/problems/unique-email-addresses/solutions/2717478/java-straightforward-solution/
    //10 mins
    //Runtime
    //38 ms
    //Beats
    //38.20%
    //Memory
    //54.5 MB
    //Beats
    //19.29%
    static int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            int indexOfAt = email.indexOf('@');
            String front = email.substring(0, indexOfAt);
            int index = front.indexOf('+');
            if (index >= 0) {
                front = front.substring(0, index);
            }
            front = front.replaceAll("\\.", "");
            String finalString = front + email.substring(indexOfAt);
            set.add(finalString);
        }
        return set.size();
    }
}
