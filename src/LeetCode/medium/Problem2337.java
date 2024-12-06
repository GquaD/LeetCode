package LeetCode.medium;

public class Problem2337 {
    //https://leetcode.com/problems/move-pieces-to-obtain-a-string
    public static void main(String[] args) {

    }

    //nn
    //1-2 hours
    //Runtime
    //14
    //ms
    //Beats
    //82.12%
    //Analyze Complexity
    //Memory
    //45.71
    //MB
    //Beats
    //29.15%
    public boolean canChange(String start, String target) {
        int idxs = -1, idxt = -1, len = start.length();
        while (idxs < len || idxt < len) {
            idxs++;
            idxt++;
            while (idxs < len && start.charAt(idxs) == '_')
                idxs++;
            while (idxt < len && target.charAt(idxt) == '_')
                idxt++;
            if (idxs < len && idxt < len && start.charAt(idxs) != target.charAt(idxt))
                break;
            if (idxs < len && (start.charAt(idxs) == 'L' && idxs < idxt || start.charAt(idxs) == 'R' && idxs > idxt))
                break;
        }
        return idxs == idxt && idxs == len;
    }
}
