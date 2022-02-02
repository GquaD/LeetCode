package WithGoogle;

public class Task4 {
    //bricks, variations of staircases
    public static void main(String[] args) {
        int countRepl = 0;
        int thousand = 1000;
        //counts replicas
        for (int i = 0; i < thousand; i++) {
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
        System.out.println(countRepl);
    }


/*    static int solution(int n) {

    }*/
}
