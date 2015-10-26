import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Reverse {

	public static void main(String[] args) throws FileNotFoundException {
		String mapping = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_.";
		Scanner sc = new Scanner(new File("input.txt"));
		System.setOut(new PrintStream(new File("output.txt")));
		
		while(true)
		{
			String origMessage = new String();
			String message = new String();
			String finalMessage = new String();
			int rot = sc.nextInt();
			
			// End case
			if (rot == 0)
				break;
			
			origMessage = sc.next();
			
			// Reverse the message.
			for (int i = 0; i < origMessage.length(); i++)
			{
				message += origMessage.charAt(origMessage.length()-1-i);
			}
			
			// Rotate each character in the message
			for (int i = 0; i < message.length(); i++)
			{
				// Get the index of the character in mapping
				int index = mapping.indexOf(message.charAt(i));
				
				// Adjust the index and get the new character
				index = (rot + index) % mapping.length();
				finalMessage += mapping.charAt(index);
			}
			
			System.out.println(finalMessage);
		}
	}
}
