package LeetCode.medium;

import java.util.*;

public class Problem1267 {
    //30min
    //Runtime
    //9
    //ms
    //Beats
    //16.46%
    //Memory
    //53.80
    //MB
    //Beats
    //89.75%
    public int countServers(int[][] grid) {
        Map<Integer, Integer> mapr = new HashMap<>(), mapc = new HashMap<>();
        List<int[]> servers = new ArrayList<>();

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 1) {
                    Integer freqr = mapr.get(r), freqc = mapc.get(c);
                    if (freqr == null && freqc == null) {
                        mapr.put(r, 1);
                        mapc.put(c, 1);
                    } else if (freqr == null && freqc != null) {
                        mapr.put(r, 1);
                        mapc.put(c, freqc + 1);
                    } else if (freqr != null && freqc == null) {
                        mapr.put(r, freqr + 1);
                        mapc.put(c, 1);
                    } else {
                        mapr.put(r, freqr + 1);
                        mapc.put(c, freqc + 1);
                    }
                    servers.add(new int[]{r, c});
                }

            }
        }

        int count = 0;

        for (int[] server: servers) {
            int r = server[0], c = server[1], freqr = mapr.get(r), freqc = mapc.get(c);
            if (freqr > 1 || freqc > 1) count++;
        }

        return count;
    }
}
