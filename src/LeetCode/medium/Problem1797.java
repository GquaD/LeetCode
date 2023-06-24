package LeetCode.medium;

import java.util.HashMap;

public class Problem1797 {
    //https://leetcode.com/problems/design-authentication-manager/
    public static void main(String[] args) {

    }
}

//https://leetcode.com/problems/design-authentication-manager/solutions/3677473/java-using-hashmap/
//5-10 min
//Runtime
//95 ms
//Beats
//17.93%
//Memory
//45 MB
//Beats
//42.39%
class AuthenticationManager1 {

    HashMap<String, Integer> map;
    int time;

    public AuthenticationManager1(int timeToLive) {
        map = new HashMap<>();
        time = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime + time);
    }

    public void renew(String tokenId, int currentTime) {
        int expires = map.getOrDefault(tokenId, 0);
        if (expires > currentTime) map.put(tokenId, currentTime + time);
    }

    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (String key : map.keySet()) if (map.get(key) > currentTime) count++;
        return count;
    }
}
