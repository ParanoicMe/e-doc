package e.doc.service.mail;

import e.doc.service.config.PropertiesImpl;
import e.doc.service.config.PropertyE;
import e.doc.service.exception.ServiceErrorCode;
import e.doc.service.exception.ServiceException;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class ServiceMail {
    //Service service = new ServiceImpl();
    Properties properties = new PropertiesImpl().getProperty(PropertyE.APP);
    final String user = properties.getProperty("mail.user");
    final String password = properties.getProperty("mail.password");

    public ServiceMail() {
    }

    public void sendMail(String messageText, PostGroup group, String subectText) throws ServiceException{
        String to = properties.getProperty("mail." + group + ".group");// sender email
        //System.out.println("mail." + group + ".group + to - " + to);
        String host = properties.getProperty("mail.host");            // mail server host

        Properties prop = new Properties();
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.auth", true);
        //ed0cPa$$

        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        }); // default session

        try {
            MimeMessage message = new MimeMessage(session); // email message

            message.setFrom(new InternetAddress(user)); // setting header fields

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            message.setSubject(subectText == "" ? properties.getProperty("mail.subject.def") : subectText); // subject line

            // actual mail body
            message.setText(messageText);

            // Send message
            Transport.send(message);
            //System.out.println("Email Sent successfully....");
        } catch (MessagingException mex) {
            throw new ServiceException(mex, ServiceErrorCode.HU_SERVICE_013);
        }

    }
}
