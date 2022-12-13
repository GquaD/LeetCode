package LeetCode.easy;

import java.util.ArrayList;
import java.util.List;

public class Problem706 {
    //https://leetcode.com/problems/design-hashmap/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/design-hashmap/solutions/2906398/java-built-hashmap-based-on-array/
    //Runtime
    //52 ms
    //Beats
    //49.88%
    //Memory
    //60.3 MB
    //Beats
    //76.58%
    static class MyHashMap {
        List<Pair>[] arr;
        public MyHashMap() {
            arr = new List[100];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = new ArrayList<>();
            }
        }

        public void put(int key, int value) {
            int idx = key % 100;
            List<Pair> list = arr[idx];
            boolean existingReplaced = false;
            for (int i = 0; i < list.size(); i++) {
                Pair cur = list.get(i);
                if (cur.getKey() == key) {
                    cur.setVal(value);
                    existingReplaced = true;
                    break;
                }
            }
            if (!existingReplaced) {
                list.add(new Pair(key, value));
            }
        }

        public int get(int key) {
            int idx = key % 100;
            List<Pair> list = arr[idx];
            for (int i = 0; i < list.size(); i++) {
                Pair cur = list.get(i);
                if (cur.getKey() == key) {
                    return cur.getVal();
                }
            }
            return -1;
        }

        public void remove(int key) {
            int idx = key % 100;
            List<Pair> list = arr[idx];
            for (int i = 0; i < list.size(); i++) {
                Pair cur = list.get(i);
                if (cur.getKey() == key) {
                    list.remove(i);
                    break;
                }
            }
        }
    }

    static class Pair {
        int key;
        int val;

        public Pair() {
        }

        public Pair(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }
}
