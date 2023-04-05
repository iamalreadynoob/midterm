package communication;

import database.Communicator;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.ArrayList;
import java.util.Properties;

public class Email extends Communicator
{
    private String adminID,sender, text, password;
    private ArrayList<String> receiver;
    private MimeBodyPart attachment;
    private boolean isAttached;
    public Email(String sender, String adminID, ArrayList<String> receiver, String text)
    {
        super("data/admins.txt");

        this.adminID = adminID;
        this.sender = sender;
        this.receiver = receiver;
        this.text = text;

        attachment = new MimeBodyPart();
        isAttached = false;

        checkReserved();
        password = getPassword();
        smtp();
    }

    private void smtp()
    {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp-mail.outlook.com");
        properties.put("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");

        try
        {
            Authenticator auth = new javax.mail.Authenticator()
            {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(sender, password);
                }
            };

            Session session = Session.getInstance(properties, auth);

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));

            for (String r: receiver) {message.addRecipient(Message.RecipientType.TO, new InternetAddress(r));}

            message.setSubject("COMMUNICATOR");
            message.setText(text);

            if (isAttached)
            {
                MimeMultipart multipart = new MimeMultipart();
                multipart.addBodyPart(attachment);
                message.setContent(multipart);
            }

            Transport.send(message);

        }catch (MessagingException e){e.printStackTrace();}
    }

    private String getPassword()
    {
        String password = null;

        String admins = getRawData();

        for (int i = 0; i < admins.length(); i++)
        {
            if (admins.charAt(i) == adminID.charAt(0))
            {
                if (i >= 1 && admins.charAt(i-1) == '{' && admins.charAt(i+1) == '}')
                {
                    int loc = i+2;

                    while (loc < admins.length() && admins.charAt(loc) != '{')
                    {
                        if (password == null) password = Character.toString(admins.charAt(loc));
                        else password += Character.toString(admins.charAt(loc));

                        loc++;
                    }

                    break;
                }
            }
        }

        return password;
    }

    private void checkReserved()
    {
        if (!new ReservedShortcuts().isCommand(text))
        {
            if (text.startsWith("/test"))
            {
                text = "The test message doesn't mean garbage all to time! At least, just for this time. (Hint: check the attachment)";

                File attachedFile = new File("data/never-gonna-give-you-up.docx");
                FileDataSource source = new FileDataSource(attachedFile);

                try
                {
                    attachment.setDataHandler(new DataHandler(source));
                    attachment.setFileName(attachedFile.getName());
                    isAttached =true;
                }catch (Exception e){e.printStackTrace();}
            }
        }
    }

}
