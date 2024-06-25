package LeetCode.medium;

public class Problem3098 {
    //https://leetcode.com/problems/guess-the-number-using-bitwise-questions-ii
    static int t;
    public static void main(String[] args) {
        t = 31;
        System.out.println(findNumber());
    }

    //nnn
    //Runtime
    //7
    //ms
    //Beats
    //34.62%
    //Memory
    //40.96
    //MB
    //Beats
    //46.15%
    static int findNumber() {
        int answer = 0;
        for(int i = 0; i <= 30; i++) {
            int mask = 1<<i;
            int zeroBits = commonBits(0);
            if(zeroBits < commonBits(mask)) {
                answer |= mask;
            }
        }
        return answer;
    }

    static int findNumber1() {
        StringBuilder sb = new StringBuilder();
        int c = 0, n = 0;
        for (int i = 0; i < 30; i++) {
            int count = commonBits(n);
            commonBits(n);
            if (count == c || count == 30) {
                sb.append(0);
            } else {
                sb.append(1);
            }
            c++;
            n = Integer.parseInt(sb.reverse().toString(), 2);
            sb.reverse();
        }
        return n;
    }

    private static int commonBits(int n) {
        return 1;
    }


}
