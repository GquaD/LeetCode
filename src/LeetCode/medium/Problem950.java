package LeetCode.medium;

import java.util.*;

public class Problem950 {
    //https://leetcode.com/problems/reveal-cards-in-increasing-order/
    public static void main(String[] args) {
        System.out.println(Arrays.toString(deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7})));
        System.out.println(Arrays.toString(deckRevealedIncreasing(new int[]{1, 1000})));
    }

    //todo make more effective solution
    //Runtime: 36 ms, faster than 5.49% of Java online submissions for Reveal Cards In Increasing Order.
    //Memory Usage: 44.6 MB, less than 30.17% of Java online submissions for Reveal Cards In Increasing Order.
    static int[] deckRevealedIncreasing(int[] deck) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < deck.length; i++) {
            list.add(deck[i]);
        }
        Collections.sort(list, (o1, o2) -> o2 - o1);
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            if (queue.size() > 1) {
                Integer last = queue.getLast();
                queue.remove(last);
                queue.push(last);
            }
            queue.push(list.get(i));
        }
        for (int i = 0; i < deck.length; i++) {
            deck[i] = queue.pop();
        }
        return deck;
    }
}
