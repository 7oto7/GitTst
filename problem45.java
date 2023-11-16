
//მომხმარებელს კონსოლიდან შეჰყავს ტექსტი და სიმბოლო, თქვენმა პროგრამამ უნდა იპოვოს
//რამდენჯერ გვხვდება მოცემულ ტექსტში მოცემული სიმბოლო
import acm.program.ConsoleProgram;

public class problem45 extends ConsoleProgram {
	public void run() {
		int count = 0;
		String text = readLine("Enter text: ");
		String symbol = readLine("Enter char: ");
		char firstChar = symbol.charAt(0);

		for (int i = 0; i < text.length(); i++) {
			char same = text.charAt(i);
			if (same == firstChar) {
				count++;
			}
		}
		println(count);
	}
}
