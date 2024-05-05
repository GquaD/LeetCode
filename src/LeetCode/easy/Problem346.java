package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem346 {
    //https://leetcode.com/problems/moving-average-from-data-stream/
    public static void main(String[] args) {

    }


}

//5min
//Runtime
//68
//ms
//Beats
//6.52%
//of users with Java
//Memory
//49.13
//MB
//Beats
//73.76%
//of users with Java
class MovingAverage {
    List<Integer> list;
    int size;
    public MovingAverage(int size) {
        list = new ArrayList<>();
        this.size = size;
    }

    public double next(int val) {
        list.add(val);
        int count = 0, sum = 0;
        if (list.size() < size) {
            for (int n: list)
                sum += n;
            return (1.0 * sum) / list.size();
        } else {
            for (int i = list.size() - 1; i >= list.size() - size; i--) {
                sum += list.get(i);
            }
            return (1.0 * sum) / size;
        }
    }
}
