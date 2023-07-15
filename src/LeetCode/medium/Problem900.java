package LeetCode.medium;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem900 {
    //https://leetcode.com/problems/rle-iterator/

    public static void main(String[] args) {
        RLEIterator it = new RLEIterator(new int[]{3,8,0,9,2,5});
        System.out.println(it.next(2));
        System.out.println(it.next(1));
        System.out.println(it.next(1));
        System.out.println(it.next(1));
        System.out.println(it.next(1));
    }

}

//https://leetcode.com/problems/rle-iterator/solutions/3769655/java-using-index-count/
//20-25 min
//Runtime
//Details
//5ms
//Beats 96.98%of users with Java
//Memory
//Details
//41.93mb
//Beats 40.20%of users with Java
class RLEIterator {

    int idx;
    int[] arr;
    public RLEIterator(int[] encoding) {
        idx = 0;
        arr = encoding;
    }

    public int next(int n) {
        while (n > 0) {
            if (idx >= arr.length) return -1;
            int times = arr[idx];
            if (n < times) {
                arr[idx] -= n;
                return arr[idx + 1];
            } else if (n == times) {
                idx += 2;
                return arr[idx - 1];
            } else {
                n -= times;
                idx += 2;
            }
        }
        return -1;
    }
}

////https://leetcode.com/problems/rle-iterator/solutions/3769624/java-using-linkedlist/
//Runtime
//Details
//6ms
//Beats 39.20%of users with Java
//Memory
//Details
//42.36mb
//Beats 7.54%of users with Java
class RLEIterator2 {

    int idx;
    LinkedList<Pair<Integer, Integer>> list;

    public RLEIterator2(int[] encoding) {
       idx = -1;
       list = new LinkedList<>();
        for (int i = 0; i < encoding.length; i+= 2)
            if (encoding[i] != 0)
                list.add(new Pair<>(encoding[i], encoding[i + 1]));


    }
    public int next(int n) {
        if (list.size() == 0) return -1;
        while (n > 0) {
            Pair<Integer, Integer> pair = list.pollFirst();
            int times = pair.getKey();
            if (n < times) {
                list.addFirst(new Pair<>(times - n, pair.getValue()));
                return pair.getValue();
            } else if (n == times) {
                return pair.getValue();
            } else {
                n -= times;
            }
            if (list.isEmpty()) break;
        }
        return -1;
    }

}


//Memory Limit Exceeded
//4 / 11
class RLEIterator1 {

    int idx;
    List<Integer> list;

    public RLEIterator1(int[] encoding) {
        list = new ArrayList<>();
        idx = -1;
        for (int i = 0; i < encoding.length; i += 2) for (int j = 0; j < encoding[i]; j++) list.add(encoding[i + 1]);
    }

    public int next(int n) {
//        idx += idx == 0 ? n - 1 : n;
        idx += n;
        if (idx >= list.size())
            return -1;

        return list.get(idx);
    }
}
