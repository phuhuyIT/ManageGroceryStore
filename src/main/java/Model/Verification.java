package Model;

import java.util.regex.Pattern;

public class Verification extends InventoryAlert {
    public void CheckUsername(String username) {
        if (username.isEmpty()) {
            errorAlert("ERROR", "Username is empty!");
        }
    }

    public void CheckPass(String pass) {
        if (pass.isEmpty()) {
            errorAlert("ERROR", "Password is empty!");
        }
    }
}