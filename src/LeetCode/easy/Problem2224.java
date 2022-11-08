package LeetCode.easy;

public class Problem2224 {
    //https://leetcode.com/problems/minimum-number-of-operations-to-convert-time/
    public static void main(String[] args) {
        System.out.println(convertTime("02:30", "04:35"));
        System.out.println(convertTime("11:00", "11:01"));
        System.out.println(convertTime("23:59", "00:00"));
    }

    //10-15 mins
    //Runtime
    //8 ms
    //Beats
    //11.11%
    //Memory
    //42.2 MB
    //Beats
    //68.89%
    static int convertTime(String current, String correct) {
        int curHour = Integer.parseInt(current.charAt(0) + "" + current.charAt(1));
        int curMin = Integer.parseInt(current.charAt(3) + "" + current.charAt(4));
        int corHour = Integer.parseInt(correct.charAt(0) + "" + correct.charAt(1));
        int corMin = Integer.parseInt(correct.charAt(3) + "" + correct.charAt(4));
        int timeCur = curHour * 60 + curMin, timeCor = corHour * 60 + corMin;
        int count = 0;
        if (timeCur < timeCor) {
            while (timeCur != timeCor) {
                if (timeCur + 60 <= timeCor) {
                    timeCur += 60;
                } else if (timeCur + 15 <= timeCor) {
                    timeCur += 15;
                } else if (timeCur + 5 <= timeCor) {
                    timeCur += 5;
                } else timeCur++;
                count++;
            }
        } else if (timeCur > timeCor) {
            while (timeCur != timeCor) {
                if (timeCur - 60 >= timeCor) {
                    timeCur -= 60;
                } else if (timeCur - 15 >= timeCor) {
                    timeCur -= 15;
                } else if (timeCur - 5 >= timeCor) {
                    timeCur -= 5;
                } else timeCur--;
                count++;
            }
        }
        return count;
    }
}
