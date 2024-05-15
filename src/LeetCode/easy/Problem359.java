package LeetCode.easy;

import java.util.HashMap;
import java.util.Map;

public class Problem359 {
    //https://leetcode.com/problems/logger-rate-limiter/
    public static void main(String[] args) {

    }


}
//5min
//Runtime
//30
//ms
//Beats
//88.75%
//of users with Java
//Memory
//54.86
//MB
//Beats
//92.59%
//of users with Java
class Logger {
    Map<String, Integer> map;
    public Logger() {
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (map.containsKey(message)) {
            int t = map.get(message);
            if (timestamp >= t) {
                map.put(message, timestamp + 10);
                return true;
            } else {
                return false;
            }
        } else {
            map.put(message, timestamp + 10);
            return true;
        }
    }
}
