package LeetCode.medium;


public class Problem13 {
    //https://leetcode.com/problems/roman-to-integer/

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt("DCXXI"));
    }

    //https://leetcode.com/problems/roman-to-integer/solutions/2667144/two-java-solutions/
    //Runtime
    //8 ms
    //Beats
    //64.58%
    //Memory
    //45.5 MB
    //Beats
    //60.66%
    static int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i + 1 < s.length()) {
                char d = s.charAt(i + 1);
                boolean numIsUsed = false;
                switch (c) {
                    case 'C': {
                        switch (d) {
                            case 'M': {
                                result += 900;
                                numIsUsed = true;
                                break;
                            }
                            case 'D': {
                                result += 400;
                                numIsUsed = true;
                                break;
                            }
                        }
                        break;
                    }
                    case 'X': {
                        switch (d) {
                            case 'C': {
                                result += 90;
                                numIsUsed = true;
                                break;
                            }
                            case 'L': {
                                result += 40;
                                numIsUsed = true;
                                break;
                            }
                        }
                        break;
                    }
                    case 'I': {
                        switch (d) {
                            case 'X': {
                                result += 9;
                                numIsUsed = true;
                                break;
                            }
                            case 'V': {
                                result += 4;
                                numIsUsed = true;
                                break;
                            }
                        }
                        break;
                    }
                }
                if (numIsUsed) {
                    i++;
                    continue;
                }
            }
            switch (c) {
                case 'M': {
                    result += 1000;
                    break;
                }
                case 'D': {
                    result += 500;
                    break;
                }
                case 'C': {
                    result += 100;
                    break;
                }
                case 'L': {
                    result += 50;
                    break;
                }
                case 'X': {
                    result += 10;
                    break;
                }
                case 'V': {
                    result += 5;
                    break;
                }
                case 'I': {
                    result++;
                    break;
                }
            }
        }
        return result;
    }

    //20 mins
    //Runtime
    //11 ms
    //Beats
    //46.65%
    //Memory
    //43.1 MB
    //Beats
    //85.76%
    static int romanToInt1(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i + 1 < s.length()) {
                String num = c + "" + s.charAt(i + 1);
                boolean numIsUsed = false;
                switch (num) {
                    case "CM": {
                        result += 900;
                        numIsUsed = true;
                        break;
                    }
                    case "CD": {
                        result += 400;
                        numIsUsed = true;
                        break;
                    }
                    case "XC": {
                        result += 90;
                        numIsUsed = true;
                        break;
                    }
                    case "XL": {
                        result += 40;
                        numIsUsed = true;
                        break;
                    }
                    case "IX": {
                        result += 9;
                        numIsUsed = true;
                        break;
                    }
                    case "IV": {
                        result += 4;
                        numIsUsed = true;
                        break;
                    }
                }
                if (numIsUsed) {
                    i++;
                    continue;
                }
            }
            switch (c) {
                case 'M': {
                    result += 1000;
                    break;
                }
                case 'D': {
                    result += 500;
                    break;
                }
                case 'C': {
                    result += 100;
                    break;
                }
                case 'L': {
                    result += 50;
                    break;
                }
                case 'X': {
                    result += 10;
                    break;
                }
                case 'V': {
                    result += 5;
                    break;
                }
                case 'I': {
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}
