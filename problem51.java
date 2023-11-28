
//დაწერეთ მეთოდი რომელიც გადაცემული ტექსტიდან შლის დუბლირებულ სიმბოლოებს,
//ანუ თუ ტექსტიში რომელიმე სიმბოლო მეორდება, უნდა დარჩეს მხოლოდ ყველაზე მარცხენა.
import acm.program.ConsoleProgram;

public class problem51 extends ConsoleProgram {
	public void run() {
		String str = readLine("Enter text");
		String changedStr = changeString(str);
	}

	private String changeString(String str) {
		String result = " ";
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				
			}
		}
		return null;
	}
}
