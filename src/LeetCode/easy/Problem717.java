package LeetCode.easy;

public class Problem717 {
    //https://leetcode.com/problems/1-bit-and-2-bit-characters/
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/1-bit-and-2-bit-characters/solutions/3524362/java-o-n-100-faster-solution/
    //2min
    //Runtime
    //0 ms
    //Beats
    //100%
    //Memory
    //42.6 MB
    //Beats
    //6.10%
    static boolean isOneBitCharacter(int[] bits) {
        boolean oneBit = true;
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == 1) {
                i++;
                oneBit = false;
            } else oneBit = true;
        }
        return oneBit;
    }
}
