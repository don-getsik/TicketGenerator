package pl.edu.wat.wcy.isi.ai;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailClient {

    private static String FROM = "filharmonia.narodowa@o2.pl";
    private Message message;

    private Properties prop () {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.host", "poczta.o2.pl");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.ssl.trust", "poczta.o2.pl");
        return prop;
    }

    private Session makeSession() {
        return Session.getInstance(prop(), new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("filharmonia.narodowa@o2.pl",
                        "MojeWlasneHaslo123");
            }
        });
    }

    private Message prepareMessage(String to) throws MessagingException, IOException {
        Message message = new MimeMessage(makeSession());
        message.setFrom(new InternetAddress(FROM));
        message.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject("Bilety do Filharmonii");

        String msg = "W zalaczniku znajduje się twoj bilet";

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msg, "text/html");

        MimeBodyPart attachmentBodyPart = new MimeBodyPart();
        attachmentBodyPart.attachFile(new File("./resources/bilet.pdf"));

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);
        multipart.addBodyPart(attachmentBodyPart);

        message.setContent(multipart);
        return message;
    }

    public EmailClient (String to) {
        try {
            message = prepareMessage(to);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send () {
        try {
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

}
