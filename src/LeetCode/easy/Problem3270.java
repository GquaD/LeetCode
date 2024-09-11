package LeetCode.easy;

public class Problem3270 {
    //https://leetcode.com/problems/find-the-key-of-the-numbers/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/find-the-key-of-the-numbers/solutions/5770367/java-o-1-solution/
    //10min
    //Runtime
    //1
    //ms
    //Beats
    //99.07%
    //Analyze Complexity
    //Memory
    //40.86
    //MB
    //Beats
    //87.90%
    static int generateKey(int num1, int num2, int num3) {
        int[] arr = new int[]{0,0,0,0};
        arr[0] = Math.min(num1 / 1000, Math.min(num2 / 1000, num3 / 1000));
        num1 %= 1000;
        num2 %= 1000;
        num3 %= 1000;
        arr[1] = Math.min(num1 / 100, Math.min(num2 / 100, num3 / 100));
        num1 %= 100;
        num2 %= 100;
        num3 %= 100;
        arr[2] = Math.min(num1 / 10, Math.min(num2 / 10, num3 / 10));
        num1 %= 10;
        num2 %= 10;
        num3 %= 10;
        arr[3] = Math.min(num1, Math.min(num2, num3));
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]);
        sb.append(arr[1]);
        sb.append(arr[2]);
        sb.append(arr[3]);
        return Integer.parseInt(sb.toString());
    }
}
