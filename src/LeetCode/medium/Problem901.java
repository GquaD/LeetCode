package LeetCode.medium;

import java.util.*;

public class Problem901 {
    //https://leetcode.com/problems/online-stock-span/
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        StringBuilder sb = new StringBuilder();
        sb.append(stockSpanner.next(100) + ", ");
        sb.append(stockSpanner.next(80) + ", ");
        sb.append(stockSpanner.next(60) + ", ");
        sb.append(stockSpanner.next(70) + ", ");
        sb.append(stockSpanner.next(60) + ", ");
        sb.append(stockSpanner.next(75) + ", ");
        sb.append(stockSpanner.next(85) + ", ");
        System.out.println(sb);
    }

    //https://leetcode.com/problems/online-stock-span/solutions/2795684/java-from-2002-ms-to-63-ms/
    //10 mins
    //Runtime
    //63 ms
    //Beats
    //74.85%
    //Memory
    //79.9 MB
    //Beats
    //5.3%
    static class StockSpanner {
        List<Integer> prices;
        List<Integer> spans;
        public StockSpanner() {
            prices = new ArrayList<>();
            spans = new ArrayList<>();
        }

        public int next(int price) {
            int span = 1;
            for (int i = prices.size() - 1; i >= 0; i--) {
                if (price >= prices.get(i)) {
                    span += spans.get(i);
                    i = i - spans.get(i) + 1;
                } else break;
            }
            prices.add(price);
            spans.add(span);
            return span;
        }
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

    static class StockSpanner1 {
        List<Integer> prices;
        List<Integer> span;
        public StockSpanner1() {
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
                return count;
            }
        }
    }
}
