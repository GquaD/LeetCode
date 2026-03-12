package LeetCode.easy;

public class Problem2566 {
    //5min

    //Runtime
    //2
    //ms
    //Beats
    //29.57%
    //Memory
    //42.27
    //MB
    //Beats
    //73.01%
    public int minMaxDifference(int num) {
        StringBuilder sb = new StringBuilder();
        String n = num + "";
        char first = n.charAt(0);
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == first) {
                sb.append(0);
            } else {
                sb.append(n.charAt(i));
            }
        }

        int min = Integer.parseInt(sb.toString());
        sb.setLength(0);

        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) < '9') {
                first = n.charAt(i);
                break;
            }
        }

        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == first) {
                sb.append(9);
            } else {
                sb.append(n.charAt(i));
            }
        }

        int max = Integer.parseInt(sb.toString());
        return max - min;
    }
}
