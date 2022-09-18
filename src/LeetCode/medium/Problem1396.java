package LeetCode.medium;

import java.util.*;

public class Problem1396 {
    //https://leetcode.com/problems/design-underground-system/
    public static void main(String[] args) {

    }

    //Runtime: 259 ms, faster than 11.80% of Java online submissions for Design Underground System.
    //Memory Usage: 98.6 MB, less than 81.46% of Java online submissions for Design Underground System.
    class UndergroundSystem {
        Map<Integer,Integer> idTime; // id, in time
        Map<Integer,String> idStation;
        Map<String,Integer> time,len;// (from-to, timetaken) (from-to,occurence)
        public UndergroundSystem() {
            idTime =new HashMap<>();
            idStation =new HashMap<>();
            time = new HashMap<>();
            len = new HashMap<>();
        }

        public void checkIn(int id, String name, int t) {
            idStation.put(id,name);
            idTime.put(id,t);
        }

        public void checkOut(int id, String name, int t) {
            String from = idStation.get(id),to= name,path = from+"-"+to;
            int start = idTime.get(id);
            time.put(path,time.getOrDefault(path,0)+t-start);
            len.put(path,len.getOrDefault(path,0)+1);
        }

        public double getAverageTime(String from, String to) {
            String path = from+"-"+to;
            double dist = time.get(path);
            return dist/len.get(path);
        }
    }


    static class UndergroundSystem1 {
        Map<String, List<Pair>> mapIn;
        Map<String, List<Pair>> mapOut;

        public UndergroundSystem1() {
            mapIn = new HashMap<>();
            mapOut = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            Pair pair = new Pair(id, t);
            if (mapIn.containsKey(stationName)) {
                mapIn.get(stationName).add(pair);
            } else {
                List<Pair> list = new ArrayList<>();
                list.add(pair);
                mapIn.put(stationName, list);
            }
        }

        public void checkOut(int id, String stationName, int t) {
            Pair pair = new Pair(id, t);
            if (mapOut.containsKey(stationName)) {
                mapOut.get(stationName).add(pair);
            } else {
                List<Pair> list = new ArrayList<>();
                list.add(pair);
                mapOut.put(stationName, list);
            }
        }

        public double getAverageTime(String startStation, String endStation) {
            List<Pair> start = new ArrayList<>(mapIn.get(startStation));
            List<Pair> end = new ArrayList<>(mapOut.get(endStation));
            int sum = 0, count = 0;

            int size = end.size();
            for (int i = 0; i < size; i++) {
                Pair pairEnd = end.get(0);
                for (int j = 0; j < start.size(); j++) {
                    Pair pairStart = start.get(j);
                    if (pairStart.id == pairEnd.id && pairEnd.time >= pairStart.time) {
                        sum += pairEnd.time - pairStart.time;
                        start.remove(j);
                        count++;
                        break;
                    }
                }
                if (start.size() == 0) break;
                end.remove(0);
            }

            return (sum * 1.0) / count;
        }
/*
        public double getAverageTime(String startStation, String endStation) {
            List<Pair> start = new ArrayList<>(mapIn.get(startStation));
            List<Pair> end = new ArrayList<>(mapOut.get(endStation));
            int sum = 0, count = 0;
            if (end.size() > start.size()) {
                int size = start.size();
                for (int i = 0; i < size; i++) {
                    Pair pairStart = start.get(0);
                    for (int j = 0; j < end.size(); j++) {
                        Pair pairEnd = end.get(j);
                        if (pairEnd.id == pairStart.id && pairEnd.time >= pairStart.time) {
                            sum+= pairEnd.time - pairStart.time;
                            end.remove(j);
                            count++;
                            break;
                        }
                    }
                    start.remove(0);
                }
            } else {
                int size = end.size();
                for (int i = 0; i < size; i++) {
                    Pair pairEnd = end.get(0);
                    for (int j = 0; j < start.size(); j++) {
                        Pair pairStart = start.get(j);
                        if (pairStart.id == pairEnd.id && pairEnd.time >= pairStart.time) {
                            sum += pairEnd.time - pairStart.time;
                            start.remove(j);
                            count++;
                            break;
                        }
                    }
                    end.remove(0);
                }
            }
            return (sum * 1.0) / count;
        }*/
    }

    static class Pair {
        int id;
        int time;

        public Pair(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }
}
