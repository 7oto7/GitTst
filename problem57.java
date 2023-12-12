//დაწერეთ მეთოდი, რომელსაც გადაეცემა ორი სტრინგი და აბრუნებს true-ს თუკი ეს ორის
//სტრინგი ერთმანეთის ანაგრამაა, ხოლო წინააღმდე შემთხვევაში აბრუნებს false-ს. ჩათვალეთ,
//რომ ორივე სტრინგი მხოლოდ ლათინური ალფავიტის პატარა ასოებისგან შედგება.
//იმპლემენტაცია გააკეთეთ მასივების გამოყენებით შემდეგი ალგორითმით: თითოეული
//სიტყვისთვის დათვალეთ თითოეული სიმბოლოს რაოდენობა(‘a’-‘z’) და შეინახეთ მასივში.
//შემდეგ შეადარეთ ერთმანეთს მასივები.
import java.util.Arrays;

import acm.program.ConsoleProgram;

public class problem57 extends ConsoleProgram{
	public void run(){
		String str1 = "mariam";
		String str2 = "mariam";
		println(areAnagrams(str1, str2));
	}

	private Boolean areAnagrams(String str1, String str2) {
		if(str1.equals(str2)){
			return true;
		}
		int[] counts1 = getCountArray(str1);
		int[] counts2 = getCountArray(str2);
		
		return Arrays.equals(counts1, counts2);
	}

	private int[] getCountArray(String str1) {
		
		return null;
	}
}
