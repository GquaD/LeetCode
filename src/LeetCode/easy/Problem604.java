package LeetCode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class Problem604 {
    //https://leetcode.com/problems/design-compressed-string-iterator/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/design-compressed-string-iterator/solutions/6373512/java-on-solution-by-tbekpro-futc/
    //5min
    //Runtime
    //13
    //ms
    //Beats
    //49.67%
    //Analyze Complexity
    //Memory
    //44.84
    //MB
    //Beats
    //61.44%
    class StringIterator {
        Queue<Pair> queue;
        public StringIterator(String s) {
            queue = new LinkedList<>();
            int num = 0;
            char mem = s.charAt(0);
            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    num = num * 10 + (c - '0');
                } else {
                    queue.offer(new Pair(mem, num));
                    num = 0;
                    mem = c;
                }
            }
            if (num > 0) {
                queue.offer(new Pair(mem, num));
            }
        }

        public char next() {
            Pair p = queue.peek();
            if (p == null) return ' ';
            if (p.number == 1) {
                queue.poll();
            } else {
                p.number--;
            }
            return p.letter;
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }

        class Pair {
            char letter;
            int number;
            public Pair(char c, int n) {
                letter = c;
                number = n;
            }
        }
    }

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}
