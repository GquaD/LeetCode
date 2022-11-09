package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class Problem901 {
    //https://leetcode.com/problems/online-stock-span/
    public static void main(String[] args) {

    }

    //10-15min
    //Runtime
    //2002 ms
    //Beats
    //5.3%
    //Memory
    //50 MB
    //Beats
    //98.49%

    static class StockSpanner {
        List<Integer> prices;
        List<Integer> span;
        public StockSpanner() {
            prices = new ArrayList<>();
            span = new ArrayList<>();
        }

        public int next(int price) {
            if (prices.size() == 0) {
                prices.add(price);
                span.add(1);
                return 1;
            } else {
                prices.add(price);
                int count = 0;
                for (int i = prices.size() - 1; i >= 0; i--) {
                    if (price >= prices.get(i)) count++;
                    else break;
                }
                span.add(count);
                return count;
            }
        }
    }
}
