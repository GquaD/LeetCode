package LeetCode.easy;

public class Problem157 {
    //https://leetcode.com/problems/read-n-characters-given-read4
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/read-n-characters-given-read4/solutions/6044366/java-100-faster-solution/
    //10min
    //Runtime
    //1
    //ms
    //Beats
    //100.00%
    //Analyze Complexity
    //Memory
    //41.12
    //MB
    //Beats
    //89.93%
    /*public class Solution extends Reader4 {
        *//**
         * @param buf Destination buffer
         * @param n   Number of characters to read
         * @return    The number of actual characters read
         *//*
        public int read(char[] buf, int n) {
            int count4 = 0;
            StringBuilder sb = new StringBuilder();
            int b = 0;
            while (count4 < n) {
                char[] temp = new char[5];
                int r = read4(temp);
                count4 += 4;
                for (int i = 0; i < 4; i++) {
                    if (temp[i] != temp[temp.length - 1] && b < n) {
                        sb.append(temp[i]);
                        b++;
                    }
                }
            }
            for (int i = 0; i < sb.length(); i++) {
                buf[i] = sb.charAt(i);
            }
            return b;
        }
    }*/
}
