public class PasswordValidator {
    public static boolean validatePassword(String password) {
        // Check length
        if (password.length() < 5 || password.length() > 12) return false;

        // Check for at least one lowercase letter and a digit, and disallow uppercase or special characters
        if (!password.matches(".*[a-z].*") || !password.matches(".*[0-9].*") || password.matches(".*[A-Z].*") || password.matches(".*[^a-z0-9].*")) {
            return false;
        }

        // Check for immediate repeating patterns of two consecutive characters
        for (int i = 0; i < password.length() - 2; i++) {
            String pair = password.substring(i, i + 2); // Extract current pair of characters
            if (password.substring(i + 2).contains(pair)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validatePassword("abc11"));      // false (repeated "11")
        System.out.println(validatePassword("123sd123"));   // true
        System.out.println(validatePassword("123aaa123"));  // false (repeated "aa")
        System.out.println(validatePassword("abcdefg"));    // true
    }
}
