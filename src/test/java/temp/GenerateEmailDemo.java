package temp;

import java.util.Date;

public class GenerateEmailDemo {

	public static void main(String[] args) {
		
		Date date = new Date();
		String dateString = date.toString();
		String noSpace = dateString.replaceAll("\\s", "");
		String finalDate = noSpace.replaceAll("\\:","");
		String email = finalDate+"@gmail.com";
		System.out.println(email);
	}

}
