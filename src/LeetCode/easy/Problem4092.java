package LeetCode.easy;

public class Problem4092 {
    //2 min
    //Runtime
    //2
    //ms
    //Beats
    //-%
    //Memory
    //42.17
    //MB
    //Beats
    //100.00%
    public int calculateScore(int a, int b) {
        int counta = Integer.bitCount(a), countb = Integer.bitCount(b);
        return counta >= countb ? counta * countb : countb / counta;
    }
}
