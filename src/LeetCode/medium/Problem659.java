package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Problem659 {
    //https://leetcode.com/problems/split-array-into-consecutive-subsequences/
    public static void main(String[] args) {

        System.out.println(isPossible(new int[]{1, 2, 3, 4, 5, 5, 6, 7}));//true
        System.out.println(isPossible(new int[]{2, 3, 3, 5, 6, 6, 7, 8, 9, 10}));//false
        System.out.println(isPossible(new int[]{1, 2, 3, 3, 4, 5}));//true
        System.out.println(isPossible(new int[]{1, 2, 3, 3, 4, 4, 5, 5}));//true
        System.out.println(isPossible(new int[]{1, 2, 3, 4, 4, 5}));//false
    }

    //Runtime: 884 ms, faster than 5.23% of Java online submissions for Split Array into Consecutive Subsequences.
    //Memory Usage: 71.7 MB, less than 46.14% of Java online submissions for Split Array into Consecutive Subsequences.
    static boolean isPossible(int[] nums) {
        List<List<Integer>> listMain = new ArrayList<>();
        List<Integer> firstStack = new ArrayList<>();
        firstStack.add(nums[0]);
        listMain.add(firstStack);
        for (int i = 1; i < nums.length; i++) {
            boolean sticksNowhere = true;
            for (int j = listMain.size() - 1; j >= 0 ; j--) {
                List<Integer> stackCurrent = listMain.get(j);
                if (nums[i] == stackCurrent.get(stackCurrent.size() - 1) + 1) {
                    stackCurrent.add(nums[i]);
                    sticksNowhere = false;
                    break;
                }
            }
            if (sticksNowhere) {
                List<Integer> stack = new ArrayList<>();
                stack.add(nums[i]);
                listMain.add(stack);
            }
        }

        for (int i = 0; i < listMain.size(); i++) {
            if (listMain.get(i).size() < 3) {
                return false;
            }
        }
        return true;
    }

    //187 / 187 test cases passed, but took too long.
    static boolean isPossible2(int[] nums) {
        List<Stack<Integer>> listMain = new ArrayList<>();
        Stack<Integer> firstStack = new Stack<>();
        firstStack.push(nums[0]);
        listMain.add(firstStack);
        for (int i = 1; i < nums.length; i++) {
            boolean sticksNowhere = true;
            for (int j = listMain.size() - 1; j >= 0 ; j--) {
                Stack<Integer> stackCurrent = listMain.get(j);
                if (nums[i] == stackCurrent.peek() + 1) {
                    stackCurrent.push(nums[i]);
                    sticksNowhere = false;
                    break;
                }
            }
            if (sticksNowhere) {
                Stack<Integer> stack = new Stack<>();
                stack.push(nums[i]);
                listMain.add(stack);
            }
        }

        for (int i = 0; i < listMain.size(); i++) {
            if (listMain.get(i).size() < 3) {
                return false;
            }
        }
        return true;
    }

    static boolean isPossible1(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        List<Integer> listNum = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            listNum.add(nums[i]);
        }
        if (listNum.size() == 3) {
            return listNum.get(0) == listNum.get(1) - 1 && listNum.get(1) == listNum.get(2) - 1;
        }
        List<List<Integer>> res = new ArrayList<>();
        int startIndex = 0;
        while (listNum.size() > 2) {
            if (startIndex >= listNum.size()) {
                break;
            }
            List<Integer> meme = new ArrayList<>(listNum);
            if (listNum.size() == 3) {
                if (!(listNum.get(0) == listNum.get(1) - 1 && listNum.get(1) == listNum.get(2) - 1)) {
                    break;
                }
            }
            List<Integer> resTemp = new ArrayList<>();
            resTemp.add(listNum.get(startIndex));
            removeCurrentWithNum(startIndex, listNum);
            for (int i = startIndex + 1; i < listNum.size(); i++) {
                if (listNum.get(i) - resTemp.get(resTemp.size() - 1) == 1) {
                    resTemp.add(listNum.get(i));
                    removeCurrentWithNum(i, listNum);
                }
                if (resTemp.size() == 3 && listNum.size() >= 6) {
                    break;
                }
            }
            if (resTemp.size() >= 3) {
                res.add(resTemp);
            } else {
                startIndex++;
                listNum = meme;
            }
            listNum = listNum.stream().filter(n -> n > -10000).collect(Collectors.toList());
        }
        int count = 0;
        if (listNum.size() > 0) {
            for (int i = 0; i < listNum.size(); i++) {
                int curr = listNum.get(i);
                for (int j = 0; j < res.size(); j++) {
                    List<Integer> list = res.get(j);
                    if (curr - 1 == list.get(list.size() - 1)) {
                        list.add(curr);
                        count++;
                        break;
                    }
                }
            }
        }

        if (listNum.size() == 0 || listNum.size() == count) {
            return true;
        }

        return false;
    }

    private static void removeCurrentWithNum(int i, List<Integer> resTemp) {
        resTemp.remove(i);
        resTemp.add(i, -10000);
    }
}
