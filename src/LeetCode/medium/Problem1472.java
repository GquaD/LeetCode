package LeetCode.medium;

import java.util.LinkedList;
import java.util.List;

public class Problem1472 {
    //https://leetcode.com/problems/design-browser-history/
    public static void main(String[] args) {
        BrowserHistory history = new BrowserHistory("leetcode");
        history.visit("google");
        history.visit("facebook");
        history.visit("youtube");
        history.back(1);
        history.back(1);
        history.forward(1);
        history.visit("linkedin");
        history.forward(2);
        history.back(2);
        history.back(7);

    }

    //30-40 mins
    //Runtime: 108 ms, faster than 54.02% of Java online submissions for Design Browser History.
    //Memory Usage: 83 MB, less than 44.80% of Java online submissions for Design Browser History.
    static class BrowserHistory {
        List<String> list;
        int position;

        public BrowserHistory(String homepage) {
            list = new LinkedList<>();
            list.add(homepage);
            position = 0;
        }

        public void visit(String url) {
            if (position != list.size() - 1) {
                int fix = list.size() - 1 - position;
                for (int i = 0; i < fix; i++) {
                    list.remove(list.size() - 1);
                }
            }
            position++;
            list.add(url);
        }

        public String back(int steps) {
            position -= Math.min(steps, position);
            return list.get(position);
        }

        public String forward(int steps) {
            if (position + steps <= list.size() - 1) {
                position += steps;
            } else {
                position = list.size() - 1;
            }
            return list.get(position);
        }
    }
}
