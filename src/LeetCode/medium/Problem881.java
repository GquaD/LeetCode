package LeetCode.medium;

import java.util.*;

public class Problem881 {
    //https://leetcode.com/problems/boats-to-save-people/description/
    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{3,2,2,1}, 3));
        System.out.println(numRescueBoats(new int[]{3,5,3,4}, 5));
    }

    //nnnn
    //Runtime
    //17 ms
    //Beats
    //98.31%
    //Memory
    //51.1 MB
    //Beats
    //22.49%
    static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int a = 0, b = people.length - 1;
        while (a <= b) if (people[a] + people[b--] <= limit) a++;
        return people.length - b - 1;
    }

    static int numRescueBoats2(int[] people, int limit) {
        Map<Integer, Integer> mapFreq = new TreeMap<>(Comparator.reverseOrder());
        for (int p : people) {
            if (mapFreq.containsKey(p)) mapFreq.put(p, mapFreq.get(p) + 1);
            else mapFreq.put(p, 1);
        }
        int count = 0;
        for (int p : mapFreq.keySet()) {
            int freq = mapFreq.get(p);
            if (p == limit) {
                count += freq;
                mapFreq.remove(p);
            } else {
                int diff = limit - p;
                if (mapFreq.containsKey(diff)) {
                    int freq2 = mapFreq.get(diff);
                    count += Math.min(freq, freq2);
                    if (freq2 < freq) {
                        mapFreq.remove(diff);
                        mapFreq.put(p, freq - freq2);
                    } else if (freq2 == freq) {
                        mapFreq.remove(diff);
                        mapFreq.remove(p);
                    } else {
                        mapFreq.remove(p);
                        mapFreq.put(diff, freq2 - freq);
                    }
                } else {

                }
            }
        }
        return count;
    }

    static int numRescueBoats1(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0, runSum = 0;
        for (int i = 0; i < people.length; i++) {
            if (runSum + people[i] > limit) {
                count++;
                runSum = people[i];
            } else if (runSum + people[i] == limit){
                count++;
                runSum = 0;
            } else {
                runSum += people[i];
            }
        }
        if (runSum > 0) count++;
        return count;
    }
}
