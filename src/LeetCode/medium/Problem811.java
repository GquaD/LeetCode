package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem811 {
    //https://leetcode.com/problems/subdomain-visit-count/
    public static void main(String[] args) {
        LeetCodeUtils.printList(subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
        System.out.println();
        LeetCodeUtils.printList(subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));
    }

    //Runtime: 22 ms, faster than 82.21% of Java online submissions for Subdomain Visit Count.
    //Memory Usage: 50.7 MB, less than 71.47% of Java online submissions for Subdomain Visit Count.
    static List<String> subdomainVisits(String[] domains) {
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < domains.length; i++) {
            int index = domains[i].indexOf(' ');
            int num = Integer.parseInt(domains[i].substring(0, index));
            String address = domains[i].substring(index + 1);
            Pair pair = new Pair(address, num);
            int idx = pair.address.indexOf(".");
            String addressTemp = pair.address;
            while (idx > -1) {
                String sub = addressTemp.substring(idx + 1);
                Pair child = new Pair(sub, pair.num);
                pair.children.add(child);
                idx = sub.indexOf(".");
                addressTemp = sub;
            }
            list.add(pair);
        }


        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            Pair pair = list.get(i);
            if (map.containsKey(pair.address)) {
                map.put(pair.address, map.get(pair.address) + pair.num);
            } else {
                map.put(pair.address, pair.num);
            }

            for (int j = 0; j < pair.children.size(); j++) {
                Pair child = pair.children.get(j);
                if (map.containsKey(child.address)) {
                    map.put(child.address, map.get(child.address) + child.num);
                } else {
                    map.put(child.address, child.num);
                }
            }
        }
        List<String> result = new ArrayList<>();
        for (String key : map.keySet()) {
            int count = map.get(key);
            String s = count + " " + key;
            result.add(s);
        }
        return result;
    }

    //Runtime: 23 ms, faster than 80.74% of Java online submissions for Subdomain Visit Count.
    //Memory Usage: 51.3 MB, less than 61.79% of Java online submissions for Subdomain Visit Count.
    static List<String> subdomainVisits2(String[] domains) {
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < domains.length; i++) {
            int index = domains[i].indexOf(' ');
            int num = Integer.parseInt(domains[i].substring(0, index));
            String address = domains[i].substring(index + 1);
            Pair pair = new Pair(address, num);
            list.add(pair);
        }

        for (int i = 0; i < list.size(); i++) {
            Pair pair = list.get(i);
            int idx = pair.address.indexOf(".");
            String addressTemp = pair.address;
            while (idx > -1) {
                String sub = addressTemp.substring(idx + 1);
                Pair child = new Pair(sub, pair.num);
                pair.children.add(child);
                idx = sub.indexOf(".");
                addressTemp = sub;
            }
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            Pair pair = list.get(i);
            if (map.containsKey(pair.address)) {
                map.put(pair.address, map.get(pair.address) + pair.num);
            } else {
                map.put(pair.address, pair.num);
            }

            for (int j = 0; j < pair.children.size(); j++) {
                Pair child = pair.children.get(j);
                if (map.containsKey(child.address)) {
                    map.put(child.address, map.get(child.address) + child.num);
                } else {
                    map.put(child.address, child.num);
                }
            }
        }
        List<String> result = new ArrayList<>();
        for (String key : map.keySet()) {
            int count = map.get(key);
            String s = count + " " + key;
            result.add(s);
        }
        return result;
    }

    static List<String> subdomainVisits1(String[] domains) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < domains.length; i++) {
            String[] temp = domains[i].split(" ");
            if (map.containsKey(temp[1])) {
                map.put(temp[1], map.get(temp[1]) + Integer.parseInt(temp[0]));
            } else {
                map.put(temp[1], Integer.parseInt(temp[0]));
            }
        }
        Map<String, Integer> mapSubDomains = new HashMap<>();
        for (String key : map.keySet()) {
            int index = key.indexOf(".");
            while (index > -1) {
                index = key.indexOf(".");
                String sub = key.substring(index + 1);
                if (mapSubDomains.containsKey(sub)) {
                    mapSubDomains.put(sub, mapSubDomains.get(sub) + mapSubDomains.get(sub));
                } else {
                    mapSubDomains.put(sub, map.get(key) == null ? 0 : map.get(key));
                }
                key = sub;
            }
        }
        List<String> list = new ArrayList<>();
        for (String key : mapSubDomains.keySet()) {
            if (map.containsKey(key)) {
                int count = map.get(key) + mapSubDomains.get(key);
                String s = count + " " + key;
                list.add(s);
            }
        }
        return list;
    }

    static class Pair {
        String address;
        int num;
        List<Pair> children;

        public Pair(String addr, int n) {
            address = addr;
            num = n;
            children = new ArrayList<>();
        }
    }
}
