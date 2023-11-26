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
		
		String sentence = "!this  1-s b8d!";
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
	        int a = 0;
	        if(!countAll(token, '!', ',', '.')){
	            return false;
	        }
	        for(int i = 0; i < token.length(); i++){
	            char curr = token.charAt(i);
	            if(curr >= '0' && curr <= '9'){
	                return false;
	            } else if(curr == '!' && i != token.length() - 1){
	                return false;
	            } else if(curr == '.' && i != token.length() - 1){
	                return false;
	            } else if(curr == ',' && i != token.length() - 1){
	                return false;
	            } else if(curr == '-' && (i == 0 || i == token.length() - 1)){
	                return false;
	            } else if(curr == '-'){
	                a++;
	                if(a == 2){
	                    return false;
	                }
	            } else if(curr == ' '){
	                if(token.length() == 1){
	                    return true;
	                }

	            }
	        }
	        return true;
	    }
	    private boolean countAll(String token, char c, char a, char b){
	        int k = 0;
	        for(int i = 0; i < token.length(); i++){
	            if(token.charAt(i) == c || token.charAt(i) == a || token.charAt(i) == b){
	                k++;
	            }
	        }
	        return !(k == 2);
	    }
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
	
	
	

//////50,51,52