package LeetCode.hard;

import java.util.*;

public class Problem895 {
    //https://leetcode.com/problems/maximum-frequency-stack/

    public static void main(String[] args) {
        FreqStack s = new FreqStack();
        s.push(1);
        s.push(0);
        s.push(0);
        s.push(1);
        s.push(5);
        s.push(4);
        s.push(1);
        s.push(5);
        s.push(1);
        s.push(6);
        for (int i = 0; i < 10; i++) {
            System.out.println(s.pop());
        }
    }

    //https://leetcode.com/problems/maximum-frequency-stack/solutions/2925144/java-99-91-time-99-82-memory-o-n-solution/
    //Runtime
    //27 ms
    //Beats
    //99.91%
    //Memory
    //50.3 MB
    //Beats
    //99.82%
    //2 - 3 hours to solve
    static class FreqStack {

        List<List<Integer>> list;
        Map<Integer, Integer> map;
        public FreqStack() {
            list = new ArrayList<>();
            List<Integer> stack = new ArrayList<>();
            list.add(stack);
            map = new HashMap<>();
        }

        public void push(int val) {
            Integer idx = map.get(val);
            if (idx == null) {
                idx = -1;
            }
            if (idx + 1 >= list.size()) {
                List<Integer> stackNewLast = new ArrayList<>();
                stackNewLast.add(val);
                list.add(stackNewLast);
                idx = list.size() - 1;
            } else {
                list.get(idx + 1).add(val);
                idx++;
            }
            map.put(val, idx);
        }

        public int pop() {
            int idx = list.size() - 1;
            List<Integer> listTarget = list.get(idx);
            if (listTarget.isEmpty()) return 0;
            int res = listTarget.get(listTarget.size() - 1);
            listTarget.remove(listTarget.size() - 1);
            if (listTarget.isEmpty()) {
                list.remove(idx);
            }
            map.put(res, idx - 1);
            return res;
        }
    }


    static class FreqStack4 {
        List<Stack<Integer>> list;
        public FreqStack4() {
            list = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            list.add(stack);
        }

        public void push(int val) {
            boolean inserted = false;
            for (int i = 0; i < list.size(); i++) {
                Stack<Integer> tempStack = list.get(i);
                if (!tempStack.contains(val)) {
                    tempStack.push(val);
                    inserted = true;
                    break;
                }
            }
            if (!inserted) {
                Stack<Integer> stackNewLast = new Stack<>();
                stackNewLast.push(val);
                list.add(stackNewLast);
            }
        }

        public int pop() {
            int idx = list.size() - 1;
            Stack<Integer> stack = list.get(idx);
            while (stack.isEmpty()) {
                if (idx == 0) {
                    stack = list.get(0);
                    break;
                }
                stack = list.get(--idx);
            }
            if (stack.isEmpty()) return 0;
            int res = stack.pop();
            if (stack.isEmpty()) {
                list.remove(list.size() - 1);
            }
            return res;
        }
    }

    //works
    //but time limit exceeds on 36/38
    static class FreqStack3 {
        List<List<Integer>> list;
        Map<Integer, Integer> map;
        public FreqStack3() {
            list = new ArrayList<>();
            List<Integer> stack = new ArrayList<>();
            list.add(stack);
            //map = new HashMap<>();
        }

        public void push(int val) {
            boolean inserted = false;
            for (int i = 0; i < list.size(); i++) {
                List<Integer> tempStack = list.get(i);
                if (!tempStack.contains(val)) {
                    tempStack.add(val);
                    inserted = true;
                    break;
                }
            }
            if (!inserted) {
                List<Integer> stackNewLast = new ArrayList<>();
                stackNewLast.add(val);
                list.add(stackNewLast);
            }
        }

        public int pop() {
            int idx = list.size() - 1;
            List<Integer> listTarget = list.get(idx);
            while (listTarget.isEmpty()) {
                if (idx == 0) {
                    listTarget = list.get(0);
                    break;
                }
                listTarget = list.get(--idx);
            }
            if (listTarget.isEmpty()) return 0;
            int res = listTarget.get(listTarget.size() - 1);
            listTarget.remove(listTarget.size() - 1);
            if (listTarget.isEmpty()) {
                list.remove(listTarget);
            }
            return res;
        }
    }

    //again correct
    //but time limit exceeded on 30 / 38
    static class FreqStack2 {
        Map<Integer, Integer> map;
        Map<Integer, List<Integer>> mapFreq;
        List<Integer> list;
        public FreqStack2() {
            map = new HashMap<>();
            mapFreq = new TreeMap<>(Comparator.reverseOrder());
            list = new ArrayList<>();
        }

        public void push(int key) {
            int prevFreq = 0;
            if (map.containsKey(key)) {
                prevFreq = map.get(key);
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
            if (prevFreq > 0 && mapFreq.get(prevFreq) != null) {
                List<Integer> listFreq = mapFreq.get(prevFreq);
                for (int i = 0; i < listFreq.size(); i++) {
                    if (listFreq.get(i) == key) {
                        listFreq.remove(i);
                        break;
                    }
                }
            }
            List<Integer> listCurrFreq;
            if (!mapFreq.containsKey(prevFreq + 1)) {
                listCurrFreq = new ArrayList<>();
                mapFreq.put(prevFreq + 1, listCurrFreq);
            } else {
                listCurrFreq = mapFreq.get(prevFreq + 1);
            }
            listCurrFreq.add(key);

            list.add(key);
        }

        public int pop() {
            List<Integer> listFreq = null;
            int freq = 0;
            for (int key : mapFreq.keySet()) {
                listFreq = mapFreq.get(key);
                if (!listFreq.isEmpty()) {
                    freq = key;
                    break;
                }
            }


            for (int i = list.size() - 1; i >= 0 ; i--) {
                Integer last = list.get(i);
                if (listFreq.contains(last)) {
                    listFreq.remove(last);
                    map.put(last, freq - 1);
                    if (mapFreq.get(freq - 1) != null) {
                        mapFreq.get(freq - 1).add(last);
                    } else {
                        List<Integer> freqList = new ArrayList<>();
                        freqList.add(last);
                        mapFreq.put(freq - 1, freqList);
                    }
                    list.remove(i);
                    return last;
                }
            }
            return 0;
        }
    }

    //time limit exceeded on 30/38
    //but correct
    static class FreqStack1 {
        Map<Integer, Integer> map;
        List<Integer> list;
        public FreqStack1() {
            map = new LinkedHashMap<>();
            list = new ArrayList<>();
        }

        public void push(int key) {
            list.add(key);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        public int pop() {
            int max = 0, k = -1;
            for (Integer key : map.keySet()) {
                int freq = map.get(key);
                if (max < freq) {
                    max = freq;
                    k = key;
                }
            }

            List<Integer> maxFreqKeys = new ArrayList<>();
            for (Integer key : map.keySet()) {
                int freq = map.get(key);
                if (freq == max) {
                    maxFreqKeys.add(key);
                }
            }
            int result = 0;
            outerloop:
            for (int i = list.size() - 1; i >= 0; i--) {
                for (int key : maxFreqKeys) {
                    int cur = list.get(i);
                    if (key == cur) {
                        result = cur;
                        list.remove(i);
                        map.put(cur, map.get(cur) - 1);
                        break outerloop;
                    }
                }
            }
            return result;
        }
    }
}
