package LeetCode.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Problem284 {
    //https://leetcode.com/problems/peeking-iterator/description/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/peeking-iterator/solutions/3254102/java-100-faster-using-arraylist/
    //Runtime
    //4 ms
    //Beats
    //100%
    //Memory
    //42.3 MB
    //Beats
    //43.76%
    //15 min

    static class PeekingIterator implements Iterator<Integer> {
        List<Integer> list;
        int idx;
        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            idx = 0;
            list = new ArrayList<>();
            while (iterator.hasNext()) {
                list.add(iterator.next());
            }
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return list.get(idx);
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            return list.get(idx++);
        }

        @Override
        public boolean hasNext() {
            return idx < list.size();
        }
    }

    //Runtime
    //5 ms
    //Beats
    //16.60%
    //Memory
    //42.4 MB
    //Beats
    //23.81%

    /*static class PeekingIterator implements Iterator<Integer> {
        Queue<Integer> queue;
        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            queue = new LinkedList<>();
            while (iterator.hasNext()) {
                queue.offer(iterator.next());
            }
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return queue.peek();
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            return queue.poll();
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }*/
}
