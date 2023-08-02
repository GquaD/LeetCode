package LeetCode.medium;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Problem1352 {
    //https://leetcode.com/problems/product-of-the-last-k-numbers/
    public static void main(String[] args) {

    }
}

//https://leetcode.com/problems/product-of-the-last-k-numbers/solutions/3854636/java-arraylist-of-pairs-with-consecutive-frequency-for-1s/
//30-40min
//Runtime
//459 ms
//Beats
//22.92%
//Memory
//67.5 MB
//Beats
//25.81%

class ProductOfNumbers3 {

    List<Pair<Integer, Integer>> list;

    public ProductOfNumbers3() {
        list = new ArrayList<>();
    }

    public void add(int num) {
        if (num == 1 && list.size() > 0 && list.get(list.size() - 1).getKey() == 1)
            list.set(list.size() - 1, new Pair<>(1, list.get(list.size() - 1).getValue() + 1));
        else
            list.add(new Pair<>(num, 1));
    }

    public int getProduct(int k) {
        int prod = 1, count = k, i = list.size() - 1;
        while (count > 0) {
            Pair<Integer, Integer> pair = list.get(i--);
            count -= pair.getValue();
            prod *= pair.getKey();
        }
        return prod;
    }
}

//Time Limit Exceeded
//33 / 33
class ProductOfNumbers2 {

    List<Integer> list;

    public ProductOfNumbers2() {
        list = new ArrayList<>();
    }

    public void add(int num) {
        list.add(num);
    }

    public int getProduct(int k) {
        int p = 1;
        for (int i = list.size() - 1; i >= list.size() - k; i--)
            p *= list.get(i);
        return p;
    }
}

//Time Limit Exceeded
//31 / 33

class ProductOfNumbers1 {
    List<Integer> listP;
    public ProductOfNumbers1() {
        listP = new ArrayList<>();
    }

    public void add(int num) {
        for (int i = 0; i < listP.size(); i++) listP.set(i, listP.get(i) * num);
        listP.add(num);
    }

    public int getProduct(int k) {
        return listP.get(listP.size() - k);
    }
}
