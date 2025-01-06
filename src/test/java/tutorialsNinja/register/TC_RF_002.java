package tutorialsNinja.register;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.search.FlagTerm;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC_RF_002 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.xpath("//span[text()='Hello, sign in']")).click();
		driver.close();
		// Gmail IMAP server details
		String host = "imap.gmail.com";
		String port = "993";
		String email = "email4pkanak@gmail.com";
		String appPasscode = "hwql etof fofv rfvn";
		
		try {
        // Set up the properties for connecting to Gmail
        Properties properties = new Properties();
        properties.put("mail.store.protocol", "imaps");
        properties.put("mail.imap.host", host);
        properties.put("mail.imap.port", port);
        properties.put("mail.imap.ssl.enable", "true");
     // Create a session and connect to Gmail
        Session session = Session.getDefaultInstance(properties);
        
            // Get the store object and connect to the Gmail account
            Store store = session.getStore("imaps");
            store.connect(host, email, appPasscode);

            // Get the inbox folder
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY); // Open the inbox in read-only mode
            Message[] messages = inbox.getMessages();
            
            // Print out details for each message
            boolean found = false;
            for (int i = messages.length - 1; i>=0; i--) {
                Message message = messages[i];
                if(message.getSubject().contains("Don't forget to collect order 4065403121")) {
                	found = true;
              
                String subject = message.getSubject();
                String from = ((InternetAddress) message.getFrom()[0]).getAddress();
                String body = getTextFromMessage(message);
             // Output email details
                System.out.println("Subject: " + subject);
                System.out.println("From: " + from);
                System.out.println("Body: " + body);
                System.out.println("-----------------------------------");
                
                }
		
	}
            inbox.close(false);
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	private static String getTextFromMessage(Message message) throws Exception {
        String result = "";
		if (message.isMimeType("text/plain")) {
            result= message.getContent().toString();
        } else if (message.isMimeType("multipart/*")) {
            MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
            // You can handle HTML content as needed
        } 
            return result;
        }
	
}


