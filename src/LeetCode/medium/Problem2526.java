package LeetCode.medium;

public class Problem2526 {
    //https://leetcode.com/problems/find-consecutive-integers-from-a-data-stream/
    public static void main(String[] args) {

    }

}

//https://leetcode.com/problems/find-consecutive-integers-from-a-data-stream/solutions/3670621/java-o-1-no-ds-solution/
//5 min
//Runtime
//33 ms
//Beats
//95.22%
//Memory
//93.6 MB
//Beats
//60.56%
class DataStream {

    int val, main, count;
    public DataStream(int value, int k) {
        val = value;
        main = k;
        count = 0;
    }

    public boolean consec(int num) {
        if (num == val) count++;
        else count = 0;
        return count >= main;
    }
}
