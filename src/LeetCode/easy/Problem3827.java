package LeetCode.easy;

public class Problem3827 {
    //10min
    //Runtime
    //1
    //ms
    //Beats
    //99.21%
    //Analyze Complexity
    //Memory
    //42.56
    //MB
    //Beats
    //87.93%
    public int countMonobit(int n) {
        int pow = 0, num = 0, count = -1;
        while (pow <= 10 && num <= n) {
            num = (int)(Math.pow(2, pow++) - 1);
            count++;
        }
        return count;
    }
}
