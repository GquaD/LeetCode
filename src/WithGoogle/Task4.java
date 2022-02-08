package WithGoogle;

public class Task4 {
    //bricks, variations of staircases
    public static void main(String[] args) {
        int countRepl = 0;
        int thousand = 10000;
        //counts replicas
/*        for (int i = 0; i < thousand; i++) {
            for (int j = 0; j < 10; j++) {
                String num = i + "";
                int countTemp = 0;
                for (int k = 0; k < num.length(); k++) {
                    if (Integer.parseInt(num.charAt(k) + "") == j) {
                        countTemp++;
                    }
                }
                if (countTemp > 1) {
                    countRepl++;
                }
            }
        }
        System.out.println(countRepl);*/
/*        for (int n = 3; n <= 200; n++) {
            System.out.println("Distinct partitions number for n = " + n + " is equal to " + solution(n));
        }*/
        int n = 10;
        System.out.println("Distinct partitions number for n = " + n + " is equal to " + solution(n));
    }

    static int solution(int n) {
        //partitions, number theory
        int[][] variations = new int[n + 1][n];

        //filling up for first three
        for (int i = 0; i < 3; i++) {
            for (int j = i; j < n; j++) {
                variations[i][j] = 1;
            }
        }
        //incremental approach
        for (int num = 3; num <= n; num++) {
            for (int bot = 2; bot < n; bot++) {
                variations[num][bot] = variations[num][bot - 1];
                if (bot <= num) {
                    variations[num][bot] += variations[num - bot][bot - 1];
                }
            }
        }

        return variations[n][n - 1];
    }


/*    static int solution(int n) {

    }*/
}
