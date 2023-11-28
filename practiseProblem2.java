import acm.program.ConsoleProgram;

//კონსოლიდან შემოდის ტექსტი. დაბეჭდეთ True თუ ტექსტში არსებული ყველა lowercase ინგლისური ასო ზრდადობით არის დალაგებული, False თუ არაა.
//ტექსტში სხვა სიმბოლოებიც შეიძლება შეგხვდეთ და იმათ ყურადღება არ მიაქციოთ. 
//მაგ: “a bcAAA!” -> true, “” -> true “ABCDz,a” -> false (Practice02)
//Tags: String, char, charOperations, isLowerCase   

public class practiseProblem2 extends ConsoleProgram{
	public void run(){
		String str = "a bcAAAA!";
		Boolean isOrNot = check(str);
		println(isOrNot);
	}

	private Boolean check(String str) {
		String str2 = "";
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
				str2 += str.charAt(i);
			}
		}
		for(int i = 0; i < str2.length() - 1; i++){
			if(str2.charAt(i) > str2.charAt(i + 1)){
				return false;
			}
		}
		return true;
	}
}
