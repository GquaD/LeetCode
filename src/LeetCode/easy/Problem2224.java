package LeetCode.easy;

public class Problem2224 {
    //https://leetcode.com/problems/minimum-number-of-operations-to-convert-time/
    public static void main(String[] args) {
        System.out.println(convertTime("02:30", "04:35"));
        System.out.println(convertTime("11:00", "11:01"));
        System.out.println(convertTime("23:59", "00:00"));
    }

    //https://leetcode.com/problems/minimum-number-of-operations-to-convert-time/solutions/2791871/java-optimized-from-8-ms-to-1ms/
    //Runtime
    //1 ms
    //Beats
    //98.70%
    //Memory
    //42.4 MB
    //Beats
    //55.19%
    static int convertTime(String current, String correct) {
        int curHour = (current.charAt(0) - '0') * 10 + (current.charAt(1) - '0');
        int curMin = (current.charAt(3) - '0') * 10 + (current.charAt(4) - '0');
        int corHour = (correct.charAt(0) - '0') * 10 + (correct.charAt(1) - '0');
        int corMin = (correct.charAt(3) - '0') * 10 + (correct.charAt(4) - '0');
        int diff = (corHour * 60 + corMin) - (curHour * 60 + curMin);
        int sixty = diff / 60;
        diff -= sixty * 60;
        int fifteen = diff / 15;
        diff -= fifteen * 15;
        int five = diff / 5;
        diff -= five * 5;
        return sixty + fifteen + five + diff;
    }


    //
    //Runtime
    //2 ms
    //Beats
    //82.59%
    //Memory
    //41.5 MB
    //Beats
    //87.22%
    static int convertTime1(String current, String correct) {
        StringBuilder sb = new StringBuilder();
        int curHour = Integer.parseInt(sb.append(current.charAt(0)).append(current.charAt(1)).toString());
        sb.setLength(0);
        int curMin = Integer.parseInt(sb.append(current.charAt(3)).append(current.charAt(4)).toString());
        sb.setLength(0);
        int corHour = Integer.parseInt(sb.append(correct.charAt(0)).append(correct.charAt(1)).toString());
        sb.setLength(0);
        int corMin = Integer.parseInt(sb.append(correct.charAt(3)).append(correct.charAt(4)).toString());
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
