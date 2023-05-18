package Model;

import java.util.regex.Pattern;

public class Verification extends InventoryAlert {
    public static Boolean CheckUsername(String username) {
        if (username.isEmpty() || username.length() <6) {
            return false;
        }
        return true;
    }

    public static boolean CheckPass(String pass) {
        if (pass.isEmpty() || !isValidPassword(pass)) {
            return false;
        }
        return true;
    }
    public static boolean isValidPassword(String password) {
        // Kiểm tra độ dài của mật khẩu
        if (password.length() < 8) {
            return false;
        }

        boolean hasLetter = false;
        boolean hasDigit = false;
        boolean hasSpecialCharacter = false;

        // Kiểm tra từng ký tự trong mật khẩu
        for (char c : password.toCharArray()) {
            if (Character.isLetter(c)) {
                hasLetter = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else {
                hasSpecialCharacter = true;
            }
        }

        // Kiểm tra xem mật khẩu có chứa cả chữ, số và ký tự đặc biệt hay không
        return hasLetter && hasDigit && hasSpecialCharacter;
    }

}