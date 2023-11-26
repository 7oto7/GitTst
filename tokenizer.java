import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

public class tokenizer extends ConsoleProgram{
	//static boolean isLetterOrDigit;
	public void run(){
//		String s = "6320000060155576064433475194277496015965584784508346180457590630139671509042003";
//		String str = removeTrailingZeros(s);
//		println(str);
		
		
		
		
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
//			
//		}
		
		
		
//		char chr = ')';
//		if(Character.isLetterOrDigit(chr)){
//			println("is digit ot leter");
//		} else {
//			println("is not digit or letter");
//		}
//		println((int)chr);
		
		String sentence = "cat and  dog";
		int c = countValidWords(sentence);
		println(c);
		
		
	}
	
	public int countValidWords(String sentence) {
        int count = 0;
        StringTokenizer tokenizer = new StringTokenizer(sentence);
        while(tokenizer.hasMoreTokens()){
            String token = tokenizer.nextToken();
                if(isValid(token)){
                    count++;
                }
        }
        return count;
    }
    private boolean isValid(String token){
        for(int i = 0; i < token.length(); i++){
        	char currChar = token.charAt(i);
            if(currChar >= '0' && currChar <= '9'){
                return false;
            } else if(currChar =='!' && i != token.length() - 1){
                return false;
            } else if(currChar =='.' && i != token.length() - 1){
                return false;
            } else if(currChar ==',' && i != token.length() - 1){
                return false;
            }
            if(currChar == '-' && (token.indexOf('-') == 0 || token.indexOf('-') == token.length() - 1)){
                return false;
            } else {
                return true;
            }
        }
        return true;
    }
	
//	public String freqAlphabets(String s) {
//        String str = "";
//        for(int i = 0; i < s.length(); i++){
//            if(i + 2 < s.length() && s.charAt(i + 2) == '#'){
//                int a = s.charAt(i) - '0';
//                int b = s.charAt(i + 1) - '0';
//                int c = a * 10 + b;
//                char d = (char)('a' + (c - 1)) ;
//                i = i + 2;
//                str = str + d;
//            } else {
//                int a = s.charAt(i) - '0';  
//                char b = (char)('a' + (a - 1));
//                str = str + b;         
//             }
//        }
//        return str;
//    }
//	
	
//	public String removeTrailingZeros(String num) {
//        String str = "";
//        for(int i = num.length(); i > 1; i--){
//            String zero = "";
//            for(int j = 0; j < i; j++){
//                zero += '0';
//            }
//            if(num.contains(zero)){
//                num = num.replace(zero, "k");
//            }
//        }
//        for(int i = 0; i < num.length(); i++){
//            if(num.charAt(i) != 'k'){
//                str += num.charAt(i);
//            }
//        }
//        return str;
//    }
	
	
	
}
//////50,51,52