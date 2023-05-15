package Model;

public class VerifyEmail {
    private String email;
    private String otp;

    public VerifyEmail(String email, String otp) {
        this.email = email;
        this.otp = otp;
    }

    public VerifyEmail() {
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getEmail() {
        return email;
    }

    public String getOtp() {
        return otp;
    }
}
