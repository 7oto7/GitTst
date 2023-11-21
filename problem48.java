import acm.program.ConsoleProgram;

//კონსოლიდან შეგყვავს ტექსტი პროგრამამ უნდა დაბეჭდოს სტატისტიკა რომელი სიმბოლო
//რამდენჯერ გვხვდება
public class problem48 extends ConsoleProgram{
	public void run(){
		String text = "mariami";
		printCharStatistics(text);
	}

	private void printCharStatistics(String text) {
		for(int i = 0; i < text.length(); i++){
			int count = countSymbol(text, text.charAt(i));
			print(text.charAt(i) + ": " + count);
		}
	}
	private int countSymbol(String text, char symbol) {
		int symbolCount = 0;
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == symbol) {
				symbolCount++;
			}
		}
		return symbolCount;
	}
}
