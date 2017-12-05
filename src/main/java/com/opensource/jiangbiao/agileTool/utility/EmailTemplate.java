package com.opensource.jiangbiao.agileTool.utility;




import com.opensource.jiangbiao.agileTool.utility.Security.EncrypAES;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;

/**
 * Created by p2vdug on 9/22/2017.
 */


public class EmailTemplate {

    private static  String activeUrl = "http://localhost:9999/ContentPortal/active";
    private static  String resetUrl =  "http://localhost:9999/ContentPortal/reset";


    public static void createActiveMessage(String account,String toEmail, String sendAccount,MimeMessageHelper message){
        try {
            EncrypAES aes = new EncrypAES();
            message.setFrom(sendAccount);
            message.setTo(toEmail);
            message.setSubject("Activate the Account");
            StringBuilder sb = new StringBuilder();
            sb.append("please click on the link to complete the account activation");
            sb.append("\n");
            sb.append(activeUrl+"?account=");
            sb.append(aes.Encrytor(account));
            sb.append("&startTime=");
            sb.append(aes.Encrytor(TimeFormat.getCurrentTime()));
            message.setText(sb.toString());
            System.out.println(sb.toString());
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Send Message Error!");
        }

    }

    public static void createRestPasswordMessage(String account,String toEmail,String sendAccount,MimeMessageHelper message){
        try {
        EncrypAES aes = new EncrypAES();
        message.setFrom(sendAccount);
        message.setTo(toEmail);
        message.setSubject("Reset the Password");
        StringBuilder sb = new StringBuilder();
        sb.append("please click on the link to reset the password");
        sb.append("\n");
        sb.append(aes.Encrytor(account));
        sb.append("&startTime=");
        sb.append(aes.Encrytor(TimeFormat.getCurrentTime()));
            message.setText(sb.toString());
            System.out.println(sb.toString());
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Send ResetPassword Error");
        }


    }


}
