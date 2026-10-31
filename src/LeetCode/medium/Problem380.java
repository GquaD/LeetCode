package LeetCode.medium;

import java.util.*;

public class Problem380 {
    //https://leetcode.com/problems/insert-delete-getrandom-o1/
    public static void main(String[] args) {

    }

}


//20min
//Runtime
//27
//ms
//Beats
//55.46%
//Memory
//100.32
//MB
//Beats
//55.69%

class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            if (map.size() == 1) {
                map.clear();
                list.clear();
            } else {
                int idx = map.get(val), lastIdx = list.size() - 1, lastVal = list.get(lastIdx);

                list.set(idx, lastVal);
                map.put(lastVal, idx);

                map.remove(val);
                list.remove(lastIdx);
            }

            return true;
        }

        return false;
    }

    public int getRandom() {
        int idx = random.nextInt(list.size()), val = list.get(idx);
        return val;
    }
}



//https://leetcode.com/problems/insert-delete-getrandom-o1/solutions/3270967/java-using-arraylist-30-ms/
//Runtime
//30 ms
//Beats
//53.48%
//Memory
//92.5 MB
//Beats
//37.81%
class RandomizedSet1 {
    ArrayList<Integer> list;
    static Random random = new Random();
    public RandomizedSet1() {
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        int res = Collections.binarySearch(list, val);
        if (res < 0) {
            list.add(-res - 1, val);
            return true;
        } else return false;
    }

    public boolean remove(int val) {
        int res = Collections.binarySearch(list, val);
        if (res < 0) {
            return false;
        } else {
            list.remove(res);
            return true;
        }
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

//Runtime
//288 ms
//Beats
//5.8%
//Memory
//93.1 MB
//Beats
//14.77%
/*class RandomizedSet {
    LinkedList<Integer> list;
    static Random random = new Random();
    public RandomizedSet() {
        list = new LinkedList<>();
    }

    public boolean insert(int val) {
        int res = Collections.binarySearch(list, val);
        if (res < 0) {
            list.add(-res - 1, val);
            return true;
        } else return false;
    }

    public boolean remove(int val) {
        int res = Collections.binarySearch(list, val);
        if (res < 0) {
            return false;
        } else {
            list.remove(res);
            return true;
        }
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}*/



//10-20 min
//Runtime
//172 ms
//Beats
//17.5%
//Memory
//89.8 MB
//Beats
//72.86%

/*class RandomizedSet {
    private Set<Integer> set;
    private static Random random = new Random();
    Object[] array;
    boolean arrayChanged;
    public RandomizedSet() {
        set = new HashSet<>();
        arrayChanged = false;
    }

    public boolean insert(int val) {
        boolean notExisted = set.add(val);
        if (notExisted) arrayChanged = true;
        return notExisted;
    }

    public boolean remove(int val) {
        boolean contained = set.remove(val);
        if (contained) arrayChanged = true;
        return contained;
    }

    public int getRandom() {
        if (arrayChanged) array = set.toArray();
        return (Integer) array[random.nextInt(array.length)];
    }
}*/
