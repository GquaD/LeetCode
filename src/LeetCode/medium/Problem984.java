package LeetCode.medium;

public class Problem984 {
    //https://leetcode.com/problems/string-without-aaa-or-bbb/
    public static void main(String[] args) {
        System.out.println(strWithout3a3b(4,1));
        System.out.println(strWithout3a3b(6,3));
        System.out.println(strWithout3a3b(6,2));
        System.out.println(strWithout3a3b(2,5));
        System.out.println(strWithout3a3b(1,2));
        System.out.println(strWithout3a3b(1,4));
    }

    //https://leetcode.com/problems/string-without-aaa-or-bbb/solutions/3723901/java-o-n-using-stringbuilder/
    //50 min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //40.1 MB
    //Beats
    //68.3%
    static String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        if (a < 3 && b < 3) {
            for (int i = 0; i < a; i++) sb.append('a');
            for (int i = 0; i < b; i++) sb.append('b');
            return sb.toString();
        } else {
            if (a > b) {
                while (a > 0 || b > 0) {
                    if (a - b >= 1 && b > 0) {
                        sb.append("aab");
                        a -= 2;
                        b--;
                    } else {
                        if (a-- > 0) sb.append('a');
                        if (b-- > 0) sb.append('b');
                    }
                }
            } else if (b > a) {
                while (a > 0 || b > 0) {
                    if (b - a >= 1 && a > 0) {
                        sb.append("bba");
                        b -= 2;
                        a--;
                    } else {
                        if (a-- > 0) sb.append('a');
                        if (b-- > 0) sb.append('b');
                    }
                }
            } else {
                for (int i = 0; i < a; i++) sb.append("ab");
            }
        }
        return sb.toString();
    }

    static String strWithout3a3b2(int a, int b) {
        StringBuilder sb = new StringBuilder();
        if (a < 3 && b < 3) {
            for (int i = 0; i < a; i++) sb.append('a');
            for (int i = 0; i < b; i++) sb.append('b');
            return sb.toString();
        } else {
            if (a > b) {
                int startB = a, c = 2;
                for (int i = 0; i < a; i++) sb.append('a');
                for (int i = 0; i < b; i++) sb.append('b');
                for (int i = a; i < sb.length(); i++) {
                    sb.setCharAt(c, 'b');
                    sb.setCharAt(i, 'a');
                    c += 3;
                }
            } else if (b > a) {
                int startA = a, c = 2;
                for (int i = 0; i < b; i++) sb.append('b');
                for (int i = 0; i < a; i++) sb.append('a');
                for (int i = b; i < sb.length(); i++) {
                    sb.setCharAt(c, 'a');
                    sb.setCharAt(i, 'b');
                    c += 3;
                }
            } else {
                for (int i = 0; i < a; i++) sb.append("ab");
            }
            return sb.toString();
        }
    }

    //Wrong Answer
    //
    //38 / 103
    static String strWithout3a3b1(int a, int b) {
        StringBuilder sb = new StringBuilder();
        if (a < 3 && b < 3) {
            for (int i = 0; i < a; i++) sb.append('a');
            for (int i = 0; i < b; i++) sb.append('b');
            return sb.toString();
        } else {
            if (a > b) {
                int countA = 0, countB = 0;
                while (a > 0 || b > 0) {
                    while (a > 0 && countA < 2) {
                        sb.append('a');
                        a--;
                        countA++;
                    }
                    while (b > 0 && countB < 2) {
                        sb.append('b');
                        b--;
                        countB++;
                    }
                    countA = 0;
                    countB = 0;
                }
            } else if (b > a) {
                int countA = 0, countB = 0;
                while (a > 0 || b > 0) {
                    while (b > 0 && countB < 2) {
                        sb.append('b');
                        b--;
                        countB++;
                    }
                    while (a > 0 && countA < 2) {
                        sb.append('a');
                        a--;
                        countA++;
                    }
                    countA = 0;
                    countB = 0;
                }
            } else {
                for (int i = 0; i < a; i++) sb.append("ab");
            }
        }
        return sb.toString();
    }
}
