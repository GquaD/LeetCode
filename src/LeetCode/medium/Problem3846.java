package LeetCode.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem3846 {
    //10min


    private static Map<Character, Coordinates> map = generateGrid();

    private static Map<Character, Coordinates> generateGrid() {
        Map<Character, Coordinates> map = new HashMap();
        map.put('q', new Coordinates(0, 0));
        map.put('w', new Coordinates(0, 1));
        map.put('e', new Coordinates(0, 2));
        map.put('r', new Coordinates(0, 3));
        map.put('t', new Coordinates(0, 4));
        map.put('y', new Coordinates(0, 5));
        map.put('u', new Coordinates(0, 6));
        map.put('i', new Coordinates(0, 7));
        map.put('o', new Coordinates(0, 8));
        map.put('p', new Coordinates(0, 9));
        map.put('a', new Coordinates(1, 0));
        map.put('s', new Coordinates(1, 1));
        map.put('d', new Coordinates(1, 2));
        map.put('f', new Coordinates(1, 3));
        map.put('g', new Coordinates(1, 4));
        map.put('h', new Coordinates(1, 5));
        map.put('j', new Coordinates(1, 6));
        map.put('k', new Coordinates(1, 7));
        map.put('l', new Coordinates(1, 8));
        map.put('z', new Coordinates(2, 0));
        map.put('x', new Coordinates(2, 1));
        map.put('c', new Coordinates(2, 2));
        map.put('v', new Coordinates(2, 3));
        map.put('b', new Coordinates(2, 4));
        map.put('n', new Coordinates(2, 5));
        map.put('m', new Coordinates(2, 6));
        return map;
    }

    public int totalDistance(String s) {
        int distance = 0;
        char prev = 'a';
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            Coordinates one = map.get(prev), two = map.get(cur);
            distance += Math.abs(one.row - two.row) + Math.abs(one.col - two.col);
            prev = cur;
        }
        return distance;
    }
}

class Coordinates {
    int row, col;

    public Coordinates(int r, int c) {
        row = r;
        col = c;
    }
}
