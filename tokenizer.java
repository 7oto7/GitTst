import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

public class tokenizer extends ConsoleProgram{
	//static boolean isLetterOrDigit;
	public void run(){
		
		String mainString = "Hello, world!";
        String substring = "hello";

        // Using indexOf to find the index of the substring
        int index = mainString.indexOf(substring);

        // Displaying the result
        if (index != -1) {
            System.out.println("Substring '" + substring + "' found at index: " + index);
        } else {
            System.out.println("Substring '" + substring + "' not found in the main string.");
        }
		
		
//		char chr = 'A';
//		char chrs = Character.toLowerCase(chr);
//		println(chrs);
		
//		for(char ch = 'a'; ch <= 'z'; ch++){
//			char upper = Character.toUpperCase(ch);
//			println(upper);
//		}
		
		
		
//		String text = "mari 2 3 4 5";
//		StringTokenizer tokenizer = new StringTokenizer(text);
//		
//		while(tokenizer.hasMoreTokens()){
//			String currToken = tokenizer.nextToken();
//			println(currToken);
//		}
		
		
		
//		char chr = ')';
//		if(Character.isLetterOrDigit(chr)){
//			println("is digit ot leter");
//		} else {
//			println("is not digit or letter");
//		}
//		println((int)chr);
		
		
		
		
		
	}
}
//////50,51,52