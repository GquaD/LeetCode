package LeetCode.medium;

import LeetCode.LeetCodeUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem93 {
    //https://leetcode.com/problems/restore-ip-addresses/
    public static void main(String[] args) {
        LeetCodeUtils.printList(restoreIpAddresses("25525511135"));
        LeetCodeUtils.printList(restoreIpAddresses("0"));
        LeetCodeUtils.printList(restoreIpAddresses("101023"));
    }

    static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int len = s.length();
        for(int i = 1; i<4 && i<len-2; i++){
            for(int j = i+1; j<i+4 && j<len-1; j++){
                for(int k = j+1; k<j+4 && k<len; k++){
                    String s1 = s.substring(0,i), s2 = s.substring(i,j), s3 = s.substring(j,k), s4 = s.substring(k,len);
                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){
                        res.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }
        return res;
    }
    public static boolean isValid(String s){
        if(s.length()>3 || s.length()==0 || (s.charAt(0)=='0' && s.length()>1) || Integer.parseInt(s)>255)
            return false;
        return true;
    }

    static List<String> restoreIpAddresses1(String s) {
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            restoreRecursively(i, sb, s, set);
        }
        return new ArrayList<>(set);
    }

    private static void restoreRecursively(int idx, StringBuilder sb, String s, Set<String> set) {
        if (idx == s.length()) {
            if (sb.length() > 6 && sb.length() < 16)
                set.add(sb.toString());
            return;
        }

        String currString = sb.toString();
        if (isValidIPAddress(currString)) set.add(currString);
        /*char curr = s.charAt(idx++);
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) != '.') sb.append(".").append(curr);
        else sb.append(curr);*/
        sb.append(s.charAt(idx));
        String[] split = sb.toString().split("\\.");
        String last = split[split.length - 1];
        int times = 3 - last.length();
        if (times == 0) {
            sb.append(".");
            times = 3;
        }
        for (int i = idx + 1; i < s.length(); i++) {
            //sb.append(s.charAt(i));
            restoreRecursively(i, sb, s, set);
            //sb.replace(sb.length() - 1, sb.length(), "");
        }

        if (sb.length() > 1) sb.replace(sb.length() - 1, sb.length(), "");
    }

    private static boolean isValidIPAddress(String s) {
        if (s.length() < 7) return false;
        String[] split = s.split("\\.");
        if (split.length != 4) return false;
        for (String p : split)
            if (p.length() > 1 && p.startsWith("0") || Integer.parseInt(p) > 255) return false;

        return true;
    }


    private static void goRecursive(int idx, List<Integer> list, int[] nums, Set<List<Integer>> set) {
        if (idx == nums.length) {
            if (list.size() > 1) {
                List<Integer> listNew = new ArrayList<>(list);
                set.add(listNew);
            }
            return;
        }

        int curr = nums[idx++];
        if (!list.isEmpty() && curr >= list.get(list.size() - 1)) list.add(curr);
        else list.add(curr);

        for (int i = idx; i < nums.length; i++) {
            if (nums[i] >= list.get(list.size() - 1)) goRecursive(i, list, nums, set);
        }

        if (list.size() > 1) {
            List<Integer> listNew = new ArrayList<>(list);
            set.add(listNew);
        }

        if (!list.isEmpty()) list.remove(list.size() - 1);
    }
}
