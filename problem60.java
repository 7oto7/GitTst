import java.util.ArrayList;
import java.util.Arrays;

import acm.program.ConsoleProgram;
//კონსოლიდან შეგვყავს რიცხვები მანამ სანამ არ შეიყვანთ -1-ს, დაბეჭდეთ შეყვანილი
//რიცხვები შებრუნებული მიმდევრობით.
public class problem60 extends ConsoleProgram{
	private ArrayList<Integer> list = new ArrayList<Integer>() ;
	//private ArrayList<Integer> reversed = new ArrayList<Integer>();
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
//		String reversed = "";
		int[] reversed = new int[list2.size()];
		for(int i = list2.size() - 1; i >= 0; i--){
//			reversed = reversed + " " + list2.get(i);
			reversed[list2.size() - 1 - i] = list2.get(i);
		}

		return Arrays.toString(reversed);
	}
}
