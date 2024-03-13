/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class SendMail {

    // Hàm gửi email 
    public static void send(String to, String code) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.office365.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            // Email gửi 
            String username = "polybop1@hotmail.com";
            String password = "12345678@aa";
            Session s = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                    return new javax.mail.PasswordAuthentication(username, password);
                }
            });
            // Nội dung email  
            String tittle = "Quên Mật Khẩu - PoLyBop";
            // 
            Message msg = new MimeMessage(s);
            msg.setFrom(new InternetAddress(username));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            msg.setSubject(tittle);
            msg.setText("Mã OTP:" + code);
            Transport.send(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Tạo số ngẫu nhiên 
    public static String randum() {
        Random rd = new Random();
        int numberCode = rd.nextInt(1000) + 1000;
        return String.valueOf(numberCode);
    }

    public static void main(String[] args) {
        send("dh2k4k@gmail.com", randum());
    }
}
