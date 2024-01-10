package Bank.Account;

public class PasswordValidator {
    private static final int REQUIRED_LENGTH = 6;
   
    protected static boolean validateLength(String password) {
        return password.length() >= REQUIRED_LENGTH;
    }
    
    protected static boolean validateUpper(String password) {
        for (char character : password.toCharArray()) {
            if (Character.isUpperCase(character)) {
                return true;
            }
        }
        return false;
    }

    protected static boolean validateLower(String password) {
        for (char character : password.toCharArray()) {
            if (Character.isLowerCase(character)) {
                return true;
            }
        }
        return false;
    }
    
    protected static boolean validateDigit(String password) {
        for (char character : password.toCharArray()) {
            if (Character.isDigit(character)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean validatePassword(String password) {
        return validateLength(password) && validateUpper(password) && validateLower(password) && validateDigit(password);
    }
}
