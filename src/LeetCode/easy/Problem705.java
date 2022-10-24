package LeetCode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem705 {
    //https://leetcode.com/problems/design-hashset/

    public static void main(String[] args) {

    }


    //Runtime
    //54 ms
    //Beats
    //35.8%
    //Memory
    //56.6 MB
    //Beats
    //61.26%
    static class MyHashSet {
        List<Integer> list;
        public MyHashSet() {
            list = new ArrayList<>();
        }

        public void add(int key) {
            int i = Collections.binarySearch(list, key);
            if (i < 0) {
                list.add(-i - 1, key);
            }
        }

        public void remove(int key) {
            int i = Collections.binarySearch(list, key);
            if (i >= 0) list.remove(i);
        }

        public boolean contains(int key) {
            int k = Collections.binarySearch(list, key);
            if (k < 0) {
                return false;
            } else {
                return true;
            }
        }
    }
}
