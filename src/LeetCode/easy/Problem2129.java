package LeetCode.easy;

public class Problem2129 {
    //https://leetcode.com/problems/capitalize-the-title/
    public static void main(String[] args) {
        System.out.println(capitalizeTitle("capiTalIze tHe titLe"));
        System.out.println(capitalizeTitle("First leTTeR of EACH Word"));
        System.out.println(capitalizeTitle("First leTTeR OF EACH Word"));
    }

    //https://leetcode.com/problems/capitalize-the-title/solutions/2890563/java-2-ms-solution-95-faster/
    //5 min
    //Runtime
    //2 ms
    //Beats
    //95.30%
    //Memory
    //42.2 MB
    //Beats
    //87.23%
    static String capitalizeTitle(String title) {
        String[] split = title.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            if (s.length() > 2) {
                sb.append(Character.toUpperCase(s.charAt(0)))
                        .append(s.substring(1).toLowerCase());
            } else {
                sb.append(s.toLowerCase());
            }
            sb.append(" ");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
