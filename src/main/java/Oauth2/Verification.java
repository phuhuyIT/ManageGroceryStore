package Oauth2;

import Controller.InventoryAlert;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

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
    public static boolean isValidPrice(int number) {
        return number >= 0;
    }
    public static boolean isValidQuantity(int number) {
        return number >= 0;
    }
    public static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^0[0-9]{9}$");
    }
    public static boolean isValidEmail(String email) {
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
    }
    public static boolean isValidName(String name) {
        return name.matches("^[a-zA-Z ]+$");
    }
    public static boolean isValidAge(Date birthDate) {
        // Convert java.util.Date to LocalDate
        LocalDate birthdate = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(birthdate, currentDate).getYears();

        return age >= 18 && age < 62;
    }
    public static boolean isValidManufactureDate(LocalDate manufactureDate, LocalDate expirationDate) {
        LocalDate currentDate = LocalDate.now();
        return manufactureDate.isBefore(currentDate) && manufactureDate.isBefore(expirationDate);
    }
    public static boolean isValidExpirationDate(LocalDate manufactureDate, LocalDate expirationDate) {
        LocalDate currentDate = LocalDate.now();
        return expirationDate.isAfter(currentDate) && expirationDate.isAfter(manufactureDate);
    }

}