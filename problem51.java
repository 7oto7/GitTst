
//დაწერეთ მეთოდი რომელიც გადაცემული ტექსტიდან შლის დუბლირებულ სიმბოლოებს,
//ანუ თუ ტექსტიში რომელიმე სიმბოლო მეორდება, უნდა დარჩეს მხოლოდ ყველაზე მარცხენა.
import acm.program.ConsoleProgram;

public class problem51 extends ConsoleProgram {
	public void run() {
		String str = readLine("Enter text: ");
		String changedStr = changeString(str);
		println(changedStr);
	}

	private String changeString(String str) {
		String result = " ";
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(str.indexOf(i) == i){
			result += ch;
			}
//			if(!result.contains("" + ch)){    //char is stringad gadaketeba ("" + ch)
//				result += ch;
//			}
		}
		return result;
	}
}
