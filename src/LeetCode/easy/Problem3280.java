package LeetCode.easy;

public class Problem3280 {
    //https://leetcode.com/problems/convert-date-to-binary
    public static void main(String[] args) {

    }


}
//https://leetcode.com/problems/convert-date-to-binary/solutions/5755857/java-o-1-solution/
//2min
//Runtime
//3
//ms
//Beats
//100.00%
//Analyze Complexity
//Memory
//42.35
//MB
//Beats
//100.00%
class Solution3280 {
    StringBuilder sb;

    public String convertDateToBinary(String date) {
        if (sb == null) {
            sb = new StringBuilder();
        } else {
            sb.setLength(0);
        }
        String[] split = date.split("-");
        sb.append(Integer.toBinaryString(Integer.parseInt(split[0])));
        sb.append("-");
        sb.append(Integer.toBinaryString(Integer.parseInt(split[1])));
        sb.append("-");
        sb.append(Integer.toBinaryString(Integer.parseInt(split[2])));
        return sb.toString();
    }
}
