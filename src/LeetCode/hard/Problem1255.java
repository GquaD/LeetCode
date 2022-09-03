package LeetCode.hard;

import java.util.*;
import java.util.stream.Collectors;

public class Problem1255 {
    //https://leetcode.com/problems/maximum-score-words-formed-by-letters/
    public static void main(String[] args) {
        //works only for this for now
        System.out.println(maxScoreWords(new String[]{"dog", "cat", "dad", "good" },
                new char[]{'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'},
                new int[]{1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
        //23
        System.out.println(maxScoreWords(new String[]{"xxxz", "ax", "bx", "cx" },
                new char[]{'z', 'a', 'b', 'c', 'x', 'x', 'x'},
                new int[]{4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 10}));
        //27
        System.out.println(maxScoreWords(new String[]{"leetcode" },
                new char[]{'l', 'e', 't', 'c', 'o', 'd'},
                new int[]{0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0}));
        //0
        System.out.println(maxScoreWords(new String[]{"aceea", "bbead", "dcdbc", "dbebd", "ebaa", "cbdd" },
                new char[]{'a', 'a', 'a', 'a', 'a', 'b', 'c', 'd', 'd', 'd', 'e', 'e', 'e', 'e', 'e', 'e'},
                new int[]{2, 7, 1, 4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
        //19
        System.out.println(maxScoreWords(new String[]{"adbc", "caaa", "deadc", "ecbd", "ecdd", "abdb" },
                new char[]{'a','a','a','a','b','b','b','b','b','b','c','c','d','d','d','d','e','e','e','e'},
                new int[]{6, 2, 8, 8, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
        //actual:74
        //expected:78
    }

    //3rd version (not considering all combinations)
    static int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] points = new int[words.length];
        //scores of each word
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                int index = words[i].charAt(j) - 97;
                points[i] += score[index];
            }
            Pair pair = new Pair(words[i], points[i]);
            list.add(pair);
        }
        list = list.stream().sorted((o1, o2) -> o2.score - o1.score).collect(Collectors.toList());
        int[] finalScores = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            String lettersString = new String(letters);
            String lettersCheck = new String(letters);
            int scoreFinal = 0;
            for (int i = k; i < list.size(); i++) {
                Pair pair = list.get(i);
                boolean fullyContains = true;
                lettersCheck = new String(lettersString);
                for (int j = 0; j < pair.word.length(); j++) {
                    if (!lettersCheck.contains(pair.word.charAt(j) + "")) {
                        fullyContains = false;
                        break;
                    }
                    lettersCheck = lettersCheck.replaceFirst(pair.word.charAt(j) + "", "");
                }
                if (!fullyContains) {
                    continue;
                }
                for (int j = 0; j < pair.word.length(); j++) {
                    lettersString = lettersString.replaceFirst(pair.word.charAt(j) + "", "");
                }
                scoreFinal += pair.score;
            }
            finalScores[k] = scoreFinal;
        }

        int max = 0;
        for (int i = 0; i < finalScores.length; i++) {
            if (max < finalScores[i]) {
                max = finalScores[i];
            }
        }
        return max;
    }

    //write down a code that iterates over all possible combinations

    static int maxScoreWords2(String[] words, char[] letters, int[] score) {
        int[] points = new int[words.length];
        //scores of each word
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                int index = words[i].charAt(j) - 97;
                points[i] += score[index];
            }
            Pair pair = new Pair(words[i], points[i]);
            list.add(pair);
        }
        list = list.stream().sorted((o1, o2) -> o2.score - o1.score).collect(Collectors.toList());
        String lettersString = new String(letters);
        String lettersCheck = new String(letters);
        int scoreFinal = 0;
        for (int i = 0; i < list.size(); i++) {
            Pair pair = list.get(i);
            boolean fullyContains = true;
            lettersCheck = new String(lettersString);
            for (int j = 0; j < pair.word.length(); j++) {
                if (!lettersCheck.contains(pair.word.charAt(j) + "")) {
                    fullyContains = false;
                    break;
                }
                lettersCheck = lettersCheck.replaceFirst(pair.word.charAt(j) + "", "");
            }
            if (!fullyContains) {
                continue;
            }
            for (int j = 0; j < pair.word.length(); j++) {
                lettersString = lettersString.replaceFirst(pair.word.charAt(j) + "", "");
            }
            scoreFinal += pair.score;
        }

        lettersString = new String(letters);
        lettersCheck = new String(letters);
        int scoreFinal2 = 0;
        for (int i = 1; i < list.size(); i++) {
            Pair pair = list.get(i);
            boolean fullyContains = true;
            lettersCheck = new String(lettersString);
            for (int j = 0; j < pair.word.length(); j++) {
                if (!lettersCheck.contains(pair.word.charAt(j) + "")) {
                    fullyContains = false;
                    break;
                }
                lettersCheck = lettersCheck.replaceFirst(pair.word.charAt(j) + "", "");
            }
            if (!fullyContains) {
                continue;
            }
            for (int j = 0; j < pair.word.length(); j++) {
                lettersString = lettersString.replaceFirst(pair.word.charAt(j) + "", "");
            }
            scoreFinal2 += pair.score;
        }

        return scoreFinal > scoreFinal2 ? scoreFinal : scoreFinal2;
    }

    static int maxScoreWords1(String[] words, char[] letters, int[] score) {
        int[] points = new int[words.length];
        //scores of each word
        Map<String, Integer> map = new HashMap<>();
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                int index = words[i].charAt(j) - 97;
                points[i] += score[index];
            }
            map.put(words[i], points[i]);
            Pair pair = new Pair(words[i], points[i]);
            list.add(pair);
        }
        list = list.stream().sorted((o1, o2) -> o2.score - o1.score).collect(Collectors.toList());
        //sort in decreasing by scores of words
        Integer[] points2 = new Integer[points.length];
        for (int i = 0; i < points.length; i++) {
            points2[i] = points[i];
        }
        Arrays.sort(points2, Collections.reverseOrder());


        //consider letter and max value which can be gained

        //letters consider
        int maxPoints = 0;
        for (int i = 0; i < points.length; i++) {
            if (maxPoints < points[i]) {
                maxPoints = points[i];
            }
        }
        return maxPoints;
    }

    static class Pair {
        String word;
        int score;

        public Pair(String word, int score) {
            this.word = word;
            this.score = score;
        }
    }
}
