
//მომხმარებელს კონსოლიდან შეჰყავს ტექსტი და სიმბოლო, თქვენმა პროგრამამ უნდა იპოვოს
//რამდენჯერ გვხვდება მოცემულ ტექსტში მოცემული სიმბოლო
import acm.program.ConsoleProgram;

public class problem45 extends ConsoleProgram {
	public void run() {
		
		String text = readLine("Enter text: ");
		String symbol = readLine("Enter char: ");
		char firstChar = symbol.charAt(0);
		int count = countSymbol(text, firstChar);
		
		
		println(count);
	}

	private int countSymbol(String text, char firstChar) {
		int count = 0;
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == firstChar) {
				count++;
			}
		}
		return count;
	}
}
