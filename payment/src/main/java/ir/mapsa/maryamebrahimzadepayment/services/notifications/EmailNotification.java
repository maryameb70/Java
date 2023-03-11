package ir.mapsa.maryamebrahimzadepayment.services.notifications;

import org.springframework.stereotype.Service;

@Service
public class EmailNotification implements BaseNotification{
    @Override
    public void notifyUser(NotificationText text) {
        System.out.println("Email is send .. .  . \n " + text);
    }
//    @Override
//    public void notifyUser() {
////        String from = "maryamebz1399@gmail.com";
////        String to = "ma.ebrahimzadeh@gmail.com";
////
////        String host = "localhost";
////
////        Properties properties = System.getProperties();
////
////        properties.setProperty("mail.smtp.host", host);
////        properties.put("mail.smtp.socketFactory.port", "465");
////        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
////        properties.put("mail.smtp.auth", "true");
////        properties.put("mail.smtp.port", "465");
////        properties.put("mail.smtp.host", "smtp.gmail.com");
////
////        Session session = Session.getDefaultInstance(properties);
////
////        try {
////            MimeMessage message = new MimeMessage(session);
////
////            message.setFrom(new InternetAddress(from));
////
////            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
////
////            message.setSubject("This is the Subject Line!");
////
////            message.setText("This is actual message");
////
////            Transport.send(message);
////            System.out.println("Sent message successfully....");
////        } catch (MessagingException mex) {
////            mex.printStackTrace();
////        }
//    }
}
