import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

public class tokenizer extends ConsoleProgram{
	//static boolean isLetterOrDigit;
	public void run(){
//		String text = "mari 2 3 4 5";
//		StringTokenizer tokenizer = new StringTokenizer(text);
//		
//		while(tokenizer.hasMoreTokens()){
//			String currToken = tokenizer.nextToken();
//			println(currToken);
//		}
		char chr = ')';
		if(Character.isLetterOrDigit(chr)){
			println("is digit");
		} else {
			println("is letter");
		}
		println((int)chr);
		
		
	}
}
//////50,51,52