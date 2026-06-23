package LeetCode.easy;

public class Problem2299 {
    //10min

    //Runtime
    //1
    //ms
    //Beats
    //80.70%
    //Memory
    //43.03
    //MB
    //Beats
    //21.52%
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) return false;

        boolean hasLowercase = false, hasUppercase = false, hasOneDigit = false, hasSpecialChar = false, hasTwo = false;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (!hasLowercase && c >= 'a' && c <= 'z') hasLowercase = true;
            if (!hasUppercase && c >= 'A' && c <= 'Z') hasUppercase = true;
            if (!hasOneDigit && c >= '0' && c <= '9') hasOneDigit = true;
            if (!hasSpecialChar && isSpecialCharacter(c)) hasSpecialChar = true;
        }


        for (int i = 0; i < password.length() - 1; i++) {
            if (password.charAt(i) == password.charAt(i + 1)) {
                hasTwo = true;
                break;
            }
        }

        return hasLowercase && hasUppercase && hasOneDigit && hasSpecialChar && !hasTwo;
    }

    private boolean isSpecialCharacter(char c) {
        return "!@#$%^&*()-+".contains(("" + c));
    }
}
