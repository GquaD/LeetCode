package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem1146 {
    //https://leetcode.com/problems/snapshot-array/
    public static void main(String[] args) {

    }
}

//https://leetcode.com/problems/snapshot-array/solutions/3625964/java-100-faster-array-of-hashmaps/
//25-30min
//Runtime
//48 ms
//Beats
//99.86%
//Memory
//77.7 MB
//Beats
//57.28%
class SnapshotArray {
    int snapId;

    HashMap<Integer, Integer>[] arr;

    public SnapshotArray(int length) {
        snapId = 0;
        arr = new HashMap[length];
    }

    public void set(int index, int val) {
        if (arr[index] == null) arr[index] = new HashMap<>();
        arr[index].put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        if (arr[index] == null) return 0;
        Map<Integer, Integer> map = arr[index];
        if (map.containsKey(snap_id)) return map.get(snap_id);
        int minDiff = snapId, idSearch = snap_id;
        for (int sid : map.keySet()) {
            int diff = snap_id - sid;
            if (diff >= 0 && diff < minDiff) {
                minDiff = diff;
                idSearch = sid;
            }
        }
        return idSearch == snap_id ? 0 : map.get(idSearch);
    }
}
