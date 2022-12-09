package LeetCode.easy;

public class Problem1507 {
    //https://leetcode.com/problems/reformat-date/
    public static void main(String[] args) {
        System.out.println(reformatDate("20th Oct 2052"));
    }

    //https://leetcode.com/problems/reformat-date/solutions/2893335/java-2-ms-solution/
    //Runtime
    //2 ms
    //Beats
    //94.96%
    //Memory
    //42.3 MB
    //Beats
    //53.78%
    static String[] months = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    static String reformatDate(String date) {
        String[] split = date.split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append(split[2]).append("-");
        int monthNum = 0;
        for (int i = 0; i < months.length; i++) {
            if (split[1].equals(months[i])) {
                monthNum = i + 1;
                break;
            }
        }
        if (monthNum > 9) {
            sb.append(monthNum);
        } else {
            sb.append("0").append(monthNum);
        }
        sb.append("-");

        if (split[0].length() == 3) {
            sb.append("0").append(split[0].charAt(0));
        } else {
            sb.append(split[0].charAt(0)).append(split[0].charAt(1));
        }
        return sb.toString();
    }
}
