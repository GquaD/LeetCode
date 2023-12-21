package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem1366 {
    //https://leetcode.com/problems/rank-teams-by-votes/
    public static void main(String[] args) {
        System.out.println("VWFHSJARNPEMOXLTUKICZGYQ".equals(rankTeams(new String[]{"FVSHJIEMNGYPTQOURLWCZKAX","AITFQORCEHPVJMXGKSLNZWUY","OTERVXFZUMHNIYSCQAWGPKJL","VMSERIJYLZNWCPQTOKFUHAXG","VNHOZWKQCEFYPSGLAMXJIUTR","ANPHQIJMXCWOSKTYGULFVERZ","RFYUXJEWCKQOMGATHZVILNSP","SCPYUMQJTVEXKRNLIOWGHAFZ","VIKTSJCEYQGLOMPZWAHFXURN","SVJICLXKHQZTFWNPYRGMEUAO","JRCTHYKIGSXPOZLUQAVNEWFM","NGMSWJITREHFZVQCUKXYAPOL","WUXJOQKGNSYLHEZAFIPMRCVT","PKYQIOLXFCRGHZNAMJVUTWES","FERSGNMJVZXWAYLIKCPUQHTO","HPLRIUQMTSGYJVAXWNOCZEKF","JUVWPTEGCOFYSKXNRMHQALIZ","MWPIAZCNSLEYRTHFKQXUOVGJ","EZXLUNFVCMORSIWKTYHJAQPG","HRQNLTKJFIEGMCSXAZPYOVUW","LOHXVYGWRIJMCPSQENUAKTZF","XKUTWPRGHOAQFLVYMJSNEIZC","WTCRQMVKPHOSLGAXZUEFYNJI"})));
        System.out.println("ACB".equals(rankTeams(new String[]{"ABC","ACB","ABC","ACB","ACB"})));
        System.out.println("XWYZ".equals(rankTeams(new String[]{"WXYZ","XYZW"})));
        System.out.println("ZMNAGUEDSJYLBOPHRQICWFXTVK".equals(rankTeams(new String[]{"ZMNAGUEDSJYLBOPHRQICWFXTVK"})));
    }

    //https://leetcode.com/problems/rank-teams-by-votes/solutions/4436630/java-priorityqueue-doubles-for-rank/
    //40-50min
    //Runtime
    //7 ms
    //Beats
    //67.47%
    //Memory
    //44 MB
    //Beats
    //22.2%
    static String rankTeams(String[] votes) {
        if (votes.length == 1) return votes[0];
        double[] alph = new double[26];
        int len = votes[0].length();
        for (String s : votes) {
            for (int i = 0; i < len; i++) {
                alph[s.charAt(i) - 'A'] += Math.pow(100, len - i);
            }
        }
        PriorityQueue<Couple> pq = new PriorityQueue<>((a, b) -> b.points - a.points > 0 ? 1 : b.points == a.points ? a.c - b.c : -1);
        for (int i = 0; i < 26; i++) {
            if (alph[i] > 0) pq.offer(new Couple((char) (i + 'A'), alph[i]));
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll().c);
        }
        return sb.toString();
    }

    static String rankTeams2(String[] votes) {
        if (votes.length == 1) return votes[0];
        //char -> array of places frequency
        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < votes[0].length(); i++) {
            map.put(votes[0].charAt(i), new int[votes[0].length()]);
        }

        for (String s : votes) {
            for (int i = 0; i < s.length(); i++) {
                map.get(s.charAt(i))[i]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        int len = votes[0].length();
        for (int i = 0; i < len; i++) {
            int max = 0;
            char cMax = 'A';
            for (char c : map.keySet()) {
                int[] arr = map.get(c);
                if (max < arr[i]) {
                    max = arr[i];
                    cMax = c;
                } else if (max == arr[i]) {
                    cMax = (char) Math.min(c, cMax);
                }
            }
            sb.append(cMax);
        }
        return sb.toString();
    }

    static String rankTeams1(String[] votes) {
        /*if (votes.length == 1) return votes[0];
        int[] alph = new int[26];
        for (String s : votes) {
            for (int i = 0; i < s.length(); i++) {
                alph[s.charAt(i) - 'A'] += i + 1;
            }
        }
        PriorityQueue<Couple> pq = new PriorityQueue<>((a, b) -> a.points == b.points ? a.c - b.c : a.points - b.points);
        for (int i = 0; i < 26; i++) {
            if (alph[i] > 0) pq.offer(new Couple((char) (i + 'A'), alph[i]));
        }*/
        StringBuilder sb = new StringBuilder();
        /*while (!pq.isEmpty()) {
            sb.append(pq.poll().c);
        }*/
        return sb.toString();
    }
}

class Couple {
    char c;
    double points;

    public Couple(char c, double points) {
        this.c = c;
        this.points = points;
    }
}
