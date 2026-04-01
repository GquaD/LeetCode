package LeetCode.easy;

public class Problem3582 {
    //15min

    //Runtime
    //4
    //ms
    //Beats
    //81.12%
    //Memory
    //45.28
    //MB
    //Beats
    //70.92%
    public String generateTag(String caption) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        String[] split = caption.split(" ");
        for (String s : split) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (isChar(c)) {
                    if (sb.length() == 100)
                        break;
                    if (count++ == 0) {
                        sb.append(makeUpper(c));
                    } else {
                        sb.append(makeLower(c));
                    }
                }
            }
        }

        if (sb.length() > 1) {
            char c = makeLower(sb.charAt(1));
            sb.setCharAt(1, c);
        }

        return sb.toString();
    }

    private char makeUpper(char c) {
        if (c >= 'a' && c <= 'z')
            return (char) (c - 'a' + 'A');
        return c;
    }

    private char makeLower(char c) {
        if (c >= 'A' && c <= 'Z')
            return (char) (c - 'A' + 'a');
        return c;
    }

    private boolean isChar(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }
}
