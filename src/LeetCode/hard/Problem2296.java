package LeetCode.hard;

public class Problem2296 {
    //https://leetcode.com/problems/design-a-text-editor/
    public static void main(String[] args) {

    }
}

//https://leetcode.com/problems/design-a-text-editor/solutions/3674175/java-using-stringbuilder-count/
//20 min
//Runtime
//240 ms
//Beats
//20.16%
//Memory
//55.8 MB
//Beats
//100%
class TextEditor {

    StringBuilder sb;
    int cursor;
    public TextEditor() {
        sb = new StringBuilder();
        cursor = 0;
    }

    public void addText(String text) {
        sb.replace(cursor, cursor, text);
        cursor += text.length();
    }

    public int deleteText(int k) {
        if (k >= cursor) {
            sb.replace(0, cursor, "");
            int temp = cursor;
            cursor = 0;
            return temp;
        } else {
            sb.replace(cursor - k, cursor, "");
            cursor -= k;
            return k;
        }
    }

    public String cursorLeft(int k) {
        cursor = Math.max(0, cursor - k);
        int len = Math.min(10, cursor);
        return sb.substring(cursor - len, cursor);
    }

    public String cursorRight(int k) {
        cursor = Math.min(cursor + k, sb.length());
        int len = Math.min(10, cursor);
        return sb.substring(cursor - len, cursor);
    }
}
