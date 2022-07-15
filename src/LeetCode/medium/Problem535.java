package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem535 {
    //https://leetcode.com/problems/encode-and-decode-tinyurl/



    //Runtime: 3 ms, faster than 81.51% of Java online submissions for Encode and Decode TinyURL.
    //Memory Usage: 43.8 MB, less than 30.82% of Java online submissions for Encode and Decode TinyURL.
    static class Codec {
        static Map<String, String> cache;
        static int count;
        public Codec() {
            cache = new HashMap<>();
            count = 0;
        }
        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            String encoded = count + "";
            cache.put(encoded, longUrl);
            count++;
            return encoded;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return cache.get(shortUrl);
        }
    }
}
