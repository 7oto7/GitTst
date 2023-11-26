import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

public class tokenizer extends ConsoleProgram{
	//static boolean isLetterOrDigit;
	public void run(){
		String s = "10#11#12";
		String str = freqAlphabets(s);
		println(str);
//		String s = "a";
//		String str = "";
//        for(int i = 0; i < s.length(); i++){
//            if(i % 2 == 0){
//                str = str + s.charAt(i);
//            } else {
//                int a = s.charAt(i) - '0';
//                char b = (char) (s.charAt(i - 1) + a);
//                str = str + b;
//            }
//        }
		
//		String mainString = "Hello, world!";
//        char substring = 'z';
//        String upper = mainString.toUpperCase();
//        println(upper + mainString);
//
//        // Using indexOf to find the index of the substring
//        int index = mainString.indexOf(substring, 4);
//
//        // Displaying the result
//        if (index != -1) {
//            println("Substring '" + substring + "' found at index: " + index);
//        } else {
//            println("Substring '" + substring + "' not found in the main string.");
//        }
		
		
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
	public String freqAlphabets(String s) {
        String str = "";
        for(int i = 0; i < s.length() - 2; i++){
            if(s.charAt(i + 2) == '#'){
                int a = s.charAt(i) - '0';
                int b = s.charAt(i + 1) - '0';
                int c = a * 10 + b;
                char d = (char)('a' + (c - 1)) ;
                str = str + d;
            } else if(s.charAt(i + 2) != '#' && s.charAt(i + 1) != '#'){
                int a = s.charAt(i) - '0';  
                char b = (char)('a' + (a - 1));
                str = str + b;         
             }
        }
        return str;
    }
}
//////50,51,52