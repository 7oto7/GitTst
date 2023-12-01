
//დაწერეთ მეთოდი რომელიც გადაცემული ტექსტიდან შლის დუბლირებულ სიმბოლოებს,
//ანუ თუ ტექსტიში რომელიმე სიმბოლო მეორდება, უნდა დარჩეს მხოლოდ ყველაზე მარცხენა.
import acm.program.ConsoleProgram;

public class problem51 extends ConsoleProgram {
	public void run() {
		String str = "strst";
		String sttt = str.substring(0, 0);
		println(sttt);
//		String str = readLine("Enter text: ");
//		String changedStr = changeString(str);
//		println(changedStr);
	}

	private String changeString(String str) {
		String result = " ";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if(str.indexOf(ch) == i){  ////////1/////////
			result += ch;
			}
			
//			if(!result.contains("" + ch)){ /////////2//////////char is stringad gadaketeba ("" + ch)
//				result += ch;
//			}
			
		}
		return result;
	}
}


///////43b gaarchiet
