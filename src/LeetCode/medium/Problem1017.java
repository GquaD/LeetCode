package LeetCode.medium;

public class Problem1017 {
    //https://leetcode.com/problems/convert-to-base-2/
    public static void main(String[] args) {
//        System.out.println(baseNeg2(2));
//        System.out.println(baseNeg2(3));
//        System.out.println(baseNeg2(4));
//        System.out.println(baseNeg2(5));
//        System.out.println(baseNeg2(6));
        System.out.println(baseNeg2(7));
        System.out.println(baseNeg2(8));
    }

    //nnnn https://en.wikipedia.org/wiki/Negative_base#Java
    //Runtime
    //Details
    //1ms
    //Beats 56.86%of users with Java
    //Memory
    //Details
    //40.22mb
    //Beats 42.16%of users with Java
    static String baseNeg2(int n) {
        if (n == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int temp = n % -2;
            n /= -2;
            if (temp < 0) {
                temp += Math.abs(-2);
                n++;
            }
            sb.append(temp);
        }
        return sb.reverse().toString();
    }


    static String baseNeg21(int n) {
        if (n == 0) return "0";
        if (n == 1) return "1";
        if (n == 2) return "110";
        if (n == 3) return "111";

        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(Math.abs(n % -2));
            n = n / -2;
        }
        return sb.reverse().toString();
    }

    /*if (n == 1) {
                sb.append("100");
                break;
            }
            if (n == 2) {
                sb.append("011");
                break;
            }
            if (n == 3) {
                sb.append("111");
                break;
            }*/
}
