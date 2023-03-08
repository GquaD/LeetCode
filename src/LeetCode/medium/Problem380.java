package LeetCode.medium;

import java.util.*;

public class Problem380 {
    //https://leetcode.com/problems/insert-delete-getrandom-o1/
    public static void main(String[] args) {

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

class RandomizedSet {
    ArrayList<Integer> list;
    static Random random = new Random();
    public RandomizedSet() {
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
