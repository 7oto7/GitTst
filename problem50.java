import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

//შეყვანილ ტექსტში დათვალეთ სიტვყების რაოდენობა, ტოკენაიზერის საშუალებით.
public class problem50 extends ConsoleProgram{
	public void run(){
		String text = readLine("Enter text: ");
		int count = countWords(text);
	}

	private int countWords(String text) {	
		int count = 0;
		StringTokenizer tokenizer = new StringTokenizer(text);
		while(tokenizer.hasMoreTokens()){
			count++;
		}
		return count;
	}
}
