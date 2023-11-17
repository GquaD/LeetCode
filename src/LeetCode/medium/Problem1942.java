package LeetCode.medium;

import java.util.*;

public class Problem1942 {
    //https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/
    public static void main(String[] args) {
        System.out.println(smallestChair(new int[][]{{34167,60534},{60630,89180},{48573,81877},{53509,69027},{13079,25333},{89711,89767},{28805,43922},{25977,56144},{528,31398},{6748,93874},{64733,88382},{50274,52941},{95502,97229},{90688,93595},{81261,94153},{18850,59994},{42413,61445},{89930,96929},{95600,95849},{5329,50505},{83034,87122},{30427,51573},{90387,95139},{51980,88563},{82562,98036},{30694,58600},{45957,67135},{97064,97771},{66660,68834},{94640,99286},{21524,37219},{76795,89900},{79811,83819},{19451,47010},{26800,88830},{77436,93023},{93453,98564},{46654,62042},{77262,79360},{63260,95404},{53684,91281},{84135,98459},{93992,95157},{15506,71795},{22123,73407},{20552,92274},{66423,90807},{28674,32334},{99001,99523},{83280,97419},{45624,54798},{59214,94025},{68067,79088},{20872,54573},{21190,65833},{19161,96879},{37805,58798},{63181,74945},{74222,89454},{13446,14963},{6921,77989},{98553,99299},{84779,90074},{74189,98054},{54868,56501},{74690,88690},{73104,96025},{16937,34354},{6448,27829},{18378,54243},{75265,85678},{30159,34783},{1753,22910},{1689,8139},{58154,93484},{5076,31157},{70092,75270},{55284,68181},{2045,15795},{48898,72243},{50357,97998},{57324,95680},{35117,77065},{88270,97089},{90605,92758},{81811,98671},{58696,62748}}, 52));
        System.out.println(smallestChair(new int[][]{{82057,89365},{32519,49655},{7573,20592},{8336,11514},{638,70162},{39511,44262},{70399,79785},{8702,63564},{66644,68330},{75156,90448},{11884,87096},{99068,99875},{32555,54053},{5910,77572},{87649,94390},{40084,56483},{7911,28699},{93308,96154},{25562,39605},{73966,93173},{63450,88007},{58811,80045},{56160,71952},{14333,79867},{40342,76876},{69943,82175}}, 5));
        System.out.println(smallestChair(new int[][]{{33889,98676},{80071,89737},{44118,52565},{52992,84310},{78492,88209},{21695,67063},{84622,95452},{98048,98856},{98411,99433},{55333,56548},{65375,88566},{55011,62821},{48548,48656},{87396,94825},{55273,81868},{75629,91467}}, 6));
        System.out.println(smallestChair(new int[][]{{1,4}, {2,3}, {4,6}}, 1));
        System.out.println(smallestChair(new int[][]{{3,10}, {1,5}, {2,6}}, 0));
    }

    //nnn
    //2hour
    //Runtime
    //43 ms
    //Beats
    //74.19%
    //Memory
    //47.5 MB
    //Beats
    //74.19%
    static int smallestChair(int[][] times, int targetFriend) {
        int arrivalFriend = times[targetFriend][0];
        Arrays.sort(times, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pqToFree = new PriorityQueue<>();
        for (int i = 0; i < times.length; i++) pqToFree.offer(i);

        PriorityQueue<int[]> pqOccupied = new PriorityQueue<>((a, b) -> a[0]- b[0]);

        for (int i = 0; i < times.length; i++) {
            int arrival = times[i][0], leaving = times[i][1];

            while (!pqOccupied.isEmpty() && pqOccupied.peek()[0] <= arrival) {
                int[] arr = pqOccupied.poll();
                pqToFree.offer(arr[1]);
            }

            if (arrival == arrivalFriend) break;
            pqOccupied.offer(new int[]{leaving, pqToFree.poll()});
        }
        return pqToFree.peek();
    }

    //Wrong Answer
    //58 / 65 testcases passed
    static int smallestChair1(int[][] times, int targetFriend) {
        int[][] arr = new int[times.length][3];
        for (int i = 0; i < times.length; i++) arr[i] = new int[]{i, times[i][0], times[i][1]};
        //order num, arrival, leaving
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        //seat -> order num,
        Map<Integer, int[]> mapOccupied = new HashMap<>();
        //time -> seat
        TreeMap<Integer, Integer> mapToFree = new TreeMap<>();
        PriorityQueue<Integer> pqFree = new PriorityQueue<>();
        int countReleased = 0;
        for (int i = 0; i < arr.length; i++) {

            while (!mapToFree.isEmpty() && mapToFree.firstKey() <= arr[i][1]) {
                int seat = mapToFree.pollFirstEntry().getValue();
                pqFree.add(seat);
                System.out.println(Arrays.toString(mapOccupied.get(seat)) + " - released + " + ++countReleased);
                mapOccupied.remove(seat);
            }

            if (arr[i][0] == targetFriend) {
                if (pqFree.size() > 0) return pqFree.poll();
                else return mapOccupied.size();
            } else {
                if (pqFree.size() > 0) {
                    int seat = pqFree.poll();
                    mapOccupied.put(seat, arr[i]);
                    mapToFree.put(arr[i][2], seat);
                } else {
                    mapToFree.put(arr[i][2], Math.min(mapOccupied.size(), i));
                    mapOccupied.put(Math.min(mapOccupied.size(), i), arr[i]);
                }
            }
        }
        return -1;
    }
}
