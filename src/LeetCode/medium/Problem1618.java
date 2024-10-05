package LeetCode.medium;

import java.util.HashSet;
import java.util.Set;

public class Problem1618 {
    //https://leetcode.com/problems/maximum-font-to-fit-a-sentence-in-a-screen
    public static void main(String[] args) {

    }

    //https://leetcode.com/problems/maximum-font-to-fit-a-sentence-in-a-screen/solutions/5873284/java-binarysearch-solution/
    //15min
    //Runtime
    //3
    //ms
    //Beats
    //11.11%
    //Analyze Complexity
    //Memory
    //56.88
    //MB
    //Beats
    //5.56%
//    public int maxFont(String text, int w, int h, int[] fonts, FontInfo fontInfo) {
//        int[] alph = new int[26];
//        for (int i = 0; i < text.length(); i++) alph[text.charAt(i) - 'a']++;
//        int left = 0, right = fonts.length;
//        int max = -1;
//        Set<Integer> set = new HashSet<>();
//
//        while (left <= right) {
//            int mid = (left + right) / 2;
//            if (set.contains(mid)) break;
//            set.add(mid);
//            if (fitsIntoScreen(alph, fonts, w, h, mid, fontInfo)) {
//                max = Math.max(max, fonts[mid]);
//                left = mid;
//            } else {
//                right = mid;
//            }
//        }
//
//        return max;
//    }
//
//    private boolean fitsIntoScreen(int[] alph, int[] fonts, int w, int h, int idx, FontInfo fontInfo) {
//        int size = fonts[idx];
//        long sum = 0;
//        if (fontInfo.getHeight(size) > h) return false;
//        for (int i = 0; i < 26; i++) {
//            int width = fontInfo.getWidth(size, (char)('a' + i));
//            sum += width * 1L * alph[i];
//        }
//        return sum <= w;
//    }
}
