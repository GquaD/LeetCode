package LeetCode.hard;

import java.util.*;

public class Problem381 {
    //20min
    //Runtime
    //42
    //ms
    //Beats
    //5.19%
    //Memory
    //99.02
    //MB
    //Beats
    //69.24%
    class RandomizedCollection {
        //num -> freq
        Map<Integer, Integer> map;
        List<Integer> list;
        Random random;

        public RandomizedCollection() {
            map = new HashMap<>();
            list = new ArrayList<>();
            random = new Random();
        }

        public boolean insert(int val) {
            int idx = Collections.binarySearch(list, val);
            if (idx < 0) idx = -idx - 1;
            list.add(idx, val);

            Integer freq = map.get(val);
            boolean result = freq == null;
            freq = result ? 1 : freq + 1;
            map.put(val, freq);

            return result;
        }

        public boolean remove(int val) {
            Integer freq = map.get(val);

            if (freq == null) {
                return false;
            } else if (freq == 1) {
                map.remove(val);
            } else {
                map.put(val, freq - 1);
            }

            int idx = Collections.binarySearch(list, val);
            if (idx < 0) idx = -idx - 1;
            list.remove(idx);

            return true;
        }

        public int getRandom() {
            int idx = random.nextInt(list.size());
            return list.get(idx);
        }
    }
}
