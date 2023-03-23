package LeetCode.medium;

import java.util.HashSet;
import java.util.Set;

public class Problem2166 {
    //https://leetcode.com/problems/design-bitset/
    public static void main(String[] args) {

    }

}

//nnnn
//Runtime
//121 ms
//Beats
//29.3%
//Memory
//84.7 MB
//Beats
//34.41%
class Bitset {

    int size;
    Set<Integer> set0 = new HashSet<>();
    Set<Integer> set1 = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    public Bitset(int size) {
        this.size = size;
        for (int i = 0; i < size; i++) set0.add(i);
    }

    public void fix(int idx) {
        set1.add(idx);
        set0.remove(idx);
    }

    public void unfix(int idx) {
        set0.add(idx);
        set1.remove(idx);
    }

    public void flip() {
        Set<Integer> temp = set0;
        set0 = set1;
        set1 = temp;
    }

    public boolean all() {
        return set1.size() == size;
    }

    public boolean one() {
        return set1.size() > 0;
    }

    public int count() {
        return set1.size();
    }

    public String toString() {
        sb.setLength(0);
        for (int i = 0; i < size; i++) sb.append(set1.contains(i) ? "1" : "0");
        return sb.toString();
    }
}

//TLE on 44/48
class Bitset1 {
    StringBuilder sb;
    int count1;
    public Bitset1(int size) {
        count1 = 0;
        sb = new StringBuilder();
        for (int i = 0; i < size; i++) sb.append("0");
    }

    public void fix(int idx) {
        sb.setCharAt(idx, '1');
    }

    public void unfix(int idx) {
        sb.setCharAt(idx, '0');
    }

    public void flip() {
        for (int i = 0; i < sb.length(); i++) sb.setCharAt(i, sb.charAt(i) == '1' ? '0' : '1');
    }

    public boolean all() {
        for (int i = 0; i < sb.length(); i++) if (sb.charAt(i) == '0') return false;
        return true;
    }

    public boolean one() {
        for (int i = 0; i < sb.length(); i++) if (sb.charAt(i) == '1') return true;
        return false;
    }

    public int count() {
        int count = 0;
        for (int i = 0; i < sb.length(); i++) if (sb.charAt(i) == '1') count++;
        return count;
    }

    public String toString() {
        return sb.toString();
    }
}
