package LeetCode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem1626 {
    //https://leetcode.com/problems/best-team-with-no-conflicts/description/
    public static void main(String[] args) {
        System.out.println(bestTeamScore(new int[]{4,5,6,5}, new int[]{2,1,2,1}));
        System.out.println(bestTeamScore(new int[]{1,3,5,10,15}, new int[]{1,2,3,4,5}));
        System.out.println(bestTeamScore(new int[]{1,2,3,5}, new int[]{8,9,10,1}));
    }

    //nnnn
    //Runtime
    //46 ms
    //Beats
    //72.79%
    //Memory
    //42.6 MB
    //Beats
    //64.63%
    static int bestTeamScore(int[] scores, int[] ages) {
        int[][] players = new int[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            players[i][0] = ages[i];
            players[i][1] = scores[i];
        }
        Arrays.sort(players, (x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);
        int[] sums = new int[ages.length];
        sums[0] = players[0][1];
        int max = sums[0];
        for (int i = 1; i < ages.length; i++) {
            sums[i] = players[i][1];
            for (int j = 0; j < i; j++) {
                if (players[j][1] <= players[i][1]) {
                    sums[i] = Math.max(sums[i], players[i][1] + sums[j]);
                }
            }
            max = Math.max(sums[i], max);
        }
        return max;
    }

    /*static int bestTeamScore(int[] scores, int[] ages) {
        Pair maxAge = new Pair(0, 0);
        for (int i = 0; i < ages.length; i++) {
            if (ages[i] >= maxAge.getAge() && scores[i] > maxAge.getScore()) {
                maxAge.setAge(ages[i]);
                maxAge.setScore(scores[i]);
            }
        }

    }*/

    static int bestTeamScore1(int[] scores, int[] ages) {
        Pair[] arr = new Pair[ages.length];
        Pair maxAge = new Pair(0, 0);
        for (int i = 0; i < ages.length; i++) {
            Pair temp = new Pair(ages[i], scores[i]);
            arr[i] = temp;
            if (temp.getAge() >= maxAge.getAge() && temp.getScore() > maxAge.getScore()) {
                maxAge = temp;
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(Pair::getAge).thenComparing(Pair::getScore));
        Arrays.sort(arr, Comparator.comparing(Pair::getAge).reversed());
        pq.offer(maxAge);
        for (Pair p : arr) {
            Pair peek = pq.peek();
            /*if (peek.getAge() > p.getAge() && peek.getScore() < p.getScore()) {
                continue;
            } else {
                pq.offer(p);
            }*/

            if (peek.getAge() > p.getAge() && peek.getScore() > p.getScore()
                    || peek.getAge() == p.getAge()) {
                pq.offer(p);
            } else {
                pq.poll();
                pq.offer(p);
            }
        }

        int sum = 0;
        for (Pair p : pq) sum += p.getScore();
        sum -= maxAge.getScore();
        return sum;
    }


    static class Pair {
        int age, score;

        public Pair(int age, int score) {
            this.age = age;
            this.score = score;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }
}
