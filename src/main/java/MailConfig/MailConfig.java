package MailConfig;

import DatabaseConnection.ConnectionFactory;
import Model.VerifyEmail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

public class MailConfig {
    public static final String HOST_NAME = "smtp.gmail.com";

    public static final int TSL_PORT = 587; // Port for TLS/STARTTLS

    public static final String APP_EMAIL = "nvvinvla1.2019@gmail.com"; // your email

    public static final String APP_PASSWORD = "jqqwedanyawfhbsh"; // your password

    private static final String LIST_OTP = "0123456789";

    public static void sendOTP(String email) {
        VerifyEmail verifyEmail = getVerifyEmailByEmail(email);
        String query;
        if(verifyEmail == null) {
            query = "INSERT INTO verify_mail(mail, otp) VALUES(?, ?)";
        } else {
            query = "UPDATE verify_mail SET otp = ?";
        }
        String otp = "";
        Random random = new Random();
        for(int i = 1; i <= 6; i++) {
            otp = otp + LIST_OTP.charAt(random.nextInt(LIST_OTP.length()));
        }
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        try {
            PreparedStatement ptmt = connection.prepareStatement(query);
            if(verifyEmail == null) {
                ptmt.setString(1, email);
                ptmt.setString(2, otp);
            } else  {
                ptmt.setString(1, otp);
            }
            System.out.println(query);
            ptmt.executeUpdate();
            // Cấu hình các thuộc tính cho phiên làm việc (session)
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", HOST_NAME);
            props.put("mail.smtp.port", TSL_PORT);

            // Tạo một phiên làm việc (session)
            Session session = Session.getInstance(props,
                    new Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(APP_EMAIL, APP_PASSWORD);
                        }
                    });

            // Tạo message
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(APP_EMAIL));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("Verification otp code has been sent to your email account. #"+System.currentTimeMillis());

            // Tạo đối tượng Multipart để chứa các phần của email
            Multipart multipart = new MimeMultipart();

            // File HTML
            BodyPart htmlPart = new MimeBodyPart();
            htmlPart.setContent("<div style=\"width: 600px; height: 500px;   ; border-radius: 10px; background-color: #4a9aff;\">\n" +
                    "        <h3 style=\"color: rgb(4, 12, 16); padding: 0 10px;\">Hello,</h3>\n" +
                    "        <h3 style=\"color: rgb(5, 17, 23); padding: 0 10px;\" >We received a request to send an OTP from this email account.</h3>\n" +
                    "        <h3 style=\"color: rgb(5, 18, 24);padding: 0 10px;\">Code OTP:" +otp+"</h3>\n" +
                    "        <h3 style=\"color: rgb(4, 15, 20);padding: 0 10px;\" >Thank you!</h3>\n" +
                    "    </div>", "text/html; charset=utf-8");
            multipart.addBodyPart(htmlPart);
            message.setContent(multipart);
            // Gửi thư điện tử
            Transport.send(message);
            System.out.println("Send mail successfully");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static VerifyEmail getVerifyEmailByEmail(String mail) {
        String querySelect = "SELECT * FROM verify_mail WHERE mail = ?";
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.getConnection();
        VerifyEmail verifyEmail = null;

        try {
            PreparedStatement ptmt = connection.prepareStatement(querySelect);
            ptmt.setString(1, mail);
            ResultSet rs = ptmt.executeQuery();
            while(rs.next()) {
                verifyEmail = new VerifyEmail();
                verifyEmail.setEmail(rs.getString("mail"));
                verifyEmail.setOtp(rs.getString("otp"));
            }
            return  verifyEmail;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean verifyOTP(String email, String otp) {
        VerifyEmail verifyEmail = getVerifyEmailByEmail(email);
        System.out.println(verifyEmail.getOtp() + " " + otp);
        return verifyEmail.getOtp().equals(otp);
    }

    public static void main(String[] args) {
        String email = "6251071116@st.utc2.edu.vn";
        sendOTP(email);
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter otp for " + email+": ");
        String otp = sc.next();
        System.out.println(verifyOTP(email, otp));
    }
}
