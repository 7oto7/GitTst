import java.util.ArrayList;

import acm.program.ConsoleProgram;
//კონსოლიდან შეგვყავს რიცხვები მანამ სანამ არ შეიყვანთ -1-ს, დაბეჭდეთ შეყვანილი
//რიცხვები შებრუნებული მიმდევრობით.
public class problem60 extends ConsoleProgram{
	private ArrayList<Integer> list = new ArrayList<Integer>() ;
	//private ArrayList<Integer> reversed;
	public void run(){
		while(true){
			int n = readInt("Enter number: ");
			if(n == -1){
				break;
			}
			list.add(n);
		}
		String reversedString = reversedList(list);
		println(reversedString);
	}
	private String reversedList(ArrayList<Integer> list2) {
		String reversed = "";
		for(int i = list2.size(); i >= 0; i--){
			reversed = i + " ";
		}
		
		return reversed;
	}
}
