package LeetCode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1656 {
    //don't solve cuz bad description
    public static void main(String[] args) {

    }

    //here is solution
    class OrderedStream {
        int ptr;
        String[] res;

        public OrderedStream(int n) {
            ptr = 0;
            res = new String[n];
        }

        public List<String> insert(int id, String value) {
            List<String> list = new ArrayList<>();

            res[id - 1] = value;
            while (ptr < res.length && res[ptr] != null) {
                list.add(res[ptr]);
                ptr++;
            }

            return list;
        }
    }

}
