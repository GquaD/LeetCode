package LeetCode.easy;

public class Problem258 {
    //https://leetcode.com/problems/add-digits/
    public static void main(String[] args) {
        System.out.println(addDigits(38));
        System.out.println(addDigits(0));
    }

    //https://leetcode.com/problems/add-digits/solutions/2813090/java-in-2-ms/
    //5 mins
    //Runtime
    //1 ms
    //Beats
    //100%
    //Memory
    //40.1 MB
    //Beats
    //33.19%
    static int addDigits(int num) {
        while (num > 9) {
            int t = num, sum = 0;
            while (t > 0) {
                sum += t % 10;
                t /= 10;
            }
            num = sum;
        }
        return num;
    }
}
