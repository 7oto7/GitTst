import acm.program.ConsoleProgram;

public class prprr extends ConsoleProgram{
	public void run(){
		String s = "abcabc";
		Boolean b = repeatedSubstringPattern(s);
		println(b);
		}
	public boolean repeatedSubstringPattern(String s) {
	    //     if(s.length() > 1){
	    //         for(int j = 1; j < s.length(); j++){
	    //             String sub = s.substring(0, j);
	    //             String result = s.replace(sub, "");
	    //             if(result.isEmpty()){
	    //                 return true;
	    //             }
	    //         }
	    //     } 
	    // return false; 

	        String doubled = s + s;
	        String sub = doubled.substring(1, doubled.length() - 1);
	        return sub.contains(s);
	     }
}
