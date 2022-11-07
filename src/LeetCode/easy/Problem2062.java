package LeetCode.easy;

public class Problem2062 {
    //https://leetcode.com/problems/count-vowel-substrings-of-a-string/
    public static void main(String[] args) {
        System.out.println(countVowelSubstrings("aeiouu"));
        System.out.println(countVowelSubstrings("unicornarihan"));
        System.out.println(countVowelSubstrings("cuaieuouac"));
    }

    //https://leetcode.com/problems/count-vowel-substrings-of-a-string/solutions/2787709/java-71-time-72-memory-solution/
    //15 mins
    //Runtime
    //12 ms
    //Beats
    //70.54%
    //Memory
    //42.2 MB
    //Beats
    //71.65%
    static int countVowelSubstrings(String word) {
        int countSubs = 0;
        byte[] vowels = new byte[5];
        for (int i = 0; i < word.length(); i++) {
            int count = i;
            while (count < word.length() && isVowel(word.charAt(count))) {
                char c = word.charAt(count);
                switch (c) {
                    case 'a':
                        vowels[0]++;
                        break;
                    case 'e':
                        vowels[1]++;
                        break;
                    case 'i':
                        vowels[2]++;
                        break;
                    case 'o':
                        vowels[3]++;
                        break;
                    case 'u':
                        vowels[4]++;
                        break;
                }
                if (containsAllVowels(vowels)) {
                    countSubs++;
                }
                count++;
            }
            refreshArray(vowels);
        }
        return countSubs;
    }

    private static void refreshArray(byte[] vowels) {
        for (int i = 0; i < vowels.length; i++) {
            vowels[i] = 0;
        }
    }

    private static boolean containsAllVowels(byte[] vowels) {
        for (byte b : vowels) {
            if (b == 0) return false;
        }
        return true;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
