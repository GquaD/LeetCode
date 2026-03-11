package LeetCode.easy;

public class Problem2446 {
    //5min

    //Runtime
    //1
    //ms
    //Beats
    //35.52%
    //Memory
    //42.95
    //MB
    //Beats
    //49.15%
    public boolean haveConflict(String[] event1, String[] event2) {
        int start1 = convertToInt(event1[0]), end1 = convertToInt(event1[1]), start2 = convertToInt(event2[0]), end2 = convertToInt(event2[1]);
        return start1 <= end2 && end1 >= start2 || start2 <= end1 && end2 >= start1;
    }

    private int convertToInt(String s) {
        String[] split = s.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}
