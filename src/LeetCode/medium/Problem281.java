package LeetCode.medium;

import java.util.List;

public class Problem281 {
    //https://leetcode.com/problems/zigzag-iterator
    public static void main(String[] args) {

    }


}

//https://leetcode.com/problems/zigzag-iterator/solutions/5165081/java-100-faster-solution-for-2-vectors/
//10min
//Runtime
//1
//ms
//Beats
//100.00%
//of users with Java
//Memory
//44.46
//MB
//Beats
//81.41%
//of users with Java

class ZigzagIterator {

    int idx1, idx2;
    boolean isFirst;
    List<Integer> v1, v2;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        idx1 = 0;
        idx2 = 0;
        isFirst = true;
        this.v1 = v1;
        this.v2 = v2;
    }

    public int next() {
        if (isFirst) {
            isFirst = false;
            if (idx1 < v1.size()) {
                return v1.get(idx1++);
            } else if (idx2 < v2.size()){
                return v2.get(idx2++);
            }
        } else {
            isFirst = true;
            if (idx2 < v2.size()) {
                return v2.get(idx2++);
            } else if (idx1 < v1.size()) {
                return v1.get(idx1++);
            }
        }
        return -1;
    }

    public boolean hasNext() {
        return idx1 < v1.size() || idx2 < v2. size();
    }
}
